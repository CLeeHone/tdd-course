package isbntools;

public class ISBNValidator {
    String isbn;

    public ISBNValidator() {
    }

    public boolean isValidISBN(String isbn) {

        if (isbn.length() != 10) throw new NumberFormatException("ISBN numbers must be exactly 10 digits long");
        if (isOnlyNumeric(isbn) == false) throw new NumberFormatException("ISBN numbers must only contain numeric digits [0-9]");

        int sum = 0;
        int counter = 10;

        for (int i = 0; i < isbn.length(); ++i) {
            sum += counter * Character.getNumericValue(isbn.charAt(i));
            --counter;
        }
        return (sum % 11 == 0);
    }

    private boolean isOnlyNumeric(String isbn) {

        for (int i = 0; i <isbn.length(); ++i) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
