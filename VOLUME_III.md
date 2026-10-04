                                                                      ##DAY1
[Back to Table of Contents](./README.md) 


# 🧵 Java Strings: Sequences and Reference Mechanics

A **String in Java** is an object that represents a **sequence of characters**. It's not a primitive data type like `int` or `char`. This distinction is crucial because it means a String variable holds a **reference to an object in memory**, not the value itself.

---

## 2.1 String Pool: The Memory Optimization Technique

The **String Pool** is a memory optimization technique. When you create a string literal (e.g., `"Hello"`), the Java Virtual Machine (JVM) first checks a special area in memory called the **String Pool**. 

* **Existing Value:** If a string with the same value already exists, it doesn't create a new object. Instead, it just **returns a reference** to the existing one. This saves memory. 
* **Using the `new` Keyword:** However, if you use the `new` keyword, you're explicitly telling the JVM to create a **brand new object in the heap memory**, regardless of whether the value already exists in the String Pool.

<span style="color:#268bd2">⭐ When creating a string literal, the JVM checks the String Pool first to optimize memory allocation.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println(str1 == str2); // Output: true
        System.out.println(str3 == str2); // Output: false
    }
}
```

### 3️⃣ Execution Output

```text
true
false
```

---

## 🛡️ String Immutability: Safeguarding Shared States

**String Immutability** means that once a String object is created, **its value cannot be changed**. Any operation that seems to change a string, such as concatenation or replacement, actually **creates a new String object**. The original object remains untouched. 

<span style="color:#859900">⭐ String Immutability allows the String Pool to work, as shared string objects can be trusted not to change unexpectedly.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        String original = "Java";
        System.out.println("Original String: " + original); // Output: Original String: Java
        String concatenated = original.concat(" Programming");
        System.out.println("Concatenated String: " + concatenated); // Output: Concatenated String: Java Programming
        System.out.println("Original String after concat: " + original); // Output: Original String after concat: Java
    }
}
```

### 3️⃣ Execution Output

```text
Original String: Java
Concatenated String: Java Programming
Original String after concat: Java
```

---

### 🔍 Deep Dive: Step-by-Step Breakdown

In this example:

1. **Initialization:** The `original` string is initialized to `"Java"`.
2. **Concatenation:** The `concat()` method is called on `original`, but it **doesn't modify `original`**. Instead, it creates a **new string object** with the value `"Java Programming"` and assigns it to the `concatenated` variable.
3. **Verification:** The final print statement shows that the value of `original` remains `"Java"`, demonstrating that the object it references **was not changed**.


# 🧰 Commonly Used String Built-in Methods

Java provides a rich set of built-in methods to manipulate and inspect string sequences. Below are the most critical methods used for data validation, parsing, and cleaning.

---

## for all in one place referfile is --->stringPractise.java
 
## 1. `trim()`

Removes leading and trailing whitespace from a string. This is crucial for cleaning up user input.

*📌 **Example:** Imagine a user accidentally adds spaces when entering their email.*

<span style="color:#268bd2">⭐ The `trim()` method eliminates spaces only at the beginning and the end, leaving internal spaces untouched.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        // trim method
        String email = "   kauhsik@gmail.com";
        System.out.println("Email before trim: " + email); 
        
        String trimmedEmail = email.trim();
        System.out.println("Email after trim: " + trimmedEmail); 
    }
}
```

### 3️⃣ Execution Output

```text
Email before trim:    kauhsik@gmail.com
Email after trim: kauhsik@gmail.com
```

---

## 2. `toUpperCase()` and `toLowerCase()`

Converts the case of characters within a string. 

<span style="color:#859900">⭐ Because Strings are immutable, case conversion methods return a completely new String object if modifications occur.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        // toUpperCase and toLowerCase methods
        String strr = "kauhsik";
        String uppercase = strr.toUpperCase();
        String lowercase = strr.toLowerCase();
        
        System.out.println(strr == uppercase); // false (New object created)
        System.out.println(strr == lowercase); // true (Value was already lowercase, returns same reference)
    }
}
```

### 3️⃣ Execution Output

