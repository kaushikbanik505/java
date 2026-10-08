import java.util.LinkedList;
import java.util.List;

public class Linkedlist {
    public static void main(String[] args) {
        List<String> cancellationQueue = new LinkedList<>();
        cancellationQueue.add("VXE-104");
        cancellationQueue.add("VXE-105");
        cancellationQueue.add("VXE-106");
        System.out.println("Processing next cancellation: " + ((LinkedList<String>) cancellationQueue).removeFirst()); // fast
                                                                                                                       // removeal
                                                                                                                       // from
                                                                                                                       // head
    }
}
