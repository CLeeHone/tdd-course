package isbntools;
import java.lang.StringBuilder;

public class StockManager {

    private ExternalISBNDataService service;

    public String getLocatorCode(String isbn) {
        Book book = service.lookup(isbn);
        StringBuilder locatorCode = new StringBuilder();

        locatorCode.append(book.getIsbn().substring(isbn.length() - 4, isbn.length()));
        locatorCode.append(book.getAuthor().substring(0, 1));

        String[] parts = book.getTitle().split(" ");
        locatorCode.append(parts.length);

        return String.valueOf(locatorCode);
    }


    public void setService(ExternalISBNDataService service) {
        this.service = service;
    }

}
