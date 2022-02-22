package isbntools;

public class ISBNValidator {
    String isbn;

    public ISBNValidator() {
    }

    public boolean isValidISBN(String isbn) {

        // If the ISBN is 13 digits
        if (isbn.length() == 13) {
            int thirteenDigitTotal = 0;
            int thirteenDigitCounter = 13;

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
                --thirteenDigitCounter;
            }
            return (thirteenDigitTotal % 10 == 0);
        }

        if (isbn.length() != 10) throw new NumberFormatException("ISBN numbers must be exactly 10 long");

        // If the ISBN is 10 digits
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
        return (TenDigitTotal % 11 == 0);
    }

}
