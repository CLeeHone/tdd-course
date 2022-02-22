package isbntools;

public class ISBNValidator {
    String isbn;

    public ISBNValidator() {
    }

    public boolean isValidISBN(String isbn) {

        if (isbn.length() != 10) throw new NumberFormatException("ISBN numbers must be exactly 10 digits long");

        int sum = 0;
        int counter = 10;

        for (int i = 0; i < isbn.length(); ++i) {
            char currentCharacter = isbn.charAt(i);

            if (i == isbn.length() - 1 && currentCharacter == 'X') {
                sum += 10;
            } else if (!Character.isDigit(currentCharacter)) {
                return false;
            }

            sum += counter * Character.getNumericValue(isbn.charAt(i));
            --counter;
        }
        return (sum % 11 == 0);
    }

}
