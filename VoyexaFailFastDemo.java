import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VoyexaFailFastDemo {
    public static void main(String[] args) {
        List<String> newBookings = new ArrayList<>();
        newBookings.add("BKG-001");
        newBookings.add("BKG-002");

        Iterator<String> iterator = newBookings.iterator();

        while (iterator.hasNext()) {
            System.out.println("Processing booking: " + iterator.next());

            // Simulating a new booking coming in and modifying the list
            if (newBookings.size() == 2) {
                // This will cause a ConcurrentModificationException
                newBookings.add("BKG-003"); // means create a error
            }
        }
    }
}