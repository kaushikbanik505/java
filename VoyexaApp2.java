
// example how polymorphism works and how to override methods in child class
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

    // this part will overridden inside child class
    public void displayFlightDetails() {
        System.out.println("Flight " + getFlightNumber() + ": From " + getOrigin() + " to " + getDestination());
        System.out.println("Available Seats: " + getAvailableSeats());
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

    @Override
    public void displayFlightDetails() {
        System.out
                .println("BUSINESS FLIGHT " + getFlightNumber() + ": From " + getOrigin() + " to " + getDestination());
        System.out.println("Premium Available Seats: " + getAvailableSeats());
        System.out.println("Lounge Access Included: " + hasLoungeAccess());
    }
}

public class VoyexaApp2 {
    public static void main(String[] args) {
        // ... existing code ...

        // Create a standard Flight object
        Flight economyFlight = new Flight("VXE101", "New York", "London", 150);

        // Create a specialized BusinessFlight object
        Flight businessFlight = new BusinessFlight("VXE102", "New York", "London", 12, true);

        System.out.println("Welcome to Voyexa!");
        System.out.println("==========================================");

        // Call the display method on the economy flight
        economyFlight.displayFlightDetails();

        System.out.println("\n------------------------------------------");

        // Call the same display method on the business flight
        businessFlight.displayFlightDetails();

        System.out.println("\n==========================================");

        System.out.print("Enter a flight number to book (VXE101 or VXE102): ");
        Scanner scanner = new Scanner(System.in);
        String flightChoice = scanner.next();

        Flight selectedFlight;

        if ("VXE101".equals(flightChoice)) {
            selectedFlight = economyFlight;
        } else if ("VXE102".equals(flightChoice)) {
            selectedFlight = businessFlight;
        } else {
            System.out.println("Invalid flight choice.");
            scanner.close();
            return;
        }

        System.out.println("\nHow many seats would you like to book? ");
        int seatsToBook = scanner.nextInt();

        boolean bookingSuccessful = selectedFlight.bookSeats(seatsToBook);

        if (bookingSuccessful) {
            System.out.println("Booking successful! Remaining seats: " + selectedFlight.getAvailableSeats());
        } else {
            System.out.println("Booking failed. Not enough seats or booking rule violated.");
        }

        scanner.close();
    }
}

// i do understand the code how it works and how polymorphism works and how to
// override methods in child class--> classic example ..