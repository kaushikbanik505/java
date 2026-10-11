// Define the class with a Type Parameter <T>
class VoyexaDataTransfer<T> {
    private T item;

    // [1] Implement the constructor and getter here
    /* YOUR CODE HERE */

    public VoyexaDataTransfer(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class GenericClassActivity {
    public static <T> void displayInfo(T data) {
        System.out.println();
    }

    public static void main(String[] args) {

        // --- Demonstration ---

        // [2] Instantiate for Integer (Flight Number) using the Diamond Operator
        VoyexaDataTransfer<Integer> flightNumTransfer = new VoyexaDataTransfer<>(53214)/* YOUR CODE HERE */;

        // [3] Instantiate for String (Gate Code)
        VoyexaDataTransfer<String> gateCodeTransfer = new VoyexaDataTransfer<>("9A-Business-class");
        /* YOUR CODE HERE */;

        // Verify Type Safety (No Casting Required)
        int flightNumber = flightNumTransfer.getItem();
        String gateCode = gateCodeTransfer.getItem();

        System.out.println("Transfer Success - Flight: " + flightNumber + ", Gate: " + gateCode);
    }
}