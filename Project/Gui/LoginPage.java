package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Container c;

    public LoginPage() {

        setTitle("Login");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        // Add title label shifted right so it doesn’t overlap with logo
        JLabel titleLabel = new JLabel("ONLINE LIBRARY MANAGEMENT SYSTEM");
        titleLabel.setBounds(10, 20, 400, 30);
        Font font = new Font("Arial Black", Font.ITALIC, 14);
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.BLUE);
        c.add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(180, 50, 100, 30);
        c.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(270, 50, 150, 30);
        c.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(180, 100, 100, 30);
        c.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(270, 100, 150, 30);
        c.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(300, 150, 100, 30);
        c.add(loginButton);

        // Background image (added last)
        ImageIcon bgIcon = new ImageIcon("Images/Front page.png");
        Image bgImg = bgIcon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        JLabel bgLabel = new JLabel(new ImageIcon(bgImg));
        bgLabel.setBounds(0, 0, 600, 400);
        c.add(bgLabel);

        // Move bgLabel to the back so other components show up in front
        c.setComponentZOrder(bgLabel, c.getComponentCount() - 1);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = new String(passwordField.getPassword());

                if (user.equals("shifa") && pass.equals("1234")) {
                    new DashboardPage();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });

        setVisible(true);
    }
}