```text
false
true
```

---

## 3. `replace()`

Replaces all occurrences of a specified character or substring with a new one.

<span style="color:#268bd2">⭐ `replace()` swaps target target sequences globally across the entire string instance.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        // replace --->
        String booking = "USA-5002-INDIA";
        String replacebooking = booking.replace("USA", "DUBAI");
        System.out.println("new one is " + replacebooking);
    }
}
```

### 3️⃣ Execution Output

```text
new one is DUBAI-5002-INDIA
```

---

## 4. `startsWith()` and `endsWith()`

Tests whether a string begins or ends with a specific prefix or suffix. This is helpful for validating data formats.

*📌 **Example:** You can use `startsWith()` to confirm if a booking ID follows the correct convention.*

<span style="color:#859900">⭐ Both methods perform case-sensitive prefix/suffix verification matches and yield boolean results.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        // startsWith() and endsWith()
        String check = "BANIK-123-KAUHSIK";
        String check1 = check.startsWith("BANIK") ? "Yes, it starts with BANIK" : "No, it does not start with BANIK";
        String check2 = check.endsWith("KAUHSIK") ? "Yes, it ends with KAUHSIK" : "No, it does not end with KAUHSIK";
        String check3 = check.endsWith("123") ? "Yes, it ends with 123" : "No, it does not end with 123";
        
        System.out.println(check1);
        System.out.println(check2);
        System.out.println(check3);
    }
}
```

### 3️⃣ Execution Output

```text
Yes, it starts with BANIK
Yes, it ends with KAUHSIK
No, it does not end with 123
```

---

## 5. `isEmpty()`

Checks if a string is empty, meaning it has a length of `0`. This is different from a `null` string reference.

<span style="color:#268bd2">⭐ Calling `isEmpty()` on a `null` reference pointer triggers a `NullPointerException`. Always guarantee the reference is not null first.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        // isEmpty()
        String nully = "";
        if (nully.isEmpty()) {
            System.out.println("String is empty");
        } else {
            System.out.println("has character ");
        }
    }
}
```

### 3️⃣ Execution Output

```text
String is empty
```

---

## 6. `substring()`

Extracts a part of the string. There are two overloaded versions:
* `substring(int beginIndex)`: Extracts from the `beginIndex` to the end of the string.
* `substring(int beginIndex, int endIndex)`: Extracts from the `beginIndex` up to (**but not including**) the `endIndex`.

<span style="color:#859900">⭐ String index positioning begins at `0`. Passing index variables beyond bounds will cause an `StringIndexOutOfBoundsException`.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        // substring()
        String sub = "hello-world";
        String sub1 = sub.substring(0, 5);
        System.out.println("Substring: " + sub1);

        String sub2 = sub.substring(6);
        System.out.println("Substring: " + sub2);
    }
}
```

### 3️⃣ Execution Output

```text
Substring: hello
Substring: world
```

---

## 7. `contains()`

Checks if a string contains a specified sequence of characters.

*📌 **Example:** To quickly see if a user's trip summary includes a specific detail, like "Hotel".*

