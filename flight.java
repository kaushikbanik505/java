public class flight {
    public static void main(String[] args) {
        int CAPACITY = 5;
        double maxweight = 20.0;
        String[] passenger = { " Alice", "Bob", "Charlie", "Diana", "Eva" };
        double[] luggage = { 21.5, 25.0, 18.2, 23.1, 19.9 };

        String[] status = new String[CAPACITY];

        for (int i = 0; i < status.length; i++) {
            if (passenger[i] != null && luggage[i] >= maxweight) {
                status[i] = "overweight";
            } else {
                status[i] = "ok";
            }
        }

        System.out.println("Passenger Status:-------->");
        for (int i = 0; i < CAPACITY; i++) {
            System.out.println(passenger[i] + "is " + status[i]);
        }
    }

}
