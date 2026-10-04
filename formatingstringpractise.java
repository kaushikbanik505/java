public class formatingstringpractise {
    public static void main(String[] args) {
        String flightNumber = "VXE202";
        int availableSeats = 15;
        double price = 450.75;

        System.out.printf("Flight: %s | Available Seats: %d | Price: $%.2f%n",
                flightNumber, availableSeats, price);
    }
}