<span style="color:#268bd2">⭐ `contains()` accepts any character sequence interface implementation and checks for exact character matches.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        // contains();
        String obj = " i am going to shooping";
        if (obj.contains("going")) {
            System.out.println("Yes, it contains going");
        } else {
            System.out.println("No, it does not contain going");
        }
    }
}
```

### 3️⃣ Execution Output

```text
Yes, it contains going
```

---

## 8. `split()`

Splits a string into an array of substrings based on a delimiter (a regular expression matching rule).

<span style="color:#859900">⭐ The matched separator pattern boundaries are completely removed from the resulting individual index components.</span>

### 📝 Source Code

```java
public class stringPractise {
    public static void main(String[] args) {
        // split()
        String flightDetails = "VXE101, New York, London";
        String[] details = flightDetails.split(", ");
        
        System.out.println("Flight Code: " + details[0]);
        System.out.println("Origin: " + details[1]);
        System.out.println("Destination: " + details[2]);
    }
}
```

### 3️⃣ Execution Output

```text
Flight Code: VXE101
Origin: New York
Destination: London
```
                                                                      ##DAY2

 # ⚙️ Modifying Sequences Efficiently: StringBuilder and StringBuffer

Java provides two mutable string classes to modify character sequences without generating excessive garbage memory overhead: **`StringBuilder`** and **`StringBuffer`**.

---

## 1. StringBuilder: The High-Performance Builder

* **Best for:** Single-threaded environments (most common use cases).
* **Key Feature:** It is **not synchronized**, meaning it doesn't have built-in safety for multi-threaded access. This lack of overhead makes it the most performant choice for building strings in a single process.

<span style="color:#268bd2">⭐ Using the fully qualified package name `java.lang.StringBuilder` prevents compilation issues when your custom class shares the exact same name.</span>

### 📝 Source Code

```java
public class StringBuilder {
    public static void main(String[] args) {
        // Use the fully qualified name to avoid naming conflict with the class name
        java.lang.StringBuilder itineraryBuilder = new java.lang.StringBuilder();

        // Append details one by one without creating new objects
        itineraryBuilder.append("--- Your Voyexa Trip Itinerary ---\n");
        itineraryBuilder.append("Flight: VXE101 to London\n");
        itineraryBuilder.append("Hotel: Hilton London\n");
        itineraryBuilder.append("Car Rental: Economy Class\n");
        itineraryBuilder.append("Total Price: $1250\n");

        // Convert the StringBuilder object to a final, immutable String for display
        String finalItinerary = itineraryBuilder.toString();
        System.out.println(finalItinerary);
    }
}
```

### 3️⃣ Execution Output

```text
--- Your Voyexa Trip Itinerary ---
Flight: VXE101 to London
Hotel: Hilton London
Car Rental: Economy Class
Total Price: $1250
```

### 🔍 Deep Dive: Step-by-Step Breakdown

In this example, `append()` modifies the `itineraryBuilder` object directly, reusing the same memory space. Only at the very end, when we call `toString()`, is the final, complete String object created.

---

## 2. StringBuffer: The Thread-Safe Builder

* **Best for:** Multi-threaded environments.
* **Key Feature:** It is **thread-safe and synchronized**. This means multiple threads can't access the same `StringBuffer` object at the same time, preventing data corruption. 

<span style="color:#859900">⭐ While thread safety is crucial for concurrent applications, synchronization adds a slight performance cost, making it a bit slower than `StringBuilder`.</span>

### 📝 Source Code

```java
public class StringBuilder {
    public static void main(String[] args) {
      
        java.lang.StringBuffer transactionLog = new java.lang.StringBuffer();

        // Thread 1 logs a successful payment
        transactionLog.append("SUCCESS: Payment processed for booking #BKG-005.\n");

        // Thread 2 logs a flight confirmation
        transactionLog.append("CONFIRM: Ticket issued for flight VXE101.\n");

        // The output would be correctly ordered in a thread-safe way
        System.out.println(transactionLog.toString());
    }
}
```

### 3️⃣ Execution Output

```text
SUCCESS: Payment processed for booking #BKG-005.
CONFIRM: Ticket issued for flight VXE101.
```

# 🏛️ String Design Patterns: The Flyweight Pattern

The **immutability of String objects** is not a random design choice; it's a key structural feature of the **Flyweight Pattern**. This pattern aims to minimize memory usage by sharing data among multiple objects.

The **String Pool** is a perfect implementation of this. Instead of creating a new String object for every `"Paris"` or `"London"` in your application, the JVM creates a single instance in the pool and points all other identical String objects directly to it.

<span style="color:#268bd2">⭐ This resource optimization is only possible because String objects are immutable.</span>

<span style="color:#859900">⭐ If string values could be modified arbitrarily, sharing identical pointers would create severe security risks and data integrity nightmares.</span>

---

### 🔍 Architectural Core Benefits

* **Memory Efficiency:** Identical text sequences share a single allocation block rather than fragmenting the Heap.
* **Inherently Thread-Safe:** Multiple asynchronous threads can confidently read the exact same string references without synchronization overhead.


 # 4. String, StringBuilder, and StringBuffer Comparison

---

| Feature | String | StringBuilder | StringBuffer |
| :--- | :--- | :--- | :--- |
| **Mutability** | **Immutable** (Cannot be changed after creation) | **Mutable** (Can be changed/modified) | **Mutable** (Can be changed/modified) |
| **Thread-Safety** | **Thread-safe** (Implicitly, due to immutability) | **Not Thread-safe** | **Thread-safe** (Methods are synchronized) |
| **Synchronization** | None | None | **Synchronized** (All public methods are synchronized) |
| **Performance** | **Slow** (Concatenation creates new objects) | **Fastest** (Most efficient for modification) | **Slower than StringBuilder** (Overhead of synchronization) |
| **Use Case** | Ideal for **constant, read-only** strings or when thread-safety is paramount. | Ideal for **single-threaded** environments where strings need **frequent modification** (e.g., in a loop). | Ideal for **multi-threaded** environments where strings need **frequent modification** and **thread-safety is required**. |
| **Storage** | Stored in the **String Pool** (for literals) or **Heap**. | Stored in the **Heap**. | Stored in the **Heap**. |



# 🔍 Regular Expressions (Regex)

**Regular Expressions**, or **regex**, are like a special language for describing text patterns. Think of them as a powerful search tool on steroids. 

They are essential for critical operational tasks such as:
* **Validating user input** (checking email formats, phone numbers, or passwords).
* **Parsing data fields** from raw text streams.
* **Finding specific pieces of information** embedded inside a string sequence.

<span style="color:#268bd2">⭐ Using Regex helps you build highly robust input validation layers without writing complex nested loop logic.</span>

<span style="color:#859900">⭐ This pattern-matching capability is perfect for managing the data-rich, dynamic environments within an app like Voyexa.</span>

### The Building Blocks of Regex: Metacharacters and Quantifiers

Regex uses a set of special characters (**metacharacters**) to define patterns, and **quantifiers** to specify how many times a character or pattern should repeat.

#### Metacharacters:

| Metacharacter | Description | Example Pattern | Matches |
| :--- | :--- | :--- | :--- |
| `.` | Any character (except newline) | `a.b` | acb, a#b, a5b |
| `\d` | Any digit (0-9) | `\d\d\d` | 123, 456 |
| `\s` | Any whitespace character | `trip\sID` | trip ID |
| `[abc]` | Any one character inside the brackets | `[aeiou]` | a, e, i, o, u |
| `[^abc]` | Any character **not** inside the brackets | `[^0-9]` | a, B, \$ |

#### Quantifiers:

| Quantifier | Description | Example Pattern | Matches |
| :--- | :--- | :--- | :--- |
| `*` | Zero or more occurrences | `ab*c` | ac, abc, abbc |
| `+` | One or more occurrences | `ab+c` | abc, abbc |
| `?` | Zero or one occurrence | `colou?r` | color, colour |
| `{n}` | Exactly n occurrences | `\d{4}` | 1234 |
| `{n,}` | n or more occurrences | `\d{3,}` | 123, 12345 |

# 🛠️ Applying Regex and String Formatting in Java

---

## 🚀 Applying Regex in Java

Java provides built-in tools to natively validate patterns across text sequences using regular expressions. 

<span style="color:#268bd2">⭐ The `matches()` method evaluates whether the entire target string conforms to the provided expression structure.</span>

### 📝 Source Code

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    // 1. Code must be placed inside a method (like main) to execute
    public static void main(String[] args) {

        String userEmail = "john.doe@voyexa.com";
        // A common regex for email validation
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        boolean isValidEmail = userEmail.matches(emailPattern);
        System.out.println("Is '" + userEmail + "' a valid email? " + isValidEmail);
        // Output: Is 'john.doe@voyexa.com' a valid email? true

        String invalidEmail = "john.doe@voyexa"; // Missing .com
        System.out.println("Is '" + invalidEmail + "' a valid email? " + invalidEmail.matches(emailPattern));
    } // <-- Added missing closing brace for the main method
}
```

