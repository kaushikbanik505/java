import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTradeOffDemo {
    public static void main(String[] args) {

        // Task A: Read Access - ArrayList uses a resizable array, perfect for indexed
        // access.
        String fastReadChoice = "ArrayList (Fastest for get(index))";
        System.out.println("\n--- Demo 3: List Trade-Offs & Utilities ---");
        System.out.println("Read-Heavy Task (e.g., getting booking at index 5): " + fastReadChoice);

        // Task B: Write Access - LinkedList uses nodes, making insertions/deletions at
        // the ends fast.
        String fastWriteChoice = "LinkedList (Fastest for add(0, item) or remove(0))";
        System.out.println("Write-Heavy Task (e.g., adding to the start of a queue): " + fastWriteChoice);

        // Task C: Use the Collections Utility Class
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(9, 2, 5, 1));

        // Use the Collections utility class to sort the list (static helper method)
        Collections.sort(unsorted);

        System.out.println("Original Unsorted List: [9, 2, 5, 1]");
        System.out.println("Collections Utility Sort Test: " + unsorted);
    }
}
