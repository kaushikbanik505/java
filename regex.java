import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    // 1. Code must be placed inside a method (like main) to execute
    public static void main(String[] args) {

        String userEmail = "john.doe@voyexa.com";
        // A common regex for email validation
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        boolean isValidEmail = userEmail.matches(emailPattern);
        System.out.println("Is '" + userEmail + "' a valid email? " + isValidEmail);
        // Output: Is 'john.doe@voyexa.com' a valid email? true

        String invalidEmail = "john.doe@voyexa"; // Missing .com
        System.out.println("Is '" + invalidEmail + "' a valid email? " + invalidEmail.matches(emailPattern));
    } // <-- Added missing closing brace for the main method
}
