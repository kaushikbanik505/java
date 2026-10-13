                                                                         ##DAY--1

[Back to Table of Contents](./README.md)


---

### 🌟 A Thought for Every Learner

> **कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।**  
> **मा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥**
>
> *“You have the right to perform your duty, but not to the fruits of your actions.”*
>
> — **श्रीमद्भगवद्गीता, अध्याय 2, श्लोक 47 (Bhagavad Gita 2.47)**

*Keep learning, keep practising, and give your best effort. Focus on the work and let progress follow.*

# 🧬 Java Generics: Architecture and Syntax

Generics is a powerful feature introduced in Java 5 that allows classes, interfaces, and methods to operate on objects of various types while maintaining type safety. Instead of writing code specific to String or Integer, you write code that handles a type placeholder, specified at the time of usage.

---

## 🛑 Why Java Introduced Generics (Solving Casting & Runtime Errors)

Before Generics, if you wanted to create a reusable container, you had to use the universal parent class, Object. While this allowed you to store any type of data, it created two major problems:

1. **Casting Overhead:** Every time you retrieved an item from the container, you had to manually cast it back to its original type. This cluttering of code was inefficient and error-prone.
2. **Runtime Errors:** The compiler couldn't verify the type of data being stored. If you accidentally put a String into a container meant for Integer objects, the error would only appear when the program ran and failed the cast, leading to an abrupt application crash. This defeats Java's principle of robust, compile-time error checking.

### The Legacy Problem (Raw Types)
```java
List list = new ArrayList(); // List holds 'Object' (Raw Type)
list.add("Hello");           // Store a String
list.add(123);               // Store an Integer

// This line would compile fine but crash at runtime because the Integer (123) cannot be cast to a String.
// String s = (String) list.get(1); // Throws ClassCastException at runtime
```

---

## 💎 Benefits: Type Safety, Code Reusability, and Clean APIs

Generics directly solve the problems above, resulting in three major benefits:

