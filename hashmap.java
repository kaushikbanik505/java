import java.util.HashMap;
import java.util.Map;

public class hashmap {
    public static void main(String args[])

    {
        Map<Integer, String> customerIdToName = new HashMap<>();
        customerIdToName.put(101, "John Doe");
        customerIdToName.put(102, "Jane Smith");

        System.out.println("Customer with ID 101: " + customerIdToName.get(101));
        System.out.println("Customer with ID 102: " + customerIdToName.get(102));
        System.out.println("Customer with ID 103: " + customerIdToName.get(103));

    }
}
