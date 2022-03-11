package isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void checkValidShortISBNTest() {
        ISBNValidator validator = new ISBNValidator();

        boolean result = validator.isValidISBN("0140449116");
        assertTrue("The first ISBN number is not valid", result);

        result = validator.isValidISBN("0140177396");
        assertTrue("The second ISBN number is not valid", result);
    }

    @Test
    public void checkValidLongISBNTest() {
        ISBNValidator validator = new ISBNValidator();

        boolean result = validator.isValidISBN("9782253008880");
        assertTrue("The first ISBN number is not valid", result);

        result = validator.isValidISBN("9781853267338");
        assertTrue("The second ISBN number is not valid", result);
    }

    @Test
    public void checkInvalidShortISBNTest() {
        ISBNValidator validator = new ISBNValidator();

        boolean result = validator.isValidISBN("1404491179");
        assertFalse("The ISBN number is valid", result);
    }

    @Test
    public void checkInvalidLongISBNTest() {
        ISBNValidator validator = new ISBNValidator();

        boolean result = validator.isValidISBN("9798467503256");
        assertFalse("The ISBN number is being marked valid", result);
    }

    @Test
    public void shortISBNLengthTest() {
        ISBNValidator validator = new ISBNValidator();

        assertThrows(NumberFormatException.class,
                () -> {
                    validator.isValidISBN("123456789");
                }
        );
    }

    @Test
    public void isOnlyNumericTest() {
        ISBNValidator validator = new ISBNValidator();

        assertThrows(NumberFormatException.class,
                () -> {
                    validator.isValidISBN("hellowworld");
                }
        );
    }

    @Test
    public void isbnContainsLetterXTest() {
        ISBNValidator validator = new ISBNValidator();

        boolean result = validator.isValidISBN("012000030X");
        assertTrue(result);
    }

}