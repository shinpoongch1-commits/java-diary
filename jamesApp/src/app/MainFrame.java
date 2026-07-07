package app;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * 야고보서 구간반복 - 자바 데스크톱(Swing) 버전
 * 원본 HTML(야고보서_구간반복_v2.html)의 UI/로직을 그대로 이식.
 */
public class MainFrame extends JFrame {

    // ---- 데이터 & 상태 ----
    private final List<List<Verse>> james = BibleData.JAMES;
    private final TtsService tts = new TtsService();

    private int ci = 0;              // 현재 장 인덱스
    private int vi = 0;              // 현재 절 인덱스
    private boolean isKo = true;     // 현재 표시 언어(한글+영어 모드에서 토글용)
    private boolean playing = false;
    private int rep = 2;             // 반복 횟수
    private double spd = 0.82;       // 배속
    private String langMode = "ko+en"; // "ko+en" | "ko" | "en"
    private int fromVerse = 0;
    private int toVerse;

    private static class QueueItem {
        final String text;
        final boolean isKo;
        QueueItem(String text, boolean isKo) { this.text = text; this.isKo = isKo; }
    }
    private final List<QueueItem> queue = new ArrayList<>();
    private int qi = 0;

    // ---- UI 컴포넌트 ----
    private JComboBox<String> chapterSel;
    private JComboBox<String> voiceSel;
    private JToggleButton modeKoEnBtn, modeKoBtn, modeEnBtn;
    private JComboBox<Integer> fromSel, toSel;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private JLabel langBadge;
    private JTextArea verseTextArea;
    private JLabel verseRefLabel;
    private JLabel statusLabel;
    private JLabel repCountLabel;
    private JSlider speedSlider;
    private JLabel speedValLabel;
    private JButton prevBtn, playBtn, nextBtn;
    private JSlider verseSlider;
    private JLabel sliderLabel;

    private final Timer blinkTimer;
    private boolean blinkOn = true;

    public MainFrame() {
        super("야고보서 구간반복 (자바 버전)");
        toVerse = james.get(ci).size() - 1;

        buildUi();
        updateRangeSelects();
        render();

        blinkTimer = new Timer(500, e -> {
            blinkOn = !blinkOn;
            if (playing) updateStatusBlink();
        });
        blinkTimer.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(460, 780);
        setLocationRelativeTo(null);
    }

    // ------------------------------------------------------------------
    // UI 구성
    // ------------------------------------------------------------------
    private void buildUi() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.setBorder(new EmptyBorder(16, 16, 20, 16));
        root.setBackground(new Color(0xF5, 0xF4, 0xF0));
        setContentPane(root);

