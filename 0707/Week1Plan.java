import javax.swing.*;
import java.awt.*;

public class Week1Plan extends JFrame {

    public Week1Plan() {
        setTitle("1주차 체크리스트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 260);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 제목
        JLabel title = new JLabel("1주차: 자바 기본기 마스터");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        title.setForeground(new Color(0x1B3A57)); // 진한 남색
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        // 체크박스 항목들
        String[] items = {
            "변수와 자료형 이해하기",
            "제어문(if, for) 활용하기",
            "메소드(Method) 정의와 호출",
            "객체와 클래스 개념 잡기",
            "컬렉션(ArrayList) 사용해보기"
        };

        Color textColor = new Color(0xE07A3F); // 주황빛 텍스트 색상
        Font itemFont = new Font("맑은 고딕", Font.PLAIN, 15);

        for (String item : items) {
            JCheckBox checkBox = new JCheckBox(item);
            checkBox.setFont(itemFont);
            checkBox.setForeground(textColor);
            checkBox.setBackground(Color.WHITE);
            checkBox.setFocusPainted(false);
            checkBox.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(checkBox);
            panel.add(Box.createRigidArea(new Dimension(0, 6)));
        }

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Week1Plan frame = new Week1Plan();
            frame.setVisible(true);
        });
    }
}