package Gui;

import Entity.BookManager;
import Entity.Books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookPage extends JFrame {
    private JTextField titleField, authorField;
    private JButton addButton;

    public AddBookPage() {
        setTitle("Add Book");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // closes only this window
        setLayout(null);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(30, 30, 100, 25);
        add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(120, 30, 200, 25);
        add(titleField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(30, 70, 100, 25);
        add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(120, 70, 200, 25);
        add(authorField);

        addButton = new JButton("Add Book");
        addButton.setBounds(140, 120, 120, 30);
        add(addButton);

        // 📚 Add button logic
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();

                if (title.isEmpty() || author.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                    return;
                }

                Books newBook = new Books(title, author);
                boolean added = BookManager.addBook(newBook);

                if (added) {
                    //JOptionPane.showMessageDialog(null, "Book added successfully!");
                    new ViewBooksPage();

                } else {
                    JOptionPane.showMessageDialog(null, "Book list full! Cannot add more.");
                }
            }
        });

        setVisible(true);
    }
}

