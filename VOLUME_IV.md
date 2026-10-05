                                                                   ##DAY1

[Back to Table of Contents](./README.md)                                                                    

# 🛡️ Exception Handling: Safeguarding the Application Flow

An **exception** is an event that disrupts the normal flow of your program's instructions. Instead of crashing and showing a scary error message, a well-designed app uses exception handling to:

* **Catch the problem** before it breaks the app.
* **Handle it gracefully** (e.g., by showing a friendly error message to the user).
* **Continue running** without interruption.

---

## 🕸️ The try-catch-finally Safety Net

The core of exception handling in Java is the **`try-catch-finally` block**. Think of it as a safety net you set up for your code.

* **The `try` Block:** This is where you place the code that might cause an exception. You're essentially saying, *"Try to run this code, but be ready for a problem."*
* **The `catch` Block:** If an exception occurs in the `try` block, the program immediately jumps to the `catch` block. This is where you write the code to handle the specific error. You can have multiple `catch` blocks to handle different types of exceptions, just like having different tools for different kinds of repairs.
* **The `finally` Block:** The `finally` block is like a promise—**it's always executed**, no matter what. Whether an exception was thrown or the code ran perfectly, `finally` will run. This is the perfect place for "cleanup" code, such as closing a database connection or a file stream, to ensure your app doesn't leave any resources open.

<span style="color:#268bd2">⭐ Exception handling separates error-handling logic from the main functional business logic, keeping code structures maintainable.</span>

<span style="color:#859900">⭐ Placing resource cleanup routines inside the `finally` block guarantees they execute even if unexpected runtime errors occur.</span>

---

## 🏗️ Implementation Example: Secure Seat Booking

Below is a robust console-based application utilizing string parsing and defensive exception routing to gather numeric seat values securely.

### 📝 Source Code

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seatsToBook = 0;

        System.out.print("Enter the number of seats to book: ");
        String userInput = scanner.nextLine();

        try {
            // Code that might throw an exception goes here
            seatsToBook = Integer.parseInt(userInput); // this line uses to conver the string to integer ..
            System.out.println("You have entered " + seatsToBook + " seats.");
        } catch (NumberFormatException e) {
            // This block handles the specific exception
            System.err.println("Error: That's not a valid number!");
            System.err.println("Please enter a numerical value for the seats.");
        } finally {
            // This code will always run
            System.out.println("Booking process concluded.");
            scanner.close(); // Cleanup: closing the scanner to prevent resource leak
        }
    }
}
```

### 3️⃣ Execution Output Examples

**Scenario 1: Valid Numeric Entry (Success Track)**
```text
Enter the number of seats to book: 4
You have entered 4 seats.
Booking process concluded.
```

**Scenario 2: Invalid Text Entry (Exception Handled Track)**
```text
Enter the number of seats to book: four
Error: That's not a valid number!
Please enter a numerical value for the seats.
Booking process concluded.
```
