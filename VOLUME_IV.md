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
# 🛡️ Advanced Error Management: Custom Exceptions, Chaining, and Propagation

This section details how to scale error handling architectures within robust enterprise applications like Voyexa by building custom exception types, chaining lower-level failures to business logic errors, and tracking execution propagation paths.

---

## 3. Creating Custom Exceptions: A Tailor-Made Error

For robust applications like Voyexa, built-in exceptions like `IllegalArgumentException` are often too generic. Custom exceptions allow you to create specific, meaningful error types that provide more context and data about what went wrong.

> 📝 **Definition:** A custom exception is a user-defined class that extends a built-in exception class, usually `Exception` (for checked exceptions) or `RuntimeException` (for unchecked exceptions). This allows you to encapsulate detailed error information within the exception object itself.

<span style="color:#268bd2">⭐ Custom exceptions allow you to capture state data relevant to the error, making programmatic diagnosis significantly easier.</span>

### 📝 Source Code

```java
// A custom exception that extends a checked exception type
class InsufficientSeatsException extends Exception {
    private int requestedSeats;
    private int availableSeats;

    public InsufficientSeatsException(String message, int requested, int available) {
        super(message);
        this.requestedSeats = requested;
        this.availableSeats = available;
    }

    // We can also add a getter method to access the fields
    public int getRequestedSeats() {
        return requestedSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}

class FlightBooking {
    private int availableSeats = 5;

    public void bookSeats(int numberOfSeats) throws InsufficientSeatsException {
        if (numberOfSeats > availableSeats) {
            throw new InsufficientSeatsException(
                    "Cannot book. Not enough seats available.",
                    numberOfSeats,
                    availableSeats);
        }
        availableSeats -= numberOfSeats;
        System.out.println("Successfully booked " + numberOfSeats + " seats.");
    }
}

public class MainApp {
    public static void main(String[] args) {
        FlightBooking flight = new FlightBooking();
        try {
            flight.bookSeats(4); // This will execute successfully or throw depending on value
        } catch (InsufficientSeatsException e) {
            System.err.println(e.getMessage());
            // We can now access the specific data from our custom exception
            System.out.println("Requested: " + e.getRequestedSeats() + ", Available: " + e.getAvailableSeats());
        }
    }
}
```

### 3️⃣ Execution Output Examples

**Scenario A: Available Seat Track (e.g., booking 4 seats out of 5)**
```text
Successfully booked 4 seats.
```

**Scenario B: Not Available Seat Track (If attempting to book 6 seats out of 5)**
```text
Cannot book. Not enough seats available.
Requested: 6, Available: 5
```

---

## 🔗 Exception Chaining

Sometimes, one exception causes another exception. Exception chaining is a technique where you throw a new exception while keeping a reference to the original, underlying cause. This provides a complete trail of events for debugging.

### 📝 Source Code

```java
public class BookingService {
    public void createBooking() {
        try {
            // Code that interacts with a database
            throw new SQLException("Database connection timed out.");
        } catch (SQLException e) {
            // Catch the low-level exception and wrap it in a high-level one
            throw new BookingFailedException("Failed to save booking. Please try again later.", e);
        }
    }
}
```

### 🔑 Key Takeaways:
* **The Error is Not Lost:** Thanks to exception chaining (`throw new BookingFailedException(..., e);`), the low-level `SQLException` is preserved as the cause of the `BookingFailedException`.
* **User-Friendly Message:** The user (or the calling layer) only sees the general `BookingFailedException` with a business-level message (*"Failed to save booking. Please try again later."*).
* **Developer Insight:** Developers, reading the stack trace, see the `Caused by:` line, which immediately points to the root problem: *"Database connection timed out."*

---

## 🛑 Propagation of Exceptions

Imagine your Java program as a corporate office building, with methods and functions occupying different floors. When an exception occurs on a lower floor (a deeply nested method), it's like an emergency alarm going off. 

### 📝 Source Code

```java
public class TripCalculator {
    
    // Level 3 (Top): The Entry Point
    public static void main(String[] args) {
        System.out.println("Starting trip calculation...");
        processPayment(5, 0); // Calls L2
        System.out.println("Trip calculation finished."); // NEVER REACHED
    }

    // Level 2 (Middle): Orchestrator
    public static void processPayment(int amount, int guests) {
        System.out.println("Processing payment for trip...");
        calculateSplit(amount, guests); // Calls L1
    }

    // Level 1 (Bottom): The Failure Point
    public static void calculateSplit(int amount, int guests) {
        // Here's the trap: guests is 0.
        int split = amount / guests; // ArithmeticException is thrown here.
        System.out.println("Split per person: " + split);
    }
}
```

### 🔍 The Exception Propagation Path:

