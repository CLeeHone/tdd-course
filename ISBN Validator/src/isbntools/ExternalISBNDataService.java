package isbntools;

public interface ExternalISBNDataService {
    /**
     * Used by StockManager and StockManagementTests classes
     * @param isbn
     * @return
     */
    public Book lookup(String isbn);
}


