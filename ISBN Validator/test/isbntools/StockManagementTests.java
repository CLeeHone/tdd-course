package isbntools;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockManagementTests {

    @Test
    public void getsCorrectLocatorCode() {
        // Dependency on external service. Mockup of external service / test stub
        ExternalISBNDataService testService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice and Men", "J. Steinbeck");
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setService(testService);

        // Of Mice and Men by John Steinbeck
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

}