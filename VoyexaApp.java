import java.util.Scanner;

class Customer {
    private int customerId;
    private String name;
    private String email;

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

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

    // ➕ ADDED: Your main method needs these two getters to print the flight info
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

class Booking {
    private String bookingId;
    private Customer customer;
    private Flight flight;
    private int numberOfSeats;

    public Booking(String bookingId, Customer customer, Flight flight, int numberOfSeats) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.flight = flight;
        this.numberOfSeats = numberOfSeats;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Flight getFlight() {
        return flight;
    }

    // ➕ ADDED: Your main method needs this getter to print the final seat count
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}

public class VoyexaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create objects: a customer and a flight
        Customer john = new Customer(1, "John Doe", "john.doe@email.com");
        Flight flightVXE101 = new Flight("VXE101", "New York", "London", 150);

        System.out.println("Welcome to Voyexa, " + john.getName() + "!");
        System.out.println("==========================================");
        System.out.println("Flight " + flightVXE101.getFlightNumber() + " is available.");
        System.out.println("Origin: " + flightVXE101.getOrigin());
        System.out.println("Destination: " + flightVXE101.getDestination());
        System.out.println("Available Seats: " + flightVXE101.getAvailableSeats());

        System.out.print("\nHow many seats would you like to book? ");
        int seatsToBook = scanner.nextInt();

        boolean bookingSuccessful = flightVXE101.bookSeats(seatsToBook);

        System.out.println("==========================================");
        if (bookingSuccessful) {
            Booking booking = new Booking("BKG" + john.getCustomerId() + "-" + seatsToBook, john, flightVXE101,
                    seatsToBook);
            System.out.println("Booking successful! Here are your details:");
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Customer: " + booking.getCustomer().getName());
            System.out.println("Flight: " + booking.getFlight().getFlightNumber());
            System.out.println("Seats Booked: " + booking.getNumberOfSeats());
            System.out.println(
                    "\nRemaining seats on " + flightVXE101.getFlightNumber() + ": " + flightVXE101.getAvailableSeats());
        } else {
            System.out.println("Booking failed. Not enough seats available.");
        }

        scanner.close();
    }
}

// i completely understand the code ....
