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
