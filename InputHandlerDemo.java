import java.util.Scanner;

public class InputHandlerDemo {
    public static void main(String[] args) {

        // Simulate user input error: "four" cannot be converted to an integer
        String rawInput = "four";

        System.out.println("--- Demo 1: Runtime Input Validation ---");
        System.out.println("Attempting to convert input: \"" + rawInput + "\"");

        try {

            // Critical operation prone to NumberFormatException
            int seats = Integer.parseInt(rawInput);
            System.out.println("Success! Booking " + seats + " seats.");

        } catch (NumberFormatException e) {
            // Recovery: Catch the specific runtime exception
            System.err.println("\nError: Cannot process seats.");
            System.err.println("Voyexa: Please input a valid numerical value.");
            // Note: We don't need to declare NumberFormatException (Unchecked)

        } finally {
            // Cleanup: Code always runs, regardless of whether try or catch executed
            System.out.println("\n[FINALLY BLOCK] Input attempt complete. Proceeding to next step.");
        }
    }
}