<span style="color:#859900">⭐ Exceptions bubble up automatically through active stack frames until they encounter a compatible catch configuration or hit the runtime system.</span>

1. **L1 (calculateSplit):** Throws an `ArithmeticException` because of the division by zero.
2. **Propagation to L2 (processPayment):** `calculateSplit` does not handle the exception, so it terminates. The exception travels up to `processPayment`.
3. **Propagation to L3 (main):** `processPayment` also doesn't handle it, so it terminates. The exception travels up to the `main` method.
4. **Final Stop (JVM):** The `main` method doesn't have a `try-catch`. The exception propagates out of the `main` method and is caught by the JVM's default exception handler, producing a stack trace printout.


                                                        ##INSHORT--->OVERALL :-

   # Java Exception Handling Blueprint

In Java, exceptions are mechanisms used to signal, trap, and recover from runtime errors. This guide details custom exception creation, the operational lifecycles of `try-catch-finally` constructs, and structural code organization.

---

## 1. Creating Custom Exceptions (`extends Exception`)
Java allows you to define application-specific errors by inheriting from the built-in `Exception` class. This informs the Java Virtual Machine (JVM) to treat the class as a checked exception.

### Best Practices for Naming:
* **PascalCase:** Always start custom error classes with an uppercase letter.
* **The `Exception` Suffix:** Always append `Exception` to the class name (e.g., use `KaushikException` instead of `kaushik`). This provides immediate architectural context to other developers.

```java
// Definition of a clean, custom exception
public class KaushikException extends Exception {
    
    // Constructor enabling Exception Chaining
    public KaushikException(String message, Throwable cause) {
        super(message, cause); // Passes metrics and root cause up to the parent Exception class
    }
}
```

---

## 2. Structural Mechanisms: `throws` vs. `throw new`

| Keyword | Context | Primary Function |
| :--- | :--- | :--- |
| **`throws`** | Method Signature | **The Warning Sign:** Declares that a method might propagate a specific exception up the call stack. It forces the calling method to handle or re-throw it. |
| **`throw new`**| Method Body | **The Active Trigger:** Explicitly instantiates and triggers an exception object, halting normal line-by-line code execution immediately. |

---

## 3. The Lifecycle of `try`, `catch`, and `finally`

* **`try` Block:** Encloses risky or unpredictable operational code (such as database handshakes, file I/O, or network requests).
* **`catch` Block:** Acts as an emergency routing layer. If an exception matches the defined parameter, the try block terminates instantly, and execution jumps straight here.
* **`finally` Block:** The cleanup protocol. **This block always executes**, regardless of whether the `try` block succeeded seamlessly or crashed into a `catch` block. It is strictly reserved for resource de-allocation (e.g., closing database connections, flushing streams).

### Operational Flow Visualized
```text
 [Start Try Block] ---> (Normal line-by-line execution)
                               |
            +------------------+------------------+
            | (Execution Succeeds)                | (Exception Is Triggered)
            v                                     v
   [Skip Catch Block]                    [Halt Try Block Instantly]
            |                                     |
            |                                     v
            |                            [Route to Catch Block]
            |                                     |
            +------------------+------------------+
                               |
                               v
                     [Execute Finally Block]
                               |
                               v
                [Resume Rest of the Application]
```

---

## 4. End-to-End Execution Sequence (Exception Chaining)

The code snippet below illustrates **Exception Chaining**. This abstraction pattern catches complex, low-level technical infrastructure failures (`SQLException`) and wraps them inside high-level, business-contextual exceptions (`KaushikException`). This keeps front-facing errors clear while preserving full diagnostic traces in system logs.

```java
import java.sql.SQLException;

public class BookingService {

    // The 'throws' keyword warns the architecture that this method can propagate a KaushikException
    public void createBooking() throws KaushikException {
        System.out.println("1. Initialising booking pipeline...");

        try {
            System.out.println("2. Inside try: Interfacing with the database layer...");
            
            // 'throw new' actively triggers a low-level error object. 
            // The try block halts processing immediately after this line.
            throw new SQLException("Database connection timed out."); 

        } catch (SQLException e) {
            System.out.println("3. Inside catch: Trapped the low-level SQLException.");
            
            // Exception Chaining: Wrapping the technical error inside the custom high-level error
            throw new KaushikException("Failed to save booking. Please try again later.", e);

        } finally {
            // This code block is guaranteed to execute despite the 'throw new' declaration right above it
            System.out.println("4. Inside finally: Safely tearing down database connections.");
        }
    }
}
```

### Execution Log Order:
1. `1. Initialising booking pipeline...`
2. `2. Inside try: Interfacing with the database layer...`
3. `3. Inside catch: Trapped the low-level SQLException.`
4. `4. Inside finally: Safely tearing down database connections.`
5. *(The runtime environment then halts execution or hands off the custom `KaushikException` to the upstream caller)*


