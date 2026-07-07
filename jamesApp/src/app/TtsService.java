package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.SwingUtilities;

/**
 * 원본 HTML의 window.speechSynthesis(브라우저 내장 TTS)와 동일하게
 * "운영체제에 이미 설치된 음성"을 그대로 사용하는 방식으로 구현한 TTS 서비스.
 *
 *   - macOS   : 내장 'say' 명령어 사용 (한국어 'Yuna' 음성이 기본 내장되어 있음)
 *   - Windows : PowerShell + System.Speech.Synthesis (SAPI) 사용
 *               ※ 한국어 음성이 별도로 설치되어 있지 않다면 한국어 재생이 안 될 수 있음
 *                 (설정 > 시간 및 언어 > 음성 에서 한국어 음성팩 추가 필요)
 *   - Linux   : espeak-ng(또는 espeak) 사용 (품질은 낮지만 무료/오프라인)
 *
 * 브라우저처럼 "설치된 음성 목록에서 자동으로 한국어/영어 음성을 찾아 선택"하는
 * loadVoices() 로직을 동일하게 재현한다.
 */
public class TtsService {

    public enum Os { WINDOWS, MAC, LINUX, UNKNOWN }

    private final Os os;
    private final AtomicReference<Process> currentProcess = new AtomicReference<>();

    private List<String> koreanVoices = new ArrayList<>();
    private String selectedKoreanVoice = null; // null이면 OS 기본 음성 사용
    private String englishVoice = null;

    public TtsService() {
        this.os = detectOs();
        discoverVoices();
    }

    public Os getOs() {
        return os;
    }

    private static Os detectOs() {
        String name = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
        if (name.contains("win")) return Os.WINDOWS;
        if (name.contains("mac") || name.contains("darwin")) return Os.MAC;
        if (name.contains("nux") || name.contains("nix")) return Os.LINUX;
        return Os.UNKNOWN;
    }

    /** 사용 가능한 한국어 음성 목록 (콤보박스 채우기용) */
    public List<String> getKoreanVoices() {
        return koreanVoices;
    }

    public void setSelectedKoreanVoice(String name) {
        this.selectedKoreanVoice = name;
    }

    // ------------------------------------------------------------------
    // 음성 자동 탐색 (원본 loadVoices()에 대응)
    // ------------------------------------------------------------------
    private void discoverVoices() {
        try {
            switch (os) {
                case MAC -> discoverMacVoices();
                case WINDOWS -> discoverWindowsVoices();
                case LINUX -> discoverLinuxVoices();
                default -> { /* 목소리 탐색 불가 - 기본값 사용 */ }
            }
        } catch (Exception e) {
            System.err.println("[TTS] 음성 목록 탐색 실패: " + e.getMessage());
        }

        // 원본처럼 'Yuna'(유나) 우선 선택
        if (!koreanVoices.isEmpty()) {
            selectedKoreanVoice = koreanVoices.stream()
                    .filter(v -> v.toLowerCase(Locale.ROOT).contains("yuna") || v.contains("유나")
                            || v.toLowerCase(Locale.ROOT).contains("heami"))
                    .findFirst()
                    .orElse(koreanVoices.get(0));
        }
    }

