// Our custom exception class
class InvalidBookingIdException extends Exception { // Exception is a build in class in java ..
    public InvalidBookingIdException(String message) {
        super(message);// The "super" keyword calls the constructor of the parent class (Exception)
                       // with the provided message
    }
}

class BookingValidator {
    // The "throws" keyword declares that this method can throw this specific
    // exception
    public void validateId(String bookingId) throws InvalidBookingIdException {
        if (!bookingId.startsWith("VOY-")) {
            // If the condition is met, we "throw" a new exception
            throw new InvalidBookingIdException("Error: Booking ID must start with 'VOY-'.");
        }
        System.out.println("Booking ID " + bookingId + " is valid.");
    }
}

// In the main application, we must catch the exception
public class VoyexaApp5 {
    public static void main(String[] args) {
        BookingValidator validator = new BookingValidator();
        try {
            validator.validateId("BKG-12345"); // This will throw an exception
        } catch (InvalidBookingIdException e) {
            System.err.println(e.getMessage());
            System.err.println("Please contact support for a valid ID.");
        }
    }
}
