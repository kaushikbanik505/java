import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seatsToBook = 0;

        System.out.print("Enter the number of seats to book: ");
        String userInput = scanner.nextLine();

        try {
            // Code that might throw an exception goes here
            seatsToBook = Integer.parseInt(userInput); // this line uses to conver the string to integer ..
            System.out.println("You have entered " + seatsToBook + " seats.");
        } catch (NumberFormatException e) {
            // This block handles the specific exception
            System.err.println("Error: That's not a valid number!");
            System.err.println("Please enter a numerical value for the seats.");
        } finally {
            // This code will always run
            System.out.println("Booking process concluded.");
            scanner.close(); // Cleanup: closing the scanner to prevent resource leak
        }
    }
}