* **Type Safety (The #1 Benefit):** Generics allow the compiler to enforce type restrictions. If you declare a List<String>, the compiler guarantees that only String objects can be added. This catches mistakes immediately at compile time, making the code far more robust.
* **Code Reusability:** You can write a single class, like a Box<T>, and reuse it to safely hold any type (Box<Integer>, Box<Car>, etc.) without rewriting the entire class logic.
* **Clean APIs:** Generics eliminate the messy casting required by raw types, making method signatures and code much clearer and more readable.

---

## 🌍 Real-World Use Cases (e.g., Collections, APIs)

Generics are ubiquitous in modern Java, but their most prominent real-world applications include:

* **The Java Collections Framework:** This is where Generics made the biggest impact. All collections (List, Set, Map) are generic, allowing developers to create containers of specific, guaranteed types (e.g., Set<AirportCode>).
* **APIs (Application Programming Interfaces):** Many modern frameworks and utility classes (like Optional<T> or CompletableFuture<T>) use Generics to define what kind of data they return or manipulate, ensuring predictable and clean method signatures.
* **Custom Data Structures:** Any time you design a reusable data structure (like a Node in a linked list or a custom cache), Generics ensure your structure works with any data type safely.

---

## 📦 Generic Classes (Creating a Box<T>)

A Generic Class is one that defines one or more type parameters. This allows the class to operate on different data types without being rewritten. The type parameter (T) acts as a placeholder that is replaced with a real type (like String or Integer) when the class is instantiated.

### Example: Voyexa Data Container
Imagine creating a secure data holder for Voyexa that must safely store either a Customer object or a Flight object.

### Generic Class Template
```java
public class DataContainer<T> {
    
    // T is used as the type for the field
    private T item;

    public DataContainer(T item) {
        this.item = item;
    }

    // T is used as the return type
    public T getItem() {
        return item;
    }
}
```

### 📝 Full Source Code (Generics.java)
```java
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
```

### 3️⃣ Execution Output (Generics)
```text
--- STEP 1: Using the Generic Class ---
Retrieved from stringBox: BKG-555
Retrieved from intBox: 101

--- STEP 2: Using the Generic Method ---
Processing object of type: String | Value: London
Processing object of type: Integer | Value: 95
Processing object of type: DataContainer | Value: DataContainer@default_hashcode
```

                                                                  ##DAY---2

---

## 🎨 The Solution Across the Framework

*   **List (Ordered, Duplicates)**: Generics ensure that an `ArrayList<Passenger>` contains only `Passenger` objects, and the `.get()` method returns a `Passenger` object directly.
*   **Set (Unique, Unordered)**: Generics ensure that a `HashSet<AirportCode>` contains only `AirportCode` objects, preventing accidental mixing with other types.
*   **Map (Key-Value)**: Generics require two type parameters, ensuring both the key and the value are correct. `HashMap<String, Customer>` guarantees the key is a String (e.g., email) and the value is a `Customer` object.

---

## 💎 Type Parameterization

Type Parameterization is the act of replacing the generic type parameters (like `E` or `K`) with concrete types (like `String` or `Flight`). This is not just a stylistic preference; it's fundamental to robust software design.

*   **Elimination of Casting**: Casting costs performance and reduces readability. By parameterizing the type, the compiler knows exactly what type the collection holds, and inserts the necessary cast implicitly (behind the scenes) during compilation, so you don't have to write it.
*   **Early Error Detection**: If you try to add an `Integer` to a `List<String>`, the Java compiler identifies the error immediately, before you even run the code. This is a massive time-saver compared to tracking down a crash in production.
*   **Readability**: `List<Flight>` instantly communicates the purpose and contents of the list, unlike the ambiguous `List` (Raw Type).

---

## 🔗 Multi-Level Generics

Generics can be nested, allowing you to create complex, highly structured data types that are still fully type-safe. This is common when dealing with structured data that needs to be stored in memory.

*   **Syntax**: `Container1<Container2<Type1, Type2>>`

Imagine storing an itinerary where you have a list of travel segments, and each segment is represented by a map of attributes.

```java
// Definition: A list where every element is a Map.
// The Map keys are always Strings (e.g., "flightNumber")
// The Map values are always Strings (e.g., "VXE101")
List<Map<String, String>> fullItinerary = new ArrayList<>();
```

### Accessing Nested Data Safely

```java
// 1. Get the first segment from the List. The compiler knows this is a Map<String, String>.
Map<String, String> firstSegment = fullItinerary.get(0);

// 2. Access a value from the Map. The compiler knows this is a String.
String flightNum = firstSegment.get("flightNumber"); // No cast required!
```

---

## 📝 Summary of Key Learnings: Generics in Collections

Mastering Generics is the key to writing modern, reliable Java code, particularly when dealing with the Collections Framework.

### 1. Generics Solved a Critical Problem
*   **The Problem**: Before Generics, using collections (List, Map) required developers to use Raw Types (e.g., `List`), forcing manual casting `((String) list.get(i))` and creating the risk of runtime crashes (`ClassCastException`).
*   **The Solution**: Generics introduced Type Safety, moving error detection from fragile runtime checks to robust compile-time checks.

### 2. The Benefits of Parameterization
*   **Type Safety**: Declaring `List<String>` guarantees that only `String` objects can be added, preventing accidental mixing of data types.
*   **Casting Elimination**: When retrieving an element from a parameterized collection, the compiler already knows the type, so no explicit casting is required, leading to cleaner, more readable code.

### 3. Handling Complex Data
*   **Multi-Level Generics**: You learned to safely create and manipulate complex structures like a `List<Map<String, String>>`. This allows for highly structured data storage (like a detailed itinerary) while maintaining type guarantees at every nested level.
*   **Clarity**: Using nested generics makes the structure's purpose instantly clear, overcoming the ambiguity of raw types.

### 4. Best Practices
*   **Code to the Interface**: Always declare variables using the interface (e.g., `List<String>`) rather than the concrete class (e.g., `ArrayList<String>`) to ensure flexibility (an OOP principle applied to Collections).
*   **Use the Diamond Operator (<>)**: Leverage Java's type inference to avoid redundant type declarations in the constructor call (`new ArrayList<String>()` becomes `new ArrayList<>()).`

---

## 🃏 Advanced Generics: Wildcards (?)

### 1. The Main Problem: Invariance
*   In normal Java, an `Integer` is a child of a `Number`.
*   But in Generics, a `List<Integer>` is NOT a child of a `List<Number>`.
*   This rule is called **Invariance**. It stops you from accidentally putting a `Double` into a list that was meant only for `Integer` objects.

### 2. The Solution: Wildcards (?)
*   Wildcards use the question mark symbol (`?`) to represent an unknown type.
*   They allow you to create safe boundaries so your code can be flexible but still secure.

### 3. Upper Bounded Wildcards (<? extends T>) — The Producers
*   **What it means**: It allows a list of type `T` or any child class underneath `T` (e.g., `<? extends Number>` can accept a list of `Integers` or `Doubles`).
*   **The Rule (Producers)**: You are only allowed to **READ** data out of this list.
*   **The Restriction**: You **CANNOT WRITE** (add) items into it because the compiler doesn't know the exact child type inside.

### 4. Lower Bounded Wildcards (<? super T>) — The Consumers
*   **What it means**: It allows a list of type `T` or any parent class above `T` (e.g., `<? super Integer>` can accept a list of `Numbers` or `Objects`).
*   **The Rule (Consumers)**: You are safely allowed to **WRITE** (add) items of type `T` into this list.
*   **The Restriction**: You **CANNOT READ** items out as a specific type (it only returns a general `Object`) because the exact parent type is unknown.

### 5. The Golden Mnemonic: PECS
*   **Producer Extends**: Use `<? extends T>` if you only need to read data out.
*   **Consumer Super**: Use `<? super T>` if you only need to write data in.

### 6. Unbounded Wildcards (<?>)
*   **What it means**: It stands for absolutely any type at all (`<? extends Object>`).
*   **When to use it**: Use it for simple, read-only jobs that don't care about data types, such as checking `list.isEmpty()` or counting `list.size()`.


                                                                      ##DAY--->3

    # Advanced Generics: Subtyping, Wildcards, and Interfaces

This section breaks down the mechanics of type subtyping, invariance, multiple bounds, and core generic interfaces within Java.

---

## 1. Subtyping and Invariance

* **Subtyping (OOP):** In normal Java, a child class can stand in for a parent class. For example, `Integer` is a child of `Number`, so you can do:
```java
Number myNumber = new Integer(10);
```
* **Invariance (Generics):** Generics do not follow standard subtyping rules. A `List<Integer>` is not a child of `List<Number>`. They are treated as completely separate, incompatible types.
* **Why?** Java does this for safety. If `List<Integer>` was allowed to be a subtype of `List<Number>`, you could accidentally add a `Double` into a list that is supposed to contain only `Integer` objects. This would corrupt your data and cause a crash later.

---

## 2. Covariance vs. Contravariance Matrix

This table breaks down how subtyping behavior can change using arrays or generic wildcards:

| Concept | Rule | Behavior | Example |
| :--- | :--- | :--- | :--- |
| **Invariance** | Types must match exactly. | `List<Integer>` only matches `List<Integer>`. | Java Collections (Default) |
| **Covariance** | Keeps the normal subtyping order. | `Array<Integer>` is considered a subtype of `Array<Number>`. | Java Arrays (Unsafe; can cause runtime errors) |
| **Controlled Covariance** | Allowed using the `extends` keyword. | `List<? extends Number>` can accept a `List<Integer>`. | Producer Role (Read-Only) |
| **Contravariance** | Reverses the normal subtyping order. | `List<? super Integer>` can accept a `List<Number>`. | Consumer Role (Write-Only) |

---

## 3. Multiple Bounds (&)

You can force a generic type parameter (`T`) to follow multiple rules at the same time using the `&` symbol.
* **The Rule:** The first item in the list must be a class, and all items after it must be interfaces.
* **Syntax:** `<T extends ClassA & InterfaceB & InterfaceC>`
* **Example:** If `T` must be a `Booking` class, but also needs to be sortable (`Comparable`) and run in a queue (`Runnable`):
```java
public static <T extends Booking & Comparable<T> & Runnable> void processAndSchedule(List<T> bookingList) {
    bookingList.get(0).run();         // Works because of Runnable
    Collections.sort(bookingList);    // Works because of Comparable
    bookingList.get(0).getBookingId(); // Works because of Booking class
}
```

---

## 4. Generic Interfaces (Comparable, Comparator)

Java provides built-in generic interfaces to help handle objects safely without losing their type:
* **Comparable\<T\>:** Used inside a class to define its natural sorting order (e.g., sorting flights by price).
* **Comparator\<T\>:** Used as an external tool to define a custom sorting order (e.g., sorting flights by duration).

### Example: Implementing Comparable

```java
public class Flight implements Comparable<Flight> { // Tells Java we compare Flights
    private double price;

    @Override
    public int compareTo(Flight otherFlight) { // Compares this flight's price with another flight's price
        return Double.compare(this.price, otherFlight.price);
    }
}
```

# 🔬 Under the Hood: Type Erasure, Restrictions, and Advanced Generic Tools

This module explores how the Java Virtual Machine (JVM) handles generics internally, the operational limitations caused by this architecture, and the tools used to maintain safety.

---

## 1. The Core Secret: Type Erasure

* **Compile-Time vs. Runtime:** Generics only exist when you are writing and compiling your code. Once your code is compiled into a `.class` file, all generic types disappear. This process is called **Type Erasure**.
* **What happens to T?** The compiler replaces the placeholder `<T>` with a normal class, usually `Object`. For example, `List<String>` simply becomes a raw `List` in the background.
* **Invisible Casts:** Since the types are gone, how does Java know what data is coming out? The compiler secretly inserts manual casts for you in the background. You write `list.get(0)`, but the compiler changes it to `(String) list.get(0)` right before the code runs.

---

## 2. What You CANNOT Do (Because of Type Erasure)

Because the JVM forgets what `T` is at runtime, the following three things are strictly forbidden:
* **No `new T()`:** You cannot create an object of type `T` (e.g., `T item = new T();`). At runtime, Java would just see `new Object()`, which ruins the purpose.
* **No `instanceof T`:** You cannot check if an object is an instance of `T` (e.g., `if (obj instanceof T)`). At runtime, this becomes `instanceof Object`, which is always true and useless.
* **No `static` fields of type T:** You cannot make a static variable using `T`. Static fields are shared by all instances of a class, so it cannot belong to a specific type parameter.

---

## 3. The Array Conflict & Heap Pollution

* **Arrays vs. Generics:** Java Arrays are strict and check their data types at runtime (reified). Generics are checked only at compile-time and erased at runtime (erased).
* **The Ban:** Because they work completely differently, you cannot create an array of generics (e.g., `new List<String>[10]` is illegal).
* **Heap Pollution:** If Java allowed this mix, you could accidentally trick the system into putting a `Double` inside a `List<String>`, leading to hidden data corruption known as **Heap Pollution**.

---

## 4. Special Tools: @SafeVarargs and Bridge Methods

* **`@SafeVarargs` Annotation:** When a method takes a flexible number of generic arguments (varargs), Java creates an invisible array behind the scenes. This causes a compiler warning. Developers use `@SafeVarargs` to tell the compiler: "Don't worry, I promise my code is safe and won't corrupt the data."
* **Bridge Methods:** These are hidden, automatic methods generated by the compiler. They act as a "bridge" to make sure that old object inheritance rules still link up properly after the official generic type signatures are erased to `Object`.

---

## 5. Raw Types (The Old Way)

* **What it is:** A Raw Type means using a generic class without specifying a type inside angle brackets (e.g., writing `List` instead of `List<String>`).
* **Why it exists:** Java kept raw types around for backwards compatibility, so very old code written before Java 5 would not break.
* **The Rule:** You should never use raw types in modern code because they turn off all safety features and bring back the risk of runtime crashes.

