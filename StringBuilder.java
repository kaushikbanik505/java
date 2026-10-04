public class StringBuilder {
    public static void main(String[] args) {
        // Use the fully qualified name to avoid naming conflict with the class name
        java.lang.StringBuilder itineraryBuilder = new java.lang.StringBuilder();

        // Append details one by one without creating new objects
        itineraryBuilder.append("--- Your Voyexa Trip Itinerary ---\n");
        itineraryBuilder.append("Flight: VXE101 to London\n");
        itineraryBuilder.append("Hotel: Hilton London\n");
        itineraryBuilder.append("Car Rental: Economy Class\n");
        itineraryBuilder.append("Total Price: $1250\n");

        // Convert the StringBuilder object to a final, immutable String for display
        String finalItinerary = itineraryBuilder.toString();
        System.out.println(finalItinerary);

        // This is a simplified, conceptual example. In a real app,
        // multiple threads would be calling this.
        java.lang.StringBuffer transactionLog = new java.lang.StringBuffer();

        // Thread 1 logs a successful payment
        transactionLog.append("SUCCESS: Payment processed for booking #BKG-005.\n");

        // Thread 2 logs a flight confirmation
        transactionLog.append("CONFIRM: Ticket issued for flight VXE101.\n");

        // The output would be correctly ordered in a thread-safe way
        System.out.println(transactionLog.toString());

    }
}
