package isbntools;

import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.junit.Assert.*;

public class ValidateISBNTest {
    //0140449116 = valid isbn number
    //0140177396 = valid isbn number

    @Test
    public void checkAValidISBNTest() {
        ISBNValidator validator = new ISBNValidator();

        boolean result = validator.isValidISBN("0140449116");
        assertTrue("The first ISBN number is not valid", result);

        result = validator.isValidISBN("0140177396");
        assertTrue("The second ISBN number is not valid", result);
    }

    @Test
    public void checkAnInvalidISBNTest() {
        ISBNValidator validator = new ISBNValidator();

        boolean result = validator.isValidISBN("140449117");
        assertFalse("The ISBN number is valid", result);
    }

    @Test
    public void isbnLengthTest() {
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

}