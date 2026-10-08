import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Flight implements Comparable<Flight> {
    public int price;
    public int duration;

    public Flight(int price, int duration) {
        this.price = price;
        this.duration = duration;
    }

    // Implementing Comparable for natural sorting by price
    @Override
    public int compareTo(Flight otherFlight) {
        return Integer.compare(this.price, otherFlight.price);
    }
}

public class SortingDemo {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(500, 120));
        flights.add(new Flight(250, 60));

        // Sorting by natural order (price)
        Collections.sort(flights);
        System.out.println("Cheapest flight price: $" + flights.get(0).price);

        // Using a Comparator for custom sorting by duration
        flights.sort(Comparator.comparing(f -> f.duration));
        System.out.println("Shortest flight duration: " + flights.get(0).duration + " mins");
    }
}