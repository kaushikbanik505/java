// A custom exception that extends a checked exception type
class InsufficientSeatsException extends Exception {
    private int requestedSeats;
    private int availableSeats;

    public InsufficientSeatsException(String message, int requested, int available) {
        super(message);
        this.requestedSeats = requested;
        this.availableSeats = available;
    }

    // We can also add a getter method to access the fields
    public int getRequestedSeats() {
        return requestedSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}

class FlightBooking {
    private int availableSeats = 5;

    public void bookSeats(int numberOfSeats) throws InsufficientSeatsException {
        if (numberOfSeats > availableSeats) {
            throw new InsufficientSeatsException(
                    "Cannot book. Not enough seats available.",
                    numberOfSeats,
                    availableSeats);
        }
        availableSeats -= numberOfSeats;
        System.out.println("Successfully booked " + numberOfSeats + " seats.");
    }
}

public class MainApp {
    public static void main(String[] args) {
        FlightBooking flight = new FlightBooking();
        try {
            flight.bookSeats(4); // This will throw our custom exception
        } catch (InsufficientSeatsException e) {
            System.err.println(e.getMessage());
            // We can now access the specific data from our custom exception
            System.out.println("Requested: " + e.getRequestedSeats() + ", Available: " + e.getAvailableSeats());
        }
    }
}