    private void discoverMacVoices() throws Exception {
        Process p = new ProcessBuilder("say", "-v", "?").start();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = r.readLine()) != null) {
                // 예: "Yuna               ko_KR    # 안녕하세요! 제 이름은 유나입니다."
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 2) continue;
                String name = parts[0];
                String locale = parts[1];
                if (locale.toLowerCase(Locale.ROOT).startsWith("ko")) {
                    koreanVoices.add(name);
                } else if (englishVoice == null && locale.toLowerCase(Locale.ROOT).startsWith("en_us")) {
                    englishVoice = name;
                }
            }
        }
        p.waitFor();
        if (englishVoice == null) englishVoice = "Samantha";
    }

    private void discoverWindowsVoices() throws Exception {
        String script =
                "Add-Type -AssemblyName System.Speech; " +
                "$s = New-Object System.Speech.Synthesis.SpeechSynthesizer; " +
                "$s.GetInstalledVoices() | ForEach-Object { $_.VoiceInfo.Name + '|' + $_.VoiceInfo.Culture.Name }";
        Process p = new ProcessBuilder("powershell", "-NoProfile", "-Command", script).start();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = r.readLine()) != null) {
                String[] parts = line.trim().split("\\|");
                if (parts.length < 2) continue;
                String name = parts[0];
                String culture = parts[1].toLowerCase(Locale.ROOT);
                if (culture.startsWith("ko")) {
                    koreanVoices.add(name);
                } else if (englishVoice == null && culture.startsWith("en")) {
                    englishVoice = name;
                }
            }
        }
        p.waitFor();
    }

    private void discoverLinuxVoices() throws Exception {
        // espeak-ng가 없으면 espeak을 시도
        String bin = commandExists("espeak-ng") ? "espeak-ng" : (commandExists("espeak") ? "espeak" : null);
        if (bin == null) return;
        Process p = new ProcessBuilder(bin, "--voices=ko").start();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            boolean first = true;
            while ((line = r.readLine()) != null) {
                if (first) { first = false; continue; } // 헤더 라인 스킵
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 4) {
                    koreanVoices.add(parts[3]); // VoiceName 컬럼
                }
            }
        }
        p.waitFor();
        englishVoice = "en-us";
    }

    private boolean commandExists(String cmd) {
        try {
            Process p = new ProcessBuilder("which", cmd).start();
            return p.waitFor() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    // ------------------------------------------------------------------
    // 재생
    // ------------------------------------------------------------------

    /**
     * 텍스트를 비동기로 읽고, 다 읽으면 onDone 콜백을 EDT(Event Dispatch Thread)에서 호출한다.
     * @param speed 0.5 ~ 1.2 (원본 슬라이더와 동일한 배속 값)
     */
    public void speak(String text, boolean isKorean, double speed, Runnable onDone) {
        Thread t = new Thread(() -> {
            try {
                ProcessBuilder pb = buildProcess(text, isKorean, speed);
                if (pb == null) {
                    // 이 환경에서는 재생할 방법이 없음 - 잠깐 대기 후 완료 처리
                    Thread.sleep(300);
                } else {
                    pb.redirectErrorStream(true);
                    Process p = pb.start();
                    currentProcess.set(p);
                    // 출력은 버려서 파이프가 막히지 않도록 함
                    try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                        while (r.readLine() != null) { /* discard */ }
                    }
                    p.waitFor();
                    currentProcess.set(null);
                }
            } catch (InterruptedException ie) {
                // stop()에 의해 중단됨 - 정상
            } catch (Exception e) {
                System.err.println("[TTS] 재생 오류: " + e.getMessage());
            } finally {
                SwingUtilities.invokeLater(onDone);
            }
        }, "tts-speak-thread");
        t.setDaemon(true);
        t.start();
    }

    /** 현재 재생 중인 음성을 즉시 중단 */
    public void stop() {
        Process p = currentProcess.getAndSet(null);
        if (p != null && p.isAlive()) {
            p.destroy();
        }
    }

    private ProcessBuilder buildProcess(String text, boolean isKorean, double speed) {
        switch (os) {
            case MAC: {
                String voice = isKorean ? (selectedKoreanVoice != null ? selectedKoreanVoice : "Yuna")
                                         : (englishVoice != null ? englishVoice : "Samantha");
                int wpm = clamp((int) Math.round(200 * speed), 90, 300);
                return new ProcessBuilder("say", "-v", voice, "-r", String.valueOf(wpm), text);
            }
            case WINDOWS: {
                String voice = isKorean ? selectedKoreanVoice : englishVoice;
                int rate = clamp((int) Math.round((speed - 1.0) * 10), -10, 10);
                String safeText = text.replace("'", "''");
                StringBuilder script = new StringBuilder();
                script.append("Add-Type -AssemblyName System.Speech; ");
                script.append("$s = New-Object System.Speech.Synthesis.SpeechSynthesizer; ");
                if (voice != null) {
                    script.append("$s.SelectVoice('").append(voice.replace("'", "''")).append("'); ");
                }
                script.append("$s.Rate = ").append(rate).append("; ");
                script.append("$s.Speak('").append(safeText).append("');");
                return new ProcessBuilder("powershell", "-NoProfile", "-Command", script.toString());
            }
            case LINUX: {
                String bin = commandExists("espeak-ng") ? "espeak-ng" : (commandExists("espeak") ? "espeak" : null);
                if (bin == null) return null;
                String voiceCode = isKorean
                        ? (!koreanVoices.isEmpty() ? koreanVoices.get(0) : "ko")
                        : "en-us";
                int wps = clamp((int) Math.round(175 * speed), 80, 400);
                return new ProcessBuilder(bin, "-v", voiceCode, "-s", String.valueOf(wps), text);
            }
            default:
                return null;
        }
    }

    private int clamp(int v, int lo, int hi) {
        return Math.max(lo, Math.min(hi, v));
    }
}
