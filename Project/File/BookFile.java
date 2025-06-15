package File;

import Entity.Books;
import java.io.*;
import java.util.*;

public class BookFile {
    private static final String FILE_NAME = "books.txt";

    static {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                preloadSampleBooks();  // Keep preloading only here
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeBook(Books book) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(book.getTitle() + "," + book.getAuthor() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Books> getAllBooks() {
        List<Books> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    books.add(new Books(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static boolean removeBook(String title) {
        List<Books> books = getAllBooks();
        boolean removed = books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        saveAllBooks(books);
        return removed;
    }

    public static void saveAllBooks(List<Books> books) {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (Books book : books) {
                fw.write(book.getTitle() + "," + book.getAuthor() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Books searchBook(String title) {
        for (Books book : getAllBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private static void preloadSampleBooks() {
        List<Books> samples = Arrays.asList(
                new Books("Java Programming", "John Doe"),
                new Books("Data Structures", "Alice Smith"),
                new Books("Operating Systems", "Bob Johnson"),
                new Books("Computer Networks", "Charlie Brown"),
                new Books("Discrete Math", "Jane Parker")
        );

        for (Books book : samples) {
            writeBook(book);
        }
    }
}
