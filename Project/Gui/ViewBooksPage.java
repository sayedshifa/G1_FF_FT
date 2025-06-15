package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.BookManager;

public class ViewBooksPage extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea resultArea;
    private JButton backButton; // 🔹 Added

    public ViewBooksPage() {
        setTitle("View Books");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // 🔹 Back button
        backButton = new JButton("← Back");
        backButton.setBounds(10, 10, 80, 25);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // close current window
                new DashboardPage(); // open dashboard
            }
        });

        JLabel searchLabel = new JLabel("Search by title:");
        searchLabel.setBounds(30, 50, 120, 25); // 🔺 shifted downward to make room for back button
        add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(150, 50, 200, 25);
        add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(360, 50, 90, 25);
        add(searchButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(30, 90, 420, 250);
        add(scrollPane);

        // Search action
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText().trim();
                resultArea.setText("");
                String[][] results = BookManager.searchByTitle(keyword);

                if (results.length == 0) {
                    resultArea.setText("No matching books found.");
                } else {
                    for (String[] book : results) {
                        resultArea.append("Title: " + book[0] + ", Author: " + book[1] + "\n");
                    }
                }
            }
        });

        // Show all books by default
        String[][] allBooks = BookManager.getAllBooks();
        if (allBooks.length == 0) {
            resultArea.setText("No books in the system.");
        } else {
            for (String[] book : allBooks) {
                resultArea.append("Title: " + book[0] + ", Author: " + book[1] + "\n");
            }
        }

        setVisible(true);
    }
}
