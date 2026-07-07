package app;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // 기본 Look & Feel 사용
        }
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