        JLabel title = new JLabel("야고보서 구간반복", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        root.add(title);

        JLabel subtitle = new JLabel("개역개정 · NIV 1984", SwingConstants.CENTER);
        subtitle.setForeground(Color.GRAY);
        subtitle.setFont(subtitle.getFont().deriveFont(12f));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setBorder(new EmptyBorder(2, 0, 12, 0));
        root.add(subtitle);

        // 장 선택 + 음성 선택
        JPanel topRow = new JPanel(new GridLayout(1, 2, 8, 0));
        chapterSel = new JComboBox<>();
        for (int c = 0; c < james.size(); c++) {
            chapterSel.addItem((c + 1) + "장 (" + james.get(c).size() + "절)");
        }
        chapterSel.addActionListener(e -> onChapterChanged());
        topRow.add(chapterSel);

        voiceSel = new JComboBox<>();
        List<String> koVoices = tts.getKoreanVoices();
        if (koVoices.isEmpty()) {
            voiceSel.addItem("시스템 한국어 음성 없음");
            voiceSel.setEnabled(false);
        } else {
            for (String v : koVoices) voiceSel.addItem(v);
            voiceSel.addActionListener(e -> tts.setSelectedKoreanVoice((String) voiceSel.getSelectedItem()));
        }
        topRow.add(voiceSel);
        topRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        root.add(topRow);
        root.add(Box.createVerticalStrut(10));

        // 언어 모드 탭
        JPanel modeRow = new JPanel(new GridLayout(1, 3, 6, 0));
        modeKoEnBtn = new JToggleButton("한글 + 영어", true);
        modeKoBtn = new JToggleButton("한글만");
        modeEnBtn = new JToggleButton("영어만");
        ButtonGroup grp = new ButtonGroup();
        grp.add(modeKoEnBtn); grp.add(modeKoBtn); grp.add(modeEnBtn);
        modeKoEnBtn.addActionListener(e -> setMode("ko+en"));
        modeKoBtn.addActionListener(e -> setMode("ko"));
        modeEnBtn.addActionListener(e -> setMode("en"));
        modeRow.add(modeKoEnBtn); modeRow.add(modeKoBtn); modeRow.add(modeEnBtn);
        modeRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        root.add(modeRow);
        root.add(Box.createVerticalStrut(10));

        // From / To 구간 설정
        JPanel rangeBox = new JPanel();
        rangeBox.setLayout(new BoxLayout(rangeBox, BoxLayout.Y_AXIS));
        rangeBox.setBackground(Color.WHITE);
        rangeBox.setBorder(new EmptyBorder(10, 12, 10, 12));
        JLabel rangeTitle = new JLabel("구간 설정");
        rangeTitle.setFont(rangeTitle.getFont().deriveFont(Font.BOLD, 11f));
        rangeTitle.setForeground(new Color(0xBB, 0xBB, 0xBB));
        rangeBox.add(rangeTitle);
        rangeBox.add(Box.createVerticalStrut(6));

        JPanel rangeRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        rangeRow.setOpaque(false);
        rangeRow.add(new JLabel("From"));
        fromSel = new JComboBox<>();
        rangeRow.add(fromSel);
        rangeRow.add(new JLabel("→"));
        rangeRow.add(new JLabel("To"));
        toSel = new JComboBox<>();
        rangeRow.add(toSel);
        JButton applyBtn = new JButton("설정");
        applyBtn.addActionListener(e -> applyRange());
        rangeRow.add(applyBtn);
        rangeBox.add(rangeRow);
        rangeBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        root.add(rangeBox);
        root.add(Box.createVerticalStrut(10));

        // 진행바
        JPanel progressWrap = new JPanel(new BorderLayout(8, 0));
        progressWrap.setOpaque(false);
        progressBar = new JProgressBar(0, 100);
        progressBar.setForeground(new Color(0x4A, 0x7C, 0xF7));
        progressWrap.add(progressBar, BorderLayout.CENTER);
        progressLabel = new JLabel("1 / 27");
        progressLabel.setForeground(Color.GRAY);
        progressWrap.add(progressLabel, BorderLayout.EAST);
        progressWrap.setMaximumSize(new Dimension(Integer.MAX_VALUE, 24));
        root.add(progressWrap);
        root.add(Box.createVerticalStrut(10));

        // 절 카드
        JPanel verseCard = new JPanel();
        verseCard.setLayout(new BoxLayout(verseCard, BoxLayout.Y_AXIS));
        verseCard.setBackground(Color.WHITE);
        verseCard.setBorder(new EmptyBorder(16, 14, 16, 14));
        langBadge = new JLabel("개역개정");
        langBadge.setOpaque(true);
        langBadge.setBackground(new Color(0xE8, 0xEF, 0xFE));
        langBadge.setForeground(new Color(0x3A, 0x6B, 0xE8));
        langBadge.setFont(langBadge.getFont().deriveFont(Font.BOLD, 11f));
        langBadge.setBorder(new EmptyBorder(3, 10, 3, 10));
        langBadge.setAlignmentX(Component.LEFT_ALIGNMENT);
        verseCard.add(langBadge);
        verseCard.add(Box.createVerticalStrut(10));

        verseTextArea = new JTextArea();
        verseTextArea.setLineWrap(true);
        verseTextArea.setWrapStyleWord(true);
        verseTextArea.setEditable(false);
        verseTextArea.setOpaque(false);
        verseTextArea.setFont(verseTextArea.getFont().deriveFont(16f));
        verseTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        verseCard.add(verseTextArea);
        verseCard.add(Box.createVerticalStrut(8));

        verseRefLabel = new JLabel("야고보서 1:1 / James 1:1");
        verseRefLabel.setForeground(new Color(0xAA, 0xAA, 0xAA));
        verseRefLabel.setFont(verseRefLabel.getFont().deriveFont(12f));
        verseRefLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        verseCard.add(verseRefLabel);
        root.add(verseCard);
        root.add(Box.createVerticalStrut(8));

        statusLabel = new JLabel("재생 버튼을 눌러 시작하세요", SwingConstants.CENTER);
        statusLabel.setForeground(Color.GRAY);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setFont(statusLabel.getFont().deriveFont(12f));
        root.add(statusLabel);
        root.add(Box.createVerticalStrut(8));

        // 반복 + 속도
        JPanel settingsRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        settingsRow.setOpaque(false);

        JPanel repPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 0));
        repPanel.setOpaque(false);
        JButton repMinus = new JButton("－");
        repMinus.addActionListener(e -> changeRep(-1));
        repPanel.add(repMinus);
        JPanel repMid = new JPanel();
        repMid.setLayout(new BoxLayout(repMid, BoxLayout.Y_AXIS));
        repMid.setOpaque(false);
        JLabel repCaption = new JLabel("반복", SwingConstants.CENTER);
        repCaption.setFont(repCaption.getFont().deriveFont(10f));
        repCaption.setForeground(new Color(0xBB, 0xBB, 0xBB));
        repCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        repCountLabel = new JLabel(String.valueOf(rep), SwingConstants.CENTER);
        repCountLabel.setFont(repCountLabel.getFont().deriveFont(Font.BOLD, 16f));
        repCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        repMid.add(repCaption);
        repMid.add(repCountLabel);
        repPanel.add(repMid);
        JButton repPlus = new JButton("＋");
        repPlus.addActionListener(e -> changeRep(1));
        repPanel.add(repPlus);
        settingsRow.add(repPanel);

        JPanel speedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        speedPanel.setOpaque(false);
        speedPanel.add(new JLabel("속도"));
        speedSlider = new JSlider(50, 120, (int) Math.round(spd * 100));
        speedSlider.setPreferredSize(new Dimension(100, 24));
        speedSlider.addChangeListener(e -> changeSpeed(speedSlider.getValue()));
        speedPanel.add(speedSlider);
        speedValLabel = new JLabel(String.format("%.2f×", spd));
        speedPanel.add(speedValLabel);
        settingsRow.add(speedPanel);

        settingsRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        root.add(settingsRow);
        root.add(Box.createVerticalStrut(6));

        // 컨트롤 (이전/재생/다음)
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        controls.setOpaque(false);
        prevBtn = new JButton("‹");
        prevBtn.addActionListener(e -> prevVerse());
        playBtn = new JButton("▶");
        playBtn.setFont(playBtn.getFont().deriveFont(20f));
        playBtn.setBackground(new Color(0x4A, 0x7C, 0xF7));
        playBtn.setForeground(Color.WHITE);
        playBtn.setOpaque(true);
        playBtn.setBorderPainted(false);
        playBtn.addActionListener(e -> togglePlay());
        nextBtn = new JButton("›");
        nextBtn.addActionListener(e -> nextVerse());
        controls.add(prevBtn);
        controls.add(playBtn);
        controls.add(nextBtn);
        controls.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        root.add(controls);
        root.add(Box.createVerticalStrut(6));

        // 절 슬라이더
        sliderLabel = new JLabel("1절", SwingConstants.CENTER);
        sliderLabel.setForeground(new Color(0xAA, 0xAA, 0xAA));
        sliderLabel.setFont(sliderLabel.getFont().deriveFont(12f));
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        root.add(sliderLabel);
        verseSlider = new JSlider(0, toVerse, 0);
        verseSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        verseSlider.addChangeListener(e -> {
            if (verseSlider.getValueIsAdjusting()) jumpToVerse(verseSlider.getValue());
        });
        root.add(verseSlider);
    }

    // ------------------------------------------------------------------
    // 로직 (원본 HTML의 <script> 부분 이식)
    // ------------------------------------------------------------------

    private void updateRangeSelects() {
        int total = james.get(ci).size();
        fromSel.removeAllItems();
        toSel.removeAllItems();
        for (int i = 0; i < total; i++) {
            fromSel.addItem(i);
            toSel.addItem(i);
        }
        fromSel.setRenderer(verseItemRenderer());
        toSel.setRenderer(verseItemRenderer());
        fromSel.setSelectedIndex(0);
        toSel.setSelectedIndex(total - 1);
        fromVerse = 0;
        toVerse = total - 1;
    }

    private DefaultListCellRenderer verseItemRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                            boolean isSelected, boolean cellHasFocus) {
                Object display = (value instanceof Integer) ? ((Integer) value + 1) + "절" : value;
                return super.getListCellRendererComponent(list, display, index, isSelected, cellHasFocus);
            }
        };
    }

    private void applyRange() {
        int f = (Integer) fromSel.getSelectedItem();
        int t = (Integer) toSel.getSelectedItem();
        if (f > t) {
            JOptionPane.showMessageDialog(this, "From이 To보다 클 수 없어요!");
            return;
        }
        stopPlayback();
        fromVerse = f;
        toVerse = t;
        vi = f;
        isKo = !langMode.equals("en");
        verseSlider.setMinimum(fromVerse);
        verseSlider.setMaximum(toVerse);
        render();
        statusLabel.setText((f + 1) + "절 ~ " + (t + 1) + "절 구간 설정됨");
    }

    private void setMode(String mode) {
        langMode = mode;
        stopPlayback();
        isKo = !mode.equals("en");
        render();
    }

    private void onChapterChanged() {
        stopPlayback();
        ci = chapterSel.getSelectedIndex();
        vi = 0;
        isKo = !langMode.equals("en");
        updateRangeSelects();
        verseSlider.setMinimum(fromVerse);
        verseSlider.setMaximum(toVerse);
        render();
        statusLabel.setText("재생 버튼을 눌러 시작하세요");
    }

    private void render() {
        Verse v = james.get(ci).get(vi);
        int total = james.get(ci).size();
        String text, badge;
        Color badgeBg, badgeFg;
        if (langMode.equals("ko")) {
            text = v.ko; badge = "개역개정";
            badgeBg = new Color(0xE8, 0xEF, 0xFE); badgeFg = new Color(0x3A, 0x6B, 0xE8);
        } else if (langMode.equals("en")) {
            text = v.en; badge = "NIV 1984";
            badgeBg = new Color(0xE6, 0xF9, 0xEF); badgeFg = new Color(0x1E, 0x8F, 0x52);
        } else {
            text = isKo ? v.ko : v.en;
            badge = isKo ? "개역개정" : "NIV 1984";
            badgeBg = isKo ? new Color(0xE8, 0xEF, 0xFE) : new Color(0xE6, 0xF9, 0xEF);
            badgeFg = isKo ? new Color(0x3A, 0x6B, 0xE8) : new Color(0x1E, 0x8F, 0x52);
        }
        verseTextArea.setText(text);
        verseRefLabel.setText("야고보서 " + (ci + 1) + ":" + (vi + 1) + " / James " + (ci + 1) + ":" + (vi + 1));
        langBadge.setText(badge);
        langBadge.setBackground(badgeBg);
        langBadge.setForeground(badgeFg);

        int rangeLen = toVerse - fromVerse;
        int pct = rangeLen > 0 ? Math.round(((vi - fromVerse) / (float) rangeLen) * 100) : 0;
        progressBar.setValue(Math.max(0, Math.min(100, pct)));
        progressLabel.setText((vi + 1) + " / " + total);
        sliderLabel.setText((vi + 1) + "절");
        verseSlider.removeChangeListener(verseSlider.getChangeListeners()[0]);
        verseSlider.setValue(vi);
        verseSlider.addChangeListener(e -> {
            if (verseSlider.getValueIsAdjusting()) jumpToVerse(verseSlider.getValue());
        });
    }

    private void buildQueue() {
        Verse v = james.get(ci).get(vi);
        queue.clear();
        if (langMode.equals("ko")) {
            for (int i = 0; i < rep; i++) queue.add(new QueueItem(v.ko, true));
        } else if (langMode.equals("en")) {
            for (int i = 0; i < rep; i++) queue.add(new QueueItem(v.en, false));
        } else {
            for (int i = 0; i < rep; i++) {
                queue.add(new QueueItem(v.ko, true));
                queue.add(new QueueItem(v.en, false));
            }
        }
        qi = 0;
    }

    private void speakNext() {
        if (!playing) return;
        if (qi >= queue.size()) {
            advance();
            return;
        }
        QueueItem item = queue.get(qi);
        isKo = item.isKo;
        render();
        int r = langMode.equals("ko+en") ? (qi / 2) + 1 : qi + 1;
        updateStatusPlaying(r, item.isKo);
        tts.speak(item.text, item.isKo, spd, () -> {
            if (!playing) return;
            qi++;
            Timer t = new Timer(380, e -> speakNext());
            t.setRepeats(false);
            t.start();
        });
    }

    private void updateStatusPlaying(int r, boolean korean) {
        statusLabel.setText("● " + r + "/" + rep + "회 — " + (korean ? "한국어" : "English"));
        statusLabel.setForeground(new Color(0x3E, 0xB8, 0x7A));
    }

    private void updateStatusBlink() {
        // 간단한 깜빡임 효과: 재생 중일 때 상태 텍스트 색을 토글
        if (!playing) return;
        statusLabel.setForeground(blinkOn ? new Color(0x3E, 0xB8, 0x7A) : new Color(0xCC, 0xCC, 0xCC));
    }

    private void advance() {
        if (vi < toVerse) {
            vi++;
        } else {
            vi = fromVerse; // 구간 반복: 처음으로 돌아가서 반복
        }
        isKo = !langMode.equals("en");
        render();
        buildQueue();
        speakNext();
    }

    private void togglePlay() {
        if (playing) stopPlayback(); else startPlayback();
    }

    private void startPlayback() {
        playing = true;
        playBtn.setText("⏸");
        buildQueue();
        speakNext();
    }

    private void stopPlayback() {
        playing = false;
        tts.stop();
        playBtn.setText("▶");
        statusLabel.setText("일시정지");
        statusLabel.setForeground(Color.GRAY);
    }

    private void prevVerse() {
        stopPlayback();
        if (vi > fromVerse) {
            vi--;
            isKo = !langMode.equals("en");
            render();
        }
        statusLabel.setText("재생 버튼을 눌러 시작하세요");
    }

    private void nextVerse() {
        stopPlayback();
        if (vi < toVerse) {
            vi++;
            isKo = !langMode.equals("en");
            render();
        }
        statusLabel.setText("재생 버튼을 눌러 시작하세요");
    }

    private void jumpToVerse(int val) {
        stopPlayback();
        vi = val;
        isKo = !langMode.equals("en");
        render();
        statusLabel.setText("재생 버튼을 눌러 시작하세요");
    }

    private void changeRep(int d) {
        rep = Math.max(1, Math.min(10, rep + d));
        repCountLabel.setText(String.valueOf(rep));
    }

    private void changeSpeed(int sliderVal) {
        spd = Math.round(sliderVal) / 100.0;
        speedValLabel.setText(String.format("%.2f×", spd));
    }
}
