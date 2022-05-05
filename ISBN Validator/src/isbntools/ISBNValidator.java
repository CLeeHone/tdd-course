package isbntools;

/**
 * The ISBNValidator class determines whether an ISBN is valid or not. ISBNs can be either 10 or 13 digits long.
 * Logic for ISBN validation logic taken from [1].
 */
public class ISBNValidator {

    /**
     * A short ISBN is exactly {@value} digits long
     */
    private static final int SHORT_ISBN = 10;
    /**
     * A long ISBN is exactly {@value} digits long
     */
    private static final int LONG_ISBN = 13;
    /**
     * A short ISBN has a multiplier of {@value}
     */
    private static final int SHORT_ISBN_MULTIPLIER = 11;
    /**
     * A long ISBN has a multiplier of {@value}
     */
    private static final int LONG_ISBN_MULTIPLIER = 10;

    /**
     * Default constructor
     */
    public ISBNValidator() {
    }

    /**
     * Determines whether the ISBN is 10 or 13 digits, then validates it. If the ISBN  is neither 10 nor 13 digits
     * long, it throws a NumberFormatException.
     * @param isbn The Book's ISBN
     * @return True if the provided ISBN is valid.
     */
    public boolean isValidISBN(String isbn) {
        if (isbn.length() == LONG_ISBN) {
            return isValid13DigitISBN(isbn);
        }

        if (isbn.length() == SHORT_ISBN) {
            return isValid10DigitISBN(isbn);
        }
        throw new NumberFormatException("ISBN numbers must be exactly 10 or 13 digits long, instead of " + isbn.length());
    }

    /**
     * Checks if the provided 13-digit ISBN is valid or not. Used by isValidISBN() method.
     * @param isbn The Book's ISBN
     * @return True if the provided 13-digit ISBN is valid
     */
    public boolean isValid13DigitISBN(String isbn) {
        int thirteenDigitTotal = 0;

        if (isbn.length() == LONG_ISBN) {
            for (int i = 0; i < isbn.length(); ++i) {
                char currentCharacter = isbn.charAt(i);

                if (!Character.isDigit(currentCharacter)) {
                    return false;
                }

                thirteenDigitTotal += ((i % 2 == 0) ? Character.getNumericValue(isbn.charAt(i)) : (3 * Character.getNumericValue(isbn.charAt(i))));
            }
        }
        return (thirteenDigitTotal % LONG_ISBN_MULTIPLIER == 0);
    }

    /**
     *  Checks if the provided 10-digit ISBN is valid or not. Used by isValidISBN() method.
     * @param isbn The Book's isbn
     * @return True is the provided 10-digit ISBN is valid
     */
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

/**
 * Reference cited:
 * [1] "ISBN," Wikipedia, Apr. 23, 2022. https://en.wikipedia.org/w/index.php?title=ISBN&oldid=1084316966 (accessed May 03, 2022).
 */