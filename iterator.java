import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class iterator {
    public static void main(String args[]) {
        Set<String> object = new HashSet<>();
        object.add("mumbai");
        object.add("jalandar");
        object.add("hyderabad");

        Iterator<String> itr = object.iterator();

        for (int i = 0; i < object.size(); i++) {
            System.out.println(itr.next());
        }

        System.out.println("\n");
        // // method 2
        while (itr.hasNext()) {
            System.out.println(itr.next()); // out put should be same
        }
    }
}
