// ==========================================
// 1. THE GENERIC CLASS
// ==========================================
// <T> is the placeholder for the type we will decide later
class DataContainer<T> {

    // This field can hold any object type
    private T item;

    // Constructor: catches an existing object and saves it
    public DataContainer(T item) {
        this.item = item;
    }

    // Returns the saved object with its exact type preserved
    public T getItem() {
        return item;
    }
}

// ==========================================
// 2. THE MAIN CLASS & GENERIC METHOD
// ==========================================
public class Generics {

    // A Generic Method: <T> makes it local to this method only
    // (T data) is the parameter (the funnel) that catches the object passed to it
    public static <T> void displayInfo(T data) {
        // getClass() finds the blueprint metadata
        // getSimpleName() extracts just the clean class name (e.g., "String",
        // "Integer")
        System.out.println("Processing object of type: " + data.getClass().getSimpleName() + " | Value: " + data);
    }

    public static void main(String[] args) {
        System.out.println("--- STEP 1: Using the Generic Class ---");

        // Object Creation: Creating a container specifically for Strings
        DataContainer<String> stringBox = new DataContainer<>("BKG-555");
        // No casting needed! The compiler knows exactly that 'id' is a String
        String id = stringBox.getItem();
        System.out.println("Retrieved from stringBox: " + id);

        // Object Creation: Creating a container specifically for Integers
        DataContainer<Integer> intBox = new DataContainer<>(101);
        Integer flightNum = intBox.getItem();
        System.out.println("Retrieved from intBox: " + flightNum);

        System.out.println("\n--- STEP 2: Using the Generic Method ---");

        // Calling displayInfo from the same class.
        // We pass the existing String object "London" into the 'data' parameter.
        displayInfo("London");

        // We pass the existing Integer object 95 into the 'data' parameter.
        displayInfo(95);

        // We can even pass our custom generic boxes into it!
        displayInfo(stringBox);
    }
}
