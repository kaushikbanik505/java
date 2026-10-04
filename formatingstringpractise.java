public class formatingstringpractise {
    public static void main(String[] args) {
        String flightNumber = "VXE202";
        int availableSeats = 15;
        double price = 450.75;

        System.out.printf("Flight: %s | Available Seats: %d | Price: $%.2f%n",
                flightNumber, availableSeats, price);

        String customerName = "Jane Doe";
        String bookingId = "BKG-987";
        String destination = "Paris";
        String bookingMessage = String.format("Dear %s, your trip to %s has been confirmed. Your booking ID is %s.",
                customerName, destination, bookingId);

        System.out.println(bookingMessage);
    }
}
