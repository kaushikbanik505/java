public class StringPerformanceActivity2 {
    public static void main(String[] args) {
        String flight = "VXE101";
        String gate = "A12";
        int bags = 2;

        // [1] SELECT THE TOOL: Choose the best class for single-threaded performance
        // (Replace XXXXX with your chosen mutable class)
        java.lang.StringBuilder itineraryBuilder = new java.lang.StringBuilder();

        // [2] CONSTRUCTION: Append the itinerary details
        itineraryBuilder.append("--- Voyexa Itinerary ---\n");
        itineraryBuilder.append("Flight: ").append(flight).append("\n");
        itineraryBuilder.append("Gate: ").append(gate).append("\n");
        itineraryBuilder.append("Bags Checked: ").append(bags);

        // Convert the builder to the final immutable String
        String finalItinerary = itineraryBuilder.toString();

        // [3] FORMATTING: Check the length
        int finalLength = finalItinerary.length();

        System.out.println("\n--- Task 2: Performance Building ---");
        System.out.println(finalItinerary);
        System.out.println("Itinerary Length: " + finalLength);
    }
}