package Entity;

import File.BookFile;
import java.util.List;

public class BookManager {

    // Add a book (via file I/O)
    public static boolean addBook(Books book) {
        BookFile.writeBook(book);
        return true;
    }

    // Get all books as 2D String array for GUI table
    public static String[][] getAllBooks() {
        List<Books> books = BookFile.getAllBooks();
        String[][] result = new String[books.size()][2];

        for (int i = 0; i < books.size(); i++) {
            result[i][0] = books.get(i).getTitle();
            result[i][1] = books.get(i).getAuthor();
        }

        return result;
    }

    // Search books by title
    public static String[][] searchByTitle(String keyword) {
        List<Books> books = BookFile.getAllBooks();
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .map(book -> new String[]{book.getTitle(), book.getAuthor()})
                .toArray(String[][]::new);
    }

    // Remove a book by title
    public static boolean removeBook(String title) {
        return BookFile.removeBook(title);
    }
}
