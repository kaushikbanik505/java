
// i fully understand the code how it works ..
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int availableSeats;

    public Flight(String flightNumber, String origin, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Method to book seats
    public boolean bookSeats(int numberOfSeats) {
        if (availableSeats >= numberOfSeats) {
            availableSeats -= numberOfSeats;
            return true;
        } else {
            return false;
        }
    }
}

class BusinessFlight extends Flight {
    private boolean hasLoungeAccess;

    // Constructor to initialize a BusinessFlight
    public BusinessFlight(String flightNumber, String origin, String destination, int availableSeats,
            boolean hasLoungeAccess) {
        // Call the parent class's constructor
        super(flightNumber, origin, destination, availableSeats);
        this.hasLoungeAccess = hasLoungeAccess;
    }

    // New getter for the child class's unique property
    public boolean hasLoungeAccess() {
        return hasLoungeAccess;
    }

    // You can also add new methods or override existing ones
    @Override
    public boolean bookSeats(int numberOfSeats) {
        if (numberOfSeats > 1) {
            System.out.println("Business flights can only book one seat at a time.");
            return false;
        }
        // Call the parent's bookSeats method
        return super.bookSeats(numberOfSeats);
    }
}

public class VoyexaApp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create a standard Flight object
        Flight economyFlight = new Flight("VXE101", "New York", "London", 150);

        // Create a specialized BusinessFlight object
        BusinessFlight businessFlight = new BusinessFlight("VXE102", "New York", "London", 12, true);

        System.out.println("Welcome to Voyexa!");
        System.out.println("==========================================");

        // Demonstrate the standard flight
        System.out.println("Available Economy Flight: " + economyFlight.getFlightNumber() + " with "
                + economyFlight.getAvailableSeats() + " seats.");
        System.out.println("How many seats for the economy flight? ");
        int economySeatsToBook = scanner.nextInt();
        economyFlight.bookSeats(economySeatsToBook);
        System.out.println(
                "Remaining seats on " + economyFlight.getFlightNumber() + ": " + economyFlight.getAvailableSeats());

        System.out.println("\n==========================================");
        // Demonstrate the business flight
        System.out.println("Available Business Flight: " + businessFlight.getFlightNumber() + " with "
                + businessFlight.getAvailableSeats() + " seats.");
        System.out.println("Lounge access included: " + businessFlight.hasLoungeAccess());
        System.out.println("How many seats for the business flight? ");
        int businessSeatsToBook = scanner.nextInt();
        businessFlight.bookSeats(businessSeatsToBook);
        System.out.println(
                "Remaining seats on " + businessFlight.getFlightNumber() + ": " + businessFlight.getAvailableSeats());
        scanner.close();
    }
}