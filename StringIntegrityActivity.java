// Cleanup: Use the trim() method to remove leading/trailing spaces from the rawFlightCode.
// Verification: Use the startsWith() method to check if the cleaned code is a valid Voyexa code (starts with "VXE").
// Immutability: Use the replace() method to change "BKG" to "TRIP" in the bookingID. Observe that the original bookingID is unchanged.

public class StringIntegrityActivity {
    public static void main(String[] args) {
        // Data provided by user input
        String rawFlightCode = "  VXE-101-LDN  ";
        String bookingID = "BKG-001-JANE";

        // [1] CLEANUP: Use a method to remove the leading/trailing spaces
        String cleanedCode = rawFlightCode.trim();

        // [2] VERIFICATION: Check if the cleaned code starts with "VXE"
        boolean isValidVoyexa = cleanedCode.startsWith("VXE");

        // [3] IMMUTABILITY: Use replace() to attempt to change the ID
        String newTripID = bookingID.replace("BKG", "TRIP");

        System.out.println("--- Task 1: Cleanup and Immutability ---");
        System.out.println("Raw Code:          '" + rawFlightCode + "'");
        System.out.println("Cleaned Code:      '" + cleanedCode + "'");
        System.out.println("Validation Status: " + isValidVoyexa + " (Expected: true)");
        System.out.println("Original Booking ID: " + bookingID + " (Immutable!)");
        System.out.println("New Trip ID:       " + newTripID);
    }
}