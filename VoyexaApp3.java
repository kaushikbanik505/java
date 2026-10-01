import java.util.Scanner;
import java.util.List;
import java.util.ArrayList; // FIXED: Added missing import for ArrayList

interface Bookable { // FIXED: Removed public modifier so it compiles in a single file
    // This method is a contract. Any class that implements this interface MUST
    // provide its own
    // logic for how to "book" something.
    boolean book(int numberOfItems);
}

class Flight implements Bookable { // FIXED: Added 'implements Bookable' to fix type mismatch in main list
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

    // FIXED: Implemented the 'book' method from the Bookable interface contract
    @Override
    public boolean book(int numberOfItems) {
        return bookSeats(numberOfItems);
    }

    // this part will overridden inside child class
    public void displayFlightDetails() {
        System.out.println("Flight " + getFlightNumber() + ": From " + getOrigin() + " to " + getDestination());
        System.out.println("Available Seats: " + getAvailableSeats());
    }
}

class HotelRoom implements Bookable { // FIXED: Removed public modifier so it compiles in a single file
    private String hotelName;
    private int roomsAvailable;

    public HotelRoom(String hotelName, int roomsAvailable) {
        this.hotelName = hotelName;
        this.roomsAvailable = roomsAvailable;
    }

    // This class MUST implement the 'book' method
    @Override
    public boolean book(int numberOfRooms) {
        if (roomsAvailable >= numberOfRooms) {
            roomsAvailable -= numberOfRooms;
            return true;
        } else {
            return false;
        }
    }
}

public class VoyexaApp3 {
    public static void main(String[] args) {

        // Create a list of Bookable items
        List<Bookable> travelItems = new ArrayList<>();

        // Add a Flight and a HotelRoom to the same list
        travelItems.add(new Flight("VXE101", "New York", "London", 150));
        travelItems.add(new HotelRoom("Grand Plaza Hotel", 50));

        System.out.println("Welcome to Voyexa!");
        System.out.println("==========================================");

        // Loop through the list and book an item, regardless of its specific type
        for (Bookable item : travelItems) {
            // Here, we call the same 'book' method, but it behaves differently
            // depending on whether the object is a Flight or a HotelRoom.
            if (item.book(1)) {
                System.out.println("Booking successful!");
            } else {
                System.out.println("Booking failed.");
            }
        }
    }
}
