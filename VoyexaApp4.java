// perfect example how interface and abstract class wroks .. and i understand it properly ..

interface Bookable {
    // Contract: Any class that implements Bookable MUST have this method.
    // It specifies WHAT to do (book), but not HOW.
    boolean book(int numberOfItems);
}

abstract class TravelItem {
    // Shared state for all travel items
    private double basePrice;

    public TravelItem(double basePrice) {
        this.basePrice = basePrice;
    }

    // Concrete method: A common implementation shared by all children
    public void displaySummary() {
        System.out.println("Base Price: $" + basePrice);
        System.out.println("Final Price (incl. tax): $" + calculatePrice());
    }

    // Abstract method: A required method with NO implementation here.
    // Every child class MUST implement this method uniquely.
    public abstract double calculatePrice();/// it will implement later thats why we are using abtract keyword

    // Getter for the shared state
    public double getBasePrice() {
        return basePrice;
    }
}

// Flight extends ONE abstract class AND implements the Bookable interface
class Flight extends TravelItem implements Bookable {
    private String flightNumber;
    private int availableSeats;

    public Flight(String flightNumber, int availableSeats, double basePrice) {
        // Calls the parent (TravelItem) constructor
        super(basePrice);
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
    }

    // 1. Fulfilling the Abstract Method Contract (from TravelItem)
    @Override
    public double calculatePrice() {
        // Unique tax calculation for flights (e.g., 10% tax)
        return getBasePrice() * 1.10;
    }

    // 2. Fulfilling the Interface Contract (from Bookable)
    @Override
    public boolean book(int numberOfSeats) {
        if (availableSeats >= numberOfSeats) {
            availableSeats -= numberOfSeats;
            System.out.println("Flight " + flightNumber + " booked.");
            return true;
        }
        return false;
    }

    // Overriding the concrete method from TravelItem to add flight specifics
    @Override
    public void displaySummary() {
        System.out.println("--- FLIGHT DETAILS ---");
        System.out.println("Number: " + flightNumber);
        System.out.println("Available Seats: " + availableSeats);
        // Call parent's implementation
        super.displaySummary();
    }
}

public class VoyexaApp4 {
    public static void main(String[] args) {
        // 1. Create a concrete Flight object
        Flight flightVXE101 = new Flight("VXE101", 100, 500.00);

        // --- Demonstrating Abstraction & Polymorphism ---

        // Treat as the abstract parent (TravelItem): Accesses shared methods
        TravelItem itemSummary = flightVXE101;
        System.out.println("Displaying summary via Abstract Class type:");
        itemSummary.displaySummary(); // Calls the overridden Flight version

        System.out.println("------------------------------------------");

        // Treat as the interface (Bookable): Accesses required method
        Bookable itemAction = flightVXE101;
        System.out.println("Attempting to book via Interface type:");
        itemAction.book(5); // Calls the Flight's specific book() implementation

        System.out.println("------------------------------------------");

        // Calling the method that was enforced by the abstract class
        System.out.println("Flight's unique calculated price: $" + flightVXE101.calculatePrice());
    }
}
