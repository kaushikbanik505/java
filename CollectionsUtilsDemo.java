import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CollectionsUtilsDemo {
    public static void main(String[] args) {
        // Create a list of flight prices
        List<Integer> prices = new ArrayList<>();
        prices.add(450);
        prices.add(200);
        prices.add(750);
        prices.add(320);

        System.out.println("Original prices: " + prices);

        // Sort the list of prices in ascending order
        Collections.sort(prices);
        System.out.println("Sorted prices: " + prices);

        // Reverse the sorted list
        Collections.reverse(prices);
        System.out.println("Prices in descending order: " + prices);

        // Shuffle the list to randomize it
        Collections.shuffle(prices);
        System.out.println("Shuffled prices: " + prices);

    }

}
