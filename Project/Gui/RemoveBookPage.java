package Gui;

import Entity.BookManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveBookPage extends JFrame {
    private JTextField titleField;
    private JButton removeButton;

    public RemoveBookPage() {
        setTitle("Remove Book");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Enter title to remove:");
        titleLabel.setBounds(30, 40, 150, 25);
        add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(180, 40, 170, 25);
        add(titleField);

        removeButton = new JButton("Remove Book");
        removeButton.setBounds(130, 90, 130, 30);
        add(removeButton);

        // ❌ Remove logic
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText().trim();

                if (title.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a title.");
                    return;
                }

                boolean removed = BookManager.removeBook(title);

                if (removed) {
                    JOptionPane.showMessageDialog(null, "Book removed successfully.");
                    //titleField.setText("");
                    dispose();
                    new ViewBooksPage();
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
            }
        });

        setVisible(true);
    }
}

