import java.util.function.Predicate;

// Define a simple class for the demo
class Flight {
    private String origin;

    public Flight(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }
}

public class FunctionalGenericsActivity {
    public static void main(String[] args) {

        // [1] Define a Predicate parameterized for Flight
        Predicate<Flight> isFromNY = (flight) -> {
            // [2] LAMBDA INFERENCE: The compiler infers 'flight' is a Flight object.
            return flight.getOrigin().equals("NY");
        };

        Flight flight1 = new Flight("NY");
        Flight flight2 = new Flight("LDN");

        System.out.println("--- Task 1: Lambda Type Safety ---");
        System.out.println("Flight 1 is from NY? " + isFromNY.test(flight1));
        System.out.println("Flight 2 is from NY? " + isFromNY.test(flight2));
    }
}