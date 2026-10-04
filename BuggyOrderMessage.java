public class BuggyOrderMessage {

    // FIX 1 & 2: Maintained StringBuilder for local generation but shifted from a
    // global
    // static state to dynamic, thread-isolated parameter passing to ensure
    // architecture safety.
    public static void main(String[] args) {

        String customerName = "John";

        // FIX 3: Replaced the unnecessary thread-safe StringBuffer with a standard
        // String,
        // as the Order ID value remains constant and immutable after initialization.
        String orderId = "ORD1001";

        // Start building the itinerary message block
        java.lang.StringBuilder message = new java.lang.StringBuilder("Order Summary:\n");

        // FIX 4: Chained appends directly to eliminate intermediate garbage memory
        // allocations.
        message.append("Order ID: ").append(orderId).append("\n")
                .append("Customer: ").append(customerName).append("\n");

        // Build and append items dynamically
        addItems(message);

        // FIX 5: Invalid values are validated safely inside the calculation method
        // layer.
        try {
            addTotalAmount(message, -250);
        } catch (IllegalArgumentException e) {
            message.append("Total Amount: Error [").append(e.getMessage()).append("]\n");
        }

        System.out.println("\n=== FINAL MESSAGE (OPTIMIZED) ===");
        System.out.println(message.toString());
    }

    /**
     * Builds the item list using efficient character sequences.
     * FIX 6: Eliminated nested loop string concatenations (" + ") to enforce DRY
     * rules.
     */
    static void addItems(java.lang.StringBuilder message) {
        String[] items = { "Shoes", "Bag", "Watch" };

        message.append("Items Purchased:\n");
        for (String item : items) {
            // Appends directly to the active buffer layout without intermediate structures
            message.append(" - ").append(item).append("\n");
        }
    }

    /**
     * Validates and adds the billing total block safely.
     * FIX 7: Prevents negative billing amounts from corrupting state data metrics.
     */
    static void addTotalAmount(java.lang.StringBuilder message, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Billing total cannot be negative.");
        }

        // Formats financial decimals safely using fluent character streams
        message.append(String.format("Total Amount: $%.2f%n", amount));
    }
}
