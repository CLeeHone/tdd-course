package isbntools;
import java.util.Scanner;

/**
 * Test class prompts user for ISBN number, then determines whether that number is valid or not.
 */
public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ISBNValidator validator = new ISBNValidator();

        System.out.println("Please input a 10 or 13 digit ISBN:");
        String userISBN = input.nextLine();
        // Herman Melville's Body Dick = 9798467503257 -> is a valid 13-digit ISBN
        // John Steinbeck's Of Mice and Men = 0140177396 -> is a valid 10-digit ISBN
        System.out.println(validator.isValidISBN(userISBN));
    }

}
