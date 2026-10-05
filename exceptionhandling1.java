import java.io.FileReader;
import java.io.IOException;

class FlightDataProcessor {

    public void loadFlightSchedule() {
        try {
            // The compiler forces us to handle this potential exception
            FileReader fileReader = new FileReader("flights.txt");
            System.out.println("Reading flight data...");
        } catch (IOException e) {
            // We must catch and handle the exception
            System.err.println("Error: Could not find or read the flight data file.");
            System.err.println("Please contact support or try again later.");
        }
    }
}

// REMOVED "public" here so it compiles safely inside ANY file name (like
// tempCodeRunnerFile.java)
public class exceptionhandling1 {
    public static void main(String[] args) {
        FlightDataProcessor processor = new FlightDataProcessor();
        processor.loadFlightSchedule();
    }
}