### 3️⃣ Execution Output

```text
Is 'john.doe@voyexa.com' a valid email? true
Is 'john.doe@voyexa' a valid email? false
```

---

## ✂️ Splitting and Parsing Data with `split()`

<span style="color:#859900">⭐ Using comma-separated regex tokens like `,\\s*` completely safely strips whitespace variants during complex token extractions.</span>

### 📝 Source Code

```java
public class spiliting {

    // 1. Statements must be placed inside a method to execute
    public static void main(String[] args) {

        String flightInfo = "Flight: VXE101, Origin: New York, Destination: London";
        String[] details = flightInfo.split(",\\s*");

        System.out.println("--- Parsed Flight Details ---");
        for (String detail : details) {
            System.out.println(" - " + detail);
        }

    } // <-- Added missing closing brace for the main method
}
```

### 3️⃣ Execution Output

```text
--- Parsed Flight Details ---
 - Flight: VXE101
 - Origin: New York
 - Destination: London
```

---

## 🔄 Replacing Text with `replaceAll()`

`String.replaceAll()` uses regex to find all matches of a pattern and replace them with a new string. Let's sanitize a user's review by removing any special characters.

<span style="color:#268bd2">⭐ The pattern `[^a-zA-Z0-9\\s]` isolates and discards noisy structural symbols while securely preserving literal characters and spaces.</span>

