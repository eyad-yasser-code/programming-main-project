package shop.ui.loginWindow;

import java.awt.*;
import javax.swing.*;

public class CustomDialog extends JDialog {

    public CustomDialog(Frame parent, String message) {
        super(parent, true); 
        setSize(350, 180);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);
        setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#1c1c1c"));
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.decode("#249974"), 2));

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));

        JButton ok = new JButton("OK");
        ok.setBackground(Color.decode("#249974"));
        ok.setForeground(Color.WHITE);

        ok.addActionListener(e -> dispose());

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.decode("#1c1c1c"));
        btnPanel.add(ok);

        panel.add(label, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public static void showMessage(Component parent, String message) {
        Frame frame = JOptionPane.getFrameForComponent(parent);
        CustomDialog dialog = new CustomDialog(frame, message);
        dialog.setVisible(true);
    }

}