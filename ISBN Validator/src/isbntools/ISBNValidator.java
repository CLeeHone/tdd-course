package isbntools;

public class ISBNValidator {

    private static final int SHORT_ISBN = 10;
    private static final int LONG_ISBN = 13;
    private static final int SHORT_ISBN_MULTIPLIER = 11;
    private static final int LONG_ISBN_MULTIPLIER = 10;

    public ISBNValidator() {
    }

    public boolean isValidISBN(String isbn) {
        // If the ISBN is 13 digits
        if (isbn.length() == LONG_ISBN) {
            return isValid13DigitISBN(isbn);
        } else {
            // If the ISBN is 10 digits, check ISBN validity
            if (isbn.length() != SHORT_ISBN) throw new NumberFormatException("ISBN numbers must be exactly 10 digits long, instead of " + isbn.length());
            return isValid10DigitISBN(isbn);
        }
    }

    public boolean isValid13DigitISBN(String isbn) {
        int thirteenDigitTotal = 0;
        //int thirteenDigitCounter = 13;

        if (isbn.length() == LONG_ISBN) {

            for (int i = 0; i < isbn.length(); ++i) {
                char currentCharacter = isbn.charAt(i);

                if (!Character.isDigit(currentCharacter)) {
                    return false;
                }

                if (i % 2 == 0) {
                    thirteenDigitTotal += Character.getNumericValue(isbn.charAt(i));
                } else {
                    thirteenDigitTotal += 3 * Character.getNumericValue(isbn.charAt(i));
                }
              //  --thirteenDigitCounter;
            }
        }
        return (thirteenDigitTotal % LONG_ISBN_MULTIPLIER == 0);
    }

    public boolean isValid10DigitISBN(String isbn) {
        int TenDigitTotal = 0;
        int TenDigitCounter = 10;

        for (int j = 0; j < isbn.length(); ++j) {
            char currentCharacter = isbn.charAt(j);

            if (j == isbn.length() - 1 && currentCharacter == 'X') {
                TenDigitTotal += 10;
            } else if (!Character.isDigit(currentCharacter)) {
                return false;
            }

            TenDigitTotal += TenDigitCounter * Character.getNumericValue(isbn.charAt(j));
            --TenDigitCounter;
        }
        return (TenDigitTotal % SHORT_ISBN_MULTIPLIER == 0);
    }
}