### 📝 Source Code

```java
public class replace {
    public static void main(String[] args) {
        String userReview = "I enjoyed the trip! The hotel was great! (Booking ID: #VXE-567)";

        // Replace all non-alphanumeric characters (except spaces) with an empty string
        String cleanReview = userReview.replaceAll("[^a-zA-Z0-9\\s]", "");

        System.out.println("Original Review: " + userReview);
        System.out.println("Cleaned Review: " + cleanReview);
    }
}
```

### 3️⃣ Execution Output

```text
Original Review: I enjoyed the trip! The hotel was great! (Booking ID: #VXE-567)
Cleaned Review: I enjoyed the trip The hotel was great Booking ID VXE567
```

---

## 📊 Formatting Strings

Formatting strings makes your output cleaner and easier to read. Instead of just concatenating data with `+`, which can get messy and error-prone, Java provides tools to create well-structured text by "plugging in" data at specific points. Think of it like filling out a pre-made form.

### 🧰 The Tools: `String.format()` and `printf()`
* **`String.format()`**: This method creates and returns a new formatted string. It's useful when you want to store the formatted text in a variable or use it elsewhere.
* **`System.out.printf()`**: This method is a shortcut that prints the formatted string directly to the console. The "f" in `printf` stands for "formatted."

### 🔑 Key Format Specifiers
These are the most common placeholders you'll use:
* **`%s`**: For strings 
* **`%d`**: For integers 
* **`%f`**: For floating-point numbers (like decimals)
* **`%n`**: A platform-independent newline character (like `\n`)

### 📝 Source Code

```java
public class formatingstringpractise {
    public static void main(String[] args) {
        String flightNumber = "VXE202";
        int availableSeats = 15;
        double price = 450.75;

        System.out.printf("Flight: %s | Available Seats: %d | Price: $%.2f%n",
                flightNumber, availableSeats, price);
    }
}
```

### 3️⃣ Execution Output

```text
Flight: VXE202 | Available Seats: 15 | Price: $450.75
```

---

## ✉️ `String.format()` for a Booking Confirmation

<span style="color:#859900">⭐ Bundling dynamic contextual tokens via `String.format()` guarantees clean layout tracking without complex concatenation strings.</span>

### 📝 Source Code

```java
public class formatingstringpractise {
    public static void main(String[] args) { // Fixed execution structural context wrapper block

        String customerName = "Jane Doe";
        String bookingId = "BKG-987";
        String destination = "Paris";
        String bookingMessage = String.format("Dear %s, your trip to %s has been confirmed. Your booking ID is %s.",
                customerName, destination, bookingId);

        System.out.println(bookingMessage);
    }
}
```

### 3️⃣ Execution Output

```text
Dear Jane Doe, your trip to Paris has been confirmed. Your booking ID is BKG-987.
```


