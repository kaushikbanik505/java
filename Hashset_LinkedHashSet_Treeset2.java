import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

public class Hashset_LinkedHashSet_Treeset2 {
    public static void main(String[] args) {

        Map<Integer, String> unorderedCustomers = new HashMap<>();
        unorderedCustomers.put(103, "Sarah");
        unorderedCustomers.put(101, "Alex");
        unorderedCustomers.put(102, "Maria");
        System.out.println("HashMap (unordered): " + unorderedCustomers);

        Map<Integer, String> orderedCustomers = new LinkedHashMap<>();
        orderedCustomers.put(103, "Sarah");
        orderedCustomers.put(101, "Alex");
        orderedCustomers.put(102, "Maria");
        System.out.println("LinkedHashMap (insertion order): " + orderedCustomers);

        Map<Integer, String> sortedCustomers = new TreeMap<>();
        sortedCustomers.put(103, "Sarah");
        sortedCustomers.put(101, "Alex");
        sortedCustomers.put(102, "Maria");
        System.out.println("TreeMap (sorted by key): " + sortedCustomers);
    }
}
