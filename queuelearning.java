import java.util.LinkedList;
import java.util.Queue;

public class queuelearning {
    public static void main(String args[])

    {
        Queue<String> supportRequests = new LinkedList<>();
        supportRequests.add("Request for flight change");
        supportRequests.add("Request for refund");

        System.out.println("Next request to handle: " + supportRequests.peek()); // peek() gets the head without
                                                                                 // removing
        System.out.println("Handling request: " + supportRequests.poll()); // poll() gets and removes the head

    }
}
