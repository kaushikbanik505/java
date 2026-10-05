// [1] DEFINE CUSTOM CHECKED EXCEPTION CLASS HERE
class InsufficientCapacityException extends Exception {
    // Extends Exception, making it a Checked Exception (must be declared/caught)
    public InsufficientCapacityException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {

    // [2] Method must declare the Checked Exception using 'throws'
    // Compiler mandates this declaration because the exception extends 'Exception'
    public static void checkCapacity(int available) throws InsufficientCapacityException {
        if (available < 10) {
            // [3] Use 'throw' to create and launch the exception object
            throw new InsufficientCapacityException(
                    "Cannot book: Only " + available + " seats remain. Minimum required is 10.");
        }
        System.out.println("Capacity Check Passed: " + available + " seats available.");
    }

    public static void main(String[] args) {
        int seatsAvailable = 7; // Violates the business rule

        System.out.println("\n--- Demo 2: Custom Business Exception ---");

        try {
            // The method call must be wrapped in try-catch
            checkCapacity(seatsAvailable);
        } catch (InsufficientCapacityException e) {
            // Graceful Handling of the custom exception
            System.err.println("\n--- Capacity Error Log (Custom Exception Handled) ---");
            System.err.println("Violation Details: " + e.getMessage());
            System.out.println("Suggestion: Offer the user an alternative flight.");
        }
    }
}