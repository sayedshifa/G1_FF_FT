package Gui;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JFrame {
    public DashboardPage() {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel label = new JLabel("DASHBOARD");
        label.setBounds(130, 0, 400, 60);
        label.setFont(new Font("Arial Black", Font.ITALIC, 20));
        label.setForeground(Color.BLUE);
        c.add(label);

        // Manage Profile button
        JButton manageProfileBtn = new JButton("Manage Profile");
        manageProfileBtn.setBounds(50, 50, 140, 40);
        c.add(manageProfileBtn);

        // Manage Books dropdown button
        JButton manageBooksBtn = new JButton("Manage Books ▼");
        manageBooksBtn.setBounds(210, 50, 140, 40);
        c.add(manageBooksBtn);

        // Create popup menu for Manage Books
        JPopupMenu booksMenu = new JPopupMenu();
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem removeBookItem = new JMenuItem("Remove Book");
        JMenuItem viewBooksItem = new JMenuItem("View Books");
        booksMenu.add(addBookItem);
        booksMenu.add(removeBookItem);
        booksMenu.add(viewBooksItem);

        // Show popup menu when Manage Books button clicked
        manageBooksBtn.addActionListener(e ->
                booksMenu.show(manageBooksBtn, 0, manageBooksBtn.getHeight())
        );

        // Link “View Books” to ViewBooksPage
        viewBooksItem.addActionListener(e -> {
            dispose(); // close dashboard
            new ViewBooksPage();
        });

        // Link “Add Book” to AddBookPage
        addBookItem.addActionListener(e -> {
            dispose(); // optional
            new AddBookPage();
        });

        // Link “Remove Book” to RemoveBookPage
        removeBookItem.addActionListener(e -> {
            dispose(); // optional
            new RemoveBookPage();
        });

        // Log Out button
        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.setBounds(110, 120, 140, 40);
        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginPage();  // Replace with your actual login class name
        });
        c.add(logoutBtn);

        setVisible(true);
    }
}
