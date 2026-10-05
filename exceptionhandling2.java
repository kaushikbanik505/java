public class exceptionhandling2 {
    public static void main(String[] args) {
        String[] bookingIds = { "VXE101", "VXE102", "VXE103" };

        // This line is a programming mistake. The valid indices are 0, 1, 2.
        try {
            System.out.println("Booking ID: " + bookingIds[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Invalid booking ID index.");
        }
    }

}