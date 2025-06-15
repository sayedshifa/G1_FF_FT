package Entity;

public class User {
    private String username;
    private Books[] ownedBooks = new Books[10]; // Max 10 books per user
    private int bookCount = 0;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean addBook(Books book) {
        if (bookCount < ownedBooks.length) {
            ownedBooks[bookCount++] = book;
            return true;
        }
        return false;
    }

    public boolean removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (ownedBooks[i].getTitle().equalsIgnoreCase(title)) {
                for (int j = i; j < bookCount - 1; j++) {
                    ownedBooks[j] = ownedBooks[j + 1];
                }
                ownedBooks[bookCount - 1] = null;
                bookCount--;
                return true;
            }
        }
        return false;
    }

    public Books[] getOwnedBooks() {
        Books[] result = new Books[bookCount];
        for (int i = 0; i < bookCount; i++) {
            result[i] = ownedBooks[i];
        }
        return result;
    }

    public void printBooks() {
        System.out.println(username + "'s Books:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(" - " + ownedBooks[i]);
        }
    }
}
