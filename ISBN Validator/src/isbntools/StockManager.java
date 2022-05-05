package isbntools;
import java.lang.StringBuilder;

public class StockManager {

    private ExternalISBNDataService webservice;
    private ExternalISBNDataService databaseService;

    /**
     * Determines a Book's locator code
     * @param isbn The Book's ISBN
     * @return The Book's LocatorCode
     */
    public String getLocatorCode(String isbn) {
        Book book = databaseService.lookup(isbn);
        StringBuilder locatorCode = new StringBuilder();

        if (book == null) {
            book = webservice.lookup(isbn);
        }

        locatorCode.append(book.getIsbn().substring(isbn.length() - 4, isbn.length()));
        locatorCode.append(book.getAuthor().substring(0, 1));

        String[] parts = book.getTitle().split(" ");
        locatorCode.append(parts.length);

        return String.valueOf(locatorCode);
    }

    public void setWebservice(ExternalISBNDataService webservice) {
        this.webservice = webservice;
    }

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }

}