package isbntools;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests the StockManagment class' behaviour
 */
public class StockManagementTests {

    StockManager stockManager;
    ExternalISBNDataService testWebService;
    ExternalISBNDataService testDatabaseService;

    /**
     * Runs at the beginning of every single test. Since the testWebService variable is called in most tests, it is
     * instantiated Before each one runs.
     */
    @Before
    public void setup() {
        testWebService = mock(ExternalISBNDataService.class);
        stockManager = new StockManager();
        stockManager.setWebservice(testWebService);
        testDatabaseService = mock(ExternalISBNDataService.class);
        stockManager.setDatabaseService(testDatabaseService);
    }

    @Test
    public void getsCorrectLocatorCode() {
        when(testWebService.lookup(anyString())).thenReturn(new Book("0140177396", "Of Mice and Men", "J. Steinbeck"));
        when(testDatabaseService.lookup(anyString())).thenReturn(null);

        /** Of Mice and Men by John Steinbeck */
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void usesDatabaseWhenDataIsPresent() {
        /** If there is no data in databaseService, return null */
        when(testDatabaseService.lookup("0140177396")).thenReturn(null);
        when(testWebService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

        /** Of Mice and Men by John Steinbeck */
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        when(testWebService.lookup(anyString())).thenReturn(new Book("0140177396", "Of Mice and Men", "J. Steinbeck"));
        when(testDatabaseService.lookup(anyString())).thenReturn(null);
    }

    @Test
    public void usesWebserviceWhenDataNotInDatabase() {
        when(testWebService.lookup(anyString())).thenReturn(new Book("0140177396", "Of Mice and Men", "J. Steinbeck"));
        when(testDatabaseService.lookup(anyString())).thenReturn(null);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(testDatabaseService).lookup("0140177396");
        verify(testWebService).lookup("0140177396");
    }

}