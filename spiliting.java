public class spiliting {

    // 1. Statements must be placed inside a method to execute
    public static void main(String[] args) {

        String flightInfo = "Flight: VXE101, Origin: New York, Destination: London";
        String[] details = flightInfo.split(",\\s*");

        System.out.println("--- Parsed Flight Details ---");
        for (String detail : details) {
            System.out.println(" - " + detail);
        }

    } // <-- Added missing closing brace for the main method
}
