                                                                   ##DAY1

[Back to Table of Contents](./README.md)        

### 🛠️ The Core Developer Trio

Grants comprehensive access to input/output streams, collection data frameworks (`ArrayList`, `HashMap`), parsing utilities (`Scanner`), and network socket connection routing interfaces.

```java
import java.io.*;
import java.util.*;
import java.net.*;
```


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

# 📇 Two Faces of Exceptions: Checked vs Unchecked

Java splits exceptions into two core categories depending on whether the compiler forces you to handle them upfront or if they represent structural logical mistakes.

---

## 1. Checked Exceptions: The Expected Problems

These are like warning signs you must address. The Java compiler forces you to either catch them or throw them from your method's signature. They represent predictable external problems, like a file not being found (`IOException`). You are expected to handle them because they are not your fault—they are external to the program itself.

*📌 **Example:** Handling a Missing Flight Data File*

<span style="color:#268bd2">⭐ Checked exceptions represent errors that a well-written application should anticipate and recover from safely at runtime.</span>

### 📝 Source Code

```java
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
```

---

## 2. Unchecked Exceptions: The Surprise Bugs

Imagine the Voyexa app has an array of booking IDs, and your code tries to access an index that doesn't exist. This is a logic error and an unchecked exception (`ArrayIndexOutOfBoundsException`).

<span style="color:#859900">⭐ Unchecked exceptions typically reflect programming flaws or flawed calculation paths that should be resolved by fixing the code rather than merely catching errors.</span>

### 📝 Source Code

```java
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
```
# 🛠️ Advanced Resource Management and Custom Error Delegation

This module explores modern resource handling using automated pipelines alongside architectural frameworks for declaring and propagating custom business rule exceptions.

---

## 1. The try-with-resources Statement: The Modern Way to Clean Up

Using Java's modern Try-with-Resources infrastructure allows developers to initialize resource connections directly within the execution block declaration, completely eliminating the need for manual `finally` tracking routines.

### 📝 Source Code

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BulkBookingProcessor {
    public static void main(String[] args) {
        // The Scanner (a resource) is declared in the try statement's parentheses
        try (Scanner fileScanner = new Scanner(new File("voyexa_bookings.txt"))) {
            while (fileScanner.hasNextLine()) {
                String bookingRequest = fileScanner.nextLine();
                System.out.println("Processing: " + bookingRequest);
            }
        } catch (FileNotFoundException e) {
            // This catch block handles the exception if the file is not found
            System.err.println("Error: The booking file could not be found.");
            System.err.println("Please check the file path and try again.");
        }
        // The fileScanner is automatically closed here, no finally block needed!
    }
}
```

### 🔍 Step-by-Step Architecture Matrix

<span style="color:#268bd2">⭐ Declarations managed inside the Try-with-Resources header automatically close upon code context exit, ensuring total defense against resource leaks.</span>

* **`Scanner`**: A built-in reference Class from the `java.util` package that provides methods to read and parse text data.
* **`fileScanner`**: The Object Reference Variable (the custom name given to your scanner machine instance).
* **`=`**: The Assignment Operator used to store the newly created scanner object inside the `fileScanner` variable.
* **`new Scanner(...)`**: A Constructor Call that manufactures and initializes a live Scanner object instance in memory.
* **`new File("voyexa_bookings.txt")`**: A Virtual Pointer Object that maps out the path and address of the physical file on your disk without actually opening or reading it.
* **`while (...)`**: A conditional Loop Statement that controls how long the file extraction continues based on a boolean value.
* **`fileScanner.hasNextLine()`**: A lookahead Boolean Method that checks the text file and returns true if there is another line of data waiting, or false if it hit the end of the file.
* **`String`**: An immutable object reference Class representing a sequence of text characters.
* **`bookingRequest`**: A local Variable Name used to temporarily hold the text content extracted from the file.
* **`fileScanner.nextLine()`**: A Read Method that sweeps the current line of characters out of the file stream, steps down to the next row, and returns the data as text.
* **`System.out.println(...)`**: A standard Output Print Statement that prints characters out to your console screen.

### 3️⃣ Execution Output

```text
Error: Invalid booking ID index.
```

---

## 2. Exception Propagation and the throws Keyword: Delegating Responsibility

Not every method is equipped to handle every exception. When a method encounters a checked exception it cannot gracefully recover from, it can delegate the responsibility to its caller. The `throws` keyword in the method's signature is the formal contract that signals this delegation. This process is known as exception propagation.

> 📝 **Definition:** Exception propagation is the process where an exception moves up the call stack from the method where it occurred to a calling method that is capable of handling it.

<span style="color:#859900">⭐ Custom exceptions allow apps to mirror industry-specific constraints directly within compilation error workflows.</span>

### 📝 Source Code

```java
// Our custom exception class
class InvalidBookingIdException extends Exception { // Exception is a build in class in java ..
    public InvalidBookingIdException(String message) {
        super(message);// The "super" keyword calls the constructor of the parent class (Exception)
                       // with the provided message
    }
}

class BookingValidator {
    // The "throws" keyword declares that this method can throw this specific
    // exception
    public void validateId(String bookingId) throws InvalidBookingIdException {
        if (!bookingId.startsWith("VOY-")) {
            // If the condition is met, we "throw" a new exception
            throw new InvalidBookingIdException("Error: Booking ID must start with 'VOY-'.");
        }
        System.out.println("Booking ID " + bookingId + " is valid.");
    }
}

// In the main application, we must catch the exception
public class VoyexaApp5 {
    public static void main(String[] args) {
        BookingValidator validator = new BookingValidator();
        try {
            validator.validateId("BKG-12345"); // This will throw an exception
        } catch (InvalidBookingIdException e) {
            System.err.println(e.getMessage());
            System.err.println("Please contact support for a valid ID.");
        }
    }
}
```

### 3️⃣ Execution Output

```text
Error: Booking ID must start with 'VOY-'.
Please contact support for a valid ID.
```
