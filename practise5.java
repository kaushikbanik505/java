import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;

public class practise5 {
    public static void main(String[] args) {
        ArrayList<String> flights = new ArrayList<>();
        flights.add("Flight 2");
        flights.add("Flight 1");
        flights.add("Flight 5");
        flights.add("Flight 4");
        flights.add("Flight 3");

        Collections.sort(flights);// sorthing the arrayList

        for (int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i));
        }

    }

}
