
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Plan {
    public static void main(String[] args) {
        JFrame frame = new JFrame("1주차 기본기 완성 마스터플랜");
        frame.setSize(200, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 배경 여백 설정 (깔끔하게)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        
        // 제목
        JLabel title = new JLabel("1주차: 자바 기본기 마스터");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(15)); // 제목 아래 간격

        // 학습 목록
        String[] tasks = {
            "변수와 자료형 이해하기", 
            "제어문(if, for) 활용하기", 
            "메소드(Method) 정의와 호출", 
            "객체와 클래스 개념 잡기", 
            "컬렉션(ArrayList) 사용해보기"
        };

        for (String task : tasks) {
            JCheckBox checkBox = new JCheckBox(task);
            checkBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
            mainPanel.add(checkBox);
            mainPanel.add(Box.createVerticalStrut(5)); // 항목 간 간격
        }
        
        

        frame.add(new JScrollPane(mainPanel));
        frame.setVisible(true);

     }
}

