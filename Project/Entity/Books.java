package Entity;

public class Books {
    private String title;
    private String author;

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