# Task 3: Identifying Exception Type (Concept Check)

The goal of this task is to identify the best action for different error types. For each scenario, state whether it is a **Checked** or **Unchecked** exception and what the developer's best practice response should be.

| Scenario | Exception Type (Checked/Unchecked) | Best Practice |
| :--- | :--- | :--- |
| **Attempting to connect to a server that is offline.** | **Checked** (e.g., `UnknownHostException` / `IOException`) | **Catch or Declare (throws):** This is recoverable; the developer must anticipate it and provide a user-friendly recovery mechanism (e.g., retry button, offline message). |
| **Forgetting to initialize a String object before calling a method on it (`NullPointerException`).** | **Unchecked** (Runtime) | **Fix the Code:** This is a programmer error. The best practice is to fix the underlying bug (initialize the variable, add null checks) rather than relying on a try-catch block. |
| **Attempting to create a file, but the disk is full (`IOException`).** | **Checked** | **Catch or Declare (throws):** This is external to the code's logic and recoverable. The developer should catch it and handle the situation gracefully (e.g., clear disk space, inform user). |

# Volume 2: Java Exception Types Hierarchy

In Java, exceptions are broadly categorized into two major types: **Checked Exceptions** and **Unchecked Exceptions** (commonly known as **Runtime Exceptions**). Understanding the distinction between them is crucial for writing robust, error-tolerant software.

---

## 🏛️ The Core Dichotomy

```
                   ┌───────────┐
                   │ Throwable │
                   └─────┬─────┘
                         │
             ┌───────────┴───────────┐
             │                       │
       ┌─────▼─────┐           ┌─────▼─────┐
       │   Error   │           │ Exception │
       └───────────┘           └─────┬─────┘
                                     │
                         ┌───────────┴───────────┐
                         │                       │
                   ┌─────▼─────┐           ┌─────▼─────┐
                   │  Checked  │           │ Unchecked │
                   │ Exceptions│           │(Runtime)  │
                   └───────────┘           └───────────┘
```

| Feature | Checked Exceptions | Unchecked (Runtime) Exceptions |
| :--- | :--- | :--- |
| **Compiler Enforcement** | **Mandatory.** The compiler forces you to handle or declare them. | **Optional.** The compiler does not track or force management of these. |
| **Direct Parent Class** | Inherits directly from `java.lang.Exception`. | Inherits from `java.lang.RuntimeException`. |
| **Primary Cause** | External environmental factors outside the program's absolute control. | Programming bugs, logical oversights, or improper API usage. |
| **Best Practice Recovery** | Catch the failure and implement a fallback or user-friendly resolution. | Fix the underlying program logic to prevent the exception entirely. |

---

## 🛡️ 1. Checked Exceptions

These represent conditions that a well-written application should anticipate and recover from. Because they depend on external systems (like files, networks, or databases), the Java compiler enforces strict verification rules at compile time.

### Classic Examples:
*   **`IOException`**: Thrown when an input/output operation fails or is interrupted (e.g., trying to read a network stream that abruptly cuts off).
*   **`FileNotFoundException`**: A subclass of `IOException` triggered when a program attempts to open a local file path that does not exist.
*   **`SQLException`**: Thrown when an application encounters an error interacting with a database management system (e.g., bad syntax, invalid credentials, or severed connection).

### Handling Obligation:
You must resolve checked exceptions using one of two approaches:
1.  **Catching explicitly:** Enclose the hazardous operations inside a structural `try-catch` block.
2.  **Propagating explicitly:** Append a `throws` clause to your method signature, forcing the calling method to take responsibility.

---

## 🚫 2. Unchecked Exceptions (Runtime Exceptions)

These represent internal errors that usually occur due to flaws in program logic. They bypass compilation-stage tracking because, in theory, code should be structurally corrected to avoid them rather than catching them dynamically.

### Classic Examples:
*   **`NullPointerException`**: Raised when attempting to access members or invoke methods on an object reference that evaluates to `null`.
*   **`ArithmeticException`**: Triggered during illegal mathematical operations, most commonly dividing an integer value by zero.
*   **`ArrayIndexOutOfBoundsException`**: Occurs when your loop or assignment statement attempts to index an array sequence with a negative position or a value greater than or equal to its total length.
*   **`NumberFormatException`**: A subclass of `IllegalArgumentException` thrown when trying to parse an invalid string sequence (e.g., `"five"`) into a numeric data type.

### Handling Obligation:
*   **Fix the Source Code:** Do not mask runtime logic bugs behind standard `try-catch` blocks. Instead, introduce structural sanity checks (e.g., `if (object != null)`) or refine algorithms to avoid error boundaries entirely.
