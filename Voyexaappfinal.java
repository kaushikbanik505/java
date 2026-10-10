
// fully understand the codes ....
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Voyexaappfinal {
    public static void main(String[] args) {

        // =========================================================================
        // Task 1: Flight Sequence Queue (FIFO Order)
        // =========================================================================
        System.out.println("--- Task 1: Flight Sequence Queue ---");

        // Step 1: Declaration and initialization using Queue interface
        Queue<String> flightQueue = new ArrayDeque<>();

        // Step 2: Add Operation using Queue safety methods
        flightQueue.offer("VXE301");
        flightQueue.offer("VXE302");
        flightQueue.offer("VXE303");

        // Step 3: Removal Operation (Retrieves and removes the front/head element)
        String removedFlight = flightQueue.poll();

        // Step 4: Verification
        System.out.println("Removed flight (FIFO Head): " + removedFlight);
        System.out.println("Remaining queue contents  : " + flightQueue);
        System.out.println();

        // =========================================================================
        // Task 2: Real-time Seat Pricing Lookup (Key-Value O(1))
        // =========================================================================
        System.out.println("--- Task 2: Real-time Seat Pricing Lookup ---");

        // Step 1: Declaration and initialization
        Map<String, Double> seatPricingMap = new HashMap<>();

        // Step 2: Mapping key-value pairs
        seatPricingMap.put("VXE101-14A", 450.99);
        seatPricingMap.put("VXE101-01B", 899.50);

        // Step 3: Lookup Operation for an existing key
        Double existingPrice = seatPricingMap.get("VXE101-14A");
        System.out.println("Price for seat VXE101-14A: $" + existingPrice);

        // Step 4: Verification with a missing/non-existent key
        Double missingPrice = seatPricingMap.get("VXE999-01A");
        System.out.println("Price for seat VXE999-01A (Handles gracefully): " + missingPrice);
        System.out.println();

        // =========================================================================
        // Task 3: Maintaining Ordered Audit History (Indexed, Utilities)
        // =========================================================================
        System.out.println("--- Task 3: Ordered Audit History ---");

        // Step 1: Declaration and initialization with sequential event codes
        List<Integer> auditHistory = new ArrayList<>();
        auditHistory.add(105);
        auditHistory.add(101);
        auditHistory.add(105); // Duplicates explicitly allowed
        auditHistory.add(103);

        // Step 2: Traversal using a basic for-loop to read specific index
        System.out.print("Event code at index 2     : ");
        for (int i = 0; i < auditHistory.size(); i++) {
            if (i == 2) {
                System.out.println(auditHistory.get(i));
                break;
            }
        }

        // Step 3: Utility Use via Collections static helper method
        Integer maxEventCode = Collections.max(auditHistory);
        System.out.println("Maximum event code in list: " + maxEventCode);
    }
}
