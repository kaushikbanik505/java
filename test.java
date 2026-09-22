enum FlightStatus {
    EXCESS_LUGGAGE,
    CLEARED_TO_BOARD;
}

enum BoardingStatus {
    BOARDED,
    WAITING;
}

public class test {
    public static void main(String[] args) {

        final int CAPACITY = 5;
        final double MAX_LUGGAGE_KG = 23.0;
        String[] passengerNames = { "Alice", "Bob", "Charlie", "Diana", "Eva" };
        double[] luggageWeightsKg = { 21.5, 25.0, 18.2, 23.1, 19.9 };
        FlightStatus[] statuses = new FlightStatus[CAPACITY];
        BoardingStatus finalBoardingStatus;
        System.out.println("--- Flight VXE888 Manifest Check ---");

        for (int i = 0; i < CAPACITY; i++) {
            if (passengerNames[i] != null && luggageWeightsKg[i] <= MAX_LUGGAGE_KG)

            {

                statuses[i] = FlightStatus.CLEARED_TO_BOARD;
                finalBoardingStatus = BoardingStatus.BOARDED;
            } else {
                statuses[i] = FlightStatus.EXCESS_LUGGAGE;
                finalBoardingStatus = BoardingStatus.WAITING;
            }

            System.out.println("Passenger: " + passengerNames[i]);
            System.out.println("Luggage Weight: " + luggageWeightsKg[i] + " kg");
            System.out.println("Flight Status: " + statuses[i]);
            System.out.println("Boarding Status: " + finalBoardingStatus);
            System.out.println("-----------------------------------");
        }
    }

}
// okay
