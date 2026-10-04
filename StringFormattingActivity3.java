public class StringFormattingActivity3 {
    public static void main(String[] args) {
        String bookingRef = "BKG-101";
        double totalPrice = 150.9876;

        // [1] FORMATTING: Use String.format() with the correct specifiers (%.2f for
        // price)
        String formattedOutput = String.format("Total Price for %s: $%.2f", bookingRef, totalPrice);

        System.out.println("\n--- Task 3: Professional Formatting ---");
        System.out.println("Required Output: Total Price for BKG-101: $150.99");
        System.out.println("Actual Output:   " + formattedOutput);
    }
}