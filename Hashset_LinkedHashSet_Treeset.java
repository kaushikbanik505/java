import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Hashset_LinkedHashSet_Treeset {
    public static void main(String[] args) {
        Set<String> unorderedDestinations = new HashSet<>();
        unorderedDestinations.add("London");
        unorderedDestinations.add("New York");
        unorderedDestinations.add("Paris");
        System.out.println("HashSet (unordered): " + unorderedDestinations); // no one as it is

        Set<String> orderedDestinations = new LinkedHashSet<>();
        orderedDestinations.add("London");
        orderedDestinations.add("Paris");
        orderedDestinations.add("New York");
        System.out.println("LinkedHashSet (insertion order): " + orderedDestinations); // as per order

        Set<String> sortedDestinations = new TreeSet<>();
        sortedDestinations.add("New York");
        sortedDestinations.add("Paris");
        sortedDestinations.add("London");
        System.out.println("TreeSet (sorted order): " + sortedDestinations); // as per sorting
    }
}
