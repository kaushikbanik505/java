import java.util.Arrays;
import java.util.List;

public class ArraysUtilsDemo {
    public static void main(String args[]) {
        // Create an array of strings
        String[] destinations = { "Paris", "London", "Tokyo" };
        System.out.println("Original array: " + Arrays.toString(destinations));

        // Use Arrays.asList() to convert the array to a List
        List<String> destinationList = Arrays.asList(destinations);
        System.out.println("List from array: " + destinationList);

        // Sort the original array
        Arrays.sort(destinations);
        System.out.println("Sorted array: " + Arrays.toString(destinations));
    }
}
