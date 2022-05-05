package isbntools;

/**
 * Book class represents a book with an ISBN, a title, and an author. It is used by the StockManager,
 * ExternalISBNDataService, and StockManagementTests classes.
 */
public class Book {

    private String isbn;
    private String title;
    private String author;

    /**
     * Book's parameterized constructor.
     * @param isbn The Book's ISBN
     * @param title The Book's title
     * @param author The Book's author
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    /**
     * Used by the StockManager class' getLocatorCode() method, which is in turn used in the StockManagementTests
     * class.
     * @return The Book's ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Used by StockManager class' getLocatorCode() method.
     * @return The Book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Used by Stockmanager class' getLocatorCode() method.
     * @return The Book's author
     */
    public String getAuthor() {
        return author;
    }

}