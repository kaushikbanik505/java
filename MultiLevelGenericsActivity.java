import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiLevelGenericsActivity {
    public static void main(String[] args) {

        // [1] Define the structure: A List where the elements are Map<String, String>
        List<Map<String, String>> fullItinerary = new ArrayList<>();

        // Create a segment map
        Map<String, String> segment1 = new HashMap<>();
        segment1.put("Segment", "Flight");
        segment1.put("Destination", "London");
        segment1.put("Price", "450");

        // Add the segment map to the list
        fullItinerary.add(segment1);

        // --- Demonstration ---
        System.out.println("\n--- Task 2: Multi-Level Type Safety ---");

        // [2] Retrieve the first segment (which is a Map)
        Map<String, String> retrievedSegment = fullItinerary.get(0);

        // [3] Safely retrieve a value from the nested Map (No cast needed!)
        String destinationCity = retrievedSegment.get("Destination");

        System.out.println("Total Segments: " + fullItinerary.size());
        System.out.println("Nested Destination: " + destinationCity);
    }
}
