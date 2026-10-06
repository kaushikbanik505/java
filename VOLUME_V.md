                                                                   ##DAY1

 [Back to Table of Contents](./README.md)                                                                   

# Java Collections Framework (JCF)

The Java Collections Framework (JCF) is not just a feature; it’s a high-performance toolbox for managing groups of objects (data) in Java.

Instead of relying on a simple, one-size-fits-all approach like a basic array, the JCF provides a set of standardized interfaces and classes that are pre-built, tested, and highly efficient for storing and manipulating data. Using the JCF makes your code more reliable, efficient, and standardized.

---

## How to Read the Syntax

When you see `List<String> flightList = new ArrayList<>();`:

*   **`List<String>`**: "This is a list that can only hold String objects."
*   **`new ArrayList<>()`**: The empty brackets on the right are called the **Diamond Operator**. They tell Java: "Use the same type I already mentioned on the left (String)."

### Why We Use Them in Collections
1. **Type Safety**: You get an error while writing the code (compile-time) if you try to add the wrong data type, rather than your app crashing while a user is using it (run-time).
2. **No More Casting**: When you pull an item out of a `List<String>`, Java already knows it's a String. You don't have to manually tell the computer: "Trust me, this is a String."

### Why This Works for Your Curriculum
*   **Reduces Cognitive Load**: It explains the "weird symbols" without requiring them to understand Type Erasure, Wildcards, or Bounded Types yet.
*   **Promotes Best Practices**: It prevents learners from using "Raw Types" (writing just List without `<>`), which is a bad habit that generates compiler warnings.

---

## Collection vs. Collections: The Name Game

This is a classic distinction that can trip up beginners. It's simple once you know the difference.

*   **Collection (singular)**: This is the interface and the root of the hierarchy. It's the blueprint that defines the fundamental methods that all collections must have, such as `add()`, `remove()`, and `size()`.
*   **Collections (plural)**: This is a utility class. It provides static helper methods to perform common operations on collections, like `Collections.sort()` to sort a list or `Collections.shuffle()` to randomize it.

---

## Code Example: Sorting an ArrayList

```java
import java.util.ArrayList;
import java.util.Collections;

public class practise5 {
    public static void main(String[] args) {
        ArrayList<String> flights = new ArrayList<>();
        flights.add("Flight 2");
        flights.add("Flight 1");
        flights.add("Flight 5");
        flights.add("Flight 4");
        flights.add("Flight 3");

        Collections.sort(flights); // sorting the arrayList

        for (int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i));
        }
    }
}
```

### Expected Console Output
```text
Flight 1
Flight 2
Flight 3
Flight 4
Flight 5
```
