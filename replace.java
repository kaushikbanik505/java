public class replace {
    public static void main(String[] args) {
        String userReview = "I enjoyed the trip! The hotel was great! (Booking ID: #VXE-567)";

        // Replace all non-alphanumeric characters (except spaces) with an empty string
        String cleanReview = userReview.replaceAll("[^a-zA-Z0-9\\s]", "");

        System.out.println("Original Review: " + userReview);
        System.out.println("Cleaned Review: " + cleanReview);
    }
}
