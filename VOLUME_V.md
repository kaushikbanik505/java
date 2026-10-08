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

---

## 🏛️ Core Interfaces of the Framework

The Java Collections Framework (JCF) is built on a set of core interfaces that act as blueprints for different types of data containers. Each interface defines a specific set of rules and behaviors, ensuring consistency across all its implementing classes.

### The Collection Interface (The Root)

The `Collection` interface serves as the foundational root of the entire collection hierarchy in Java. It defines essential methods that every single standard data container must share to ensure uniform manipulation.

<span style="color:#268bd2">⭐ The root blueprint establishes shared method contracts so that moving data between different types of containers requires no syntax rewriting.</span>

#### 🛠️ Essential Core Methods Defined by the Root Contract:
* **`add(E e)`** ── Inserts a specified element into the active container structure safely.
* **`remove(Object o)`** ── Pinpoints and removes a single instance of the matching target object from the collection.
* **`size()`** ── Evaluates the collection layout and returns the precise total count of elements currently held inside.
* **`contains(Object o)`** ── Executes a high-performance check returning `true` if the target object exists inside the container.

---

## 🌳 The Java Collection Hierarchy Map

The structural framework relationships shown in your architecture layout illustrate the complete hierarchy under the core inheritance tree.


---

                                                                  ##DAY2

### 🎨 Architecture Breakdown Matrix

<span style="color:#859900">⭐ solid solid arrows (──►) represent sub-interfaces extending parent interfaces, while dashed arrows (╌╌►) represent concrete classes implementing specific behavioral contracts.</span>

| Core Framework Component | Architectural Node Type | Key Role & Standard Operational Trait |
| :--- | :--- | :--- |
| **`Iterable`** | Interface (Top Root) | Allows an object to be the target of the enhanced "for-each" loop track. |
| **`Collection`** | Interface | Defines the universal basic data mutations (`add`, `remove`, `size`). |
| **`List`** | Interface | An **ordered collection** that allows positional control and duplicate elements. |
| **`Queue`** | Interface | Designed for **holding elements prior to processing** (FIFO order). |
| **`Deque`** | Interface | A double-ended queue supporting element insertion/removal at **both ends**. |
| **`Set`** | Interface | A collection containing **zero duplicate elements** (models mathematical sets). |
| **`SortedSet`** | Interface | A `Set` that guarantees its elements are maintained in an **ascending sorted order**. |
| **`NavigableSet`** | Interface | Extends `SortedSet` with navigation methods (`lower`, `floor`, `ceiling`, `higher`). |
| **`ArrayList`** | Concrete Class | Resizable-array implementation of the `List` interface. |
| **`LinkedList`** | Concrete Class | Doubly-linked list implementation. Implements **both** `List` and `Deque` interfaces. |
| **`ArrayDeque`** | Concrete Class | Resizable-array implementation of the `Deque` interface (Faster than `Stack`). |
| **`PriorityQueue`** | Concrete Class | An unbounded priority queue based on a priority heap ordering structure. |
| **`HashSet`** | Concrete Class | Backed by a hash table. Offers constant time performance for basic operations. |
| **`TreeSet`** | Concrete Class | A `NavigableSet` implementation backed by a Red-Black Tree layout structure. |

# 📦 Core JCF Implementations: Deep Dive and Real-World Usage

This module explores the core implementation variants across the List, Set, Queue, and Map interfaces, breaking down their underlying data structures and execution rules.

---

## 📜 Key List Implementations

### ArrayList
* This is the most common List implementation. 
* It uses a resizable array under the hood: When the existing underlying array becomes full, a newer underlying array replaces it. All the older elements are copied to this new underlying array.
* `ArrayList` follows a growth factor of 1.5 times (the newer underlying array is 1.5 times longer than the older underlying array).
* It's lightning-fast for random access (e.g., getting the 5th passenger in the list) but can be slower for insertions or deletions in the middle, as it has to shift all subsequent elements.
* This is because elements of `ArrayList` are stored in contiguous memory locations (accounting for the underlying array-based implementation).

### LinkedList
* This implementation uses a doubly-linked list.
* `LinkedList` internally uses the Node class, whose objects represent the nodes in the doubly-linked list.
* It’s perfect for scenarios with frequent insertions and deletions at the beginning or end of the list. 
* Think of it as a linked chain; adding a new link is simple, but finding a specific link in the middle requires traversing the whole chain.
* Similar to `ArrayList`, `LinkedList` also provides methods for accessing random elements, but it is relatively slower than `ArrayList`.
* This is because elements of `LinkedList` are stored in non-contiguous memory locations (accounting for the linked list-based implementation).

---

## 🧼 Key Set Implementations

### HashSet
* The most widely used Set implementation.
* Uses a `HashMap` internally for a hash-table-based implementation.
* It's incredibly fast for adding, removing, and checking for elements, but it does not maintain any order.

### LinkedHashSet
* This version maintains the insertion order of elements. If you add "New York," then "London," they will always appear in that order.
* Slower than `HashSet` but faster than `TreeSet`.

### TreeSet
* This implementation stores elements in a sorted order (either their natural order or a custom one). It's slower than `HashSet` but is invaluable when you need sorted data.
* Implements `SortedSet` and `NavigableSet`, which provides the features of storing elements in sorted order and navigational capabilities.
* Uses Red-Black-Tree-based implementation.

### 📝 Source Code (setuse.java)

```java
import java.util.HashSet;
import java.util.Set;

public class setuse {
    public static void main(String args[])

    {
        Set<String> setofcities = new HashSet<>(); // its help us avoid the duplication ...
        setofcities.add("mumbai");
        setofcities.add("jalandar");
        setofcities.add("mumbai"); // this one should get ignored ,,
        setofcities.add("hyderabad");
        setofcities.add("delhi");
        setofcities.add("chennai");
        setofcities.add("banglore");

        System.out.println("the folowings cities are ---->" + setofcities + "\n");

    }

}
```

### 3️⃣ Execution Output (setuse)
```text
the folowings cities are ---->[delhi, jalandar, hyderabad, banglore, chennai, mumbai]
```
*(Note: Because a HashSet does not maintain any order, the positions of cities can shuffle dynamically between different runs)*

---

### 🔍 Why Override equals() and hashCode() in a Set?

When you use custom objects in a Set (like `HashSet` or `LinkedHashSet`), you must override both the `equals()` and `hashCode()` methods to ensure the set behaves correctly, specifically regarding the core Set rule: uniqueness.

A Set uses these two methods to determine if two objects are logically the same and to efficiently store/retrieve them. The default implementations are inherited from the base Object class rely only on the object's memory address.

* **Default equals():** Checks if two object references point to the exact same memory location (`this == other`).
* **Default hashCode():** Returns a unique integer based on the object's memory address.

<span style="color:#268bd2">⭐ Failing to override equals() and hashCode() for custom class keys within a HashSet will result in duplicate entities leaking into your collection.</span>

---

## ⏳ Key Queue Implementations

### PriorityQueue
* This queue doesn't follow FIFO strictly; instead, it orders elements based on their priority. 
* For example, a high-priority customer service request would be handled before a low-priority one, even if it came in later.
* Uses a Min-Heap-based implementation.

### ArrayDeque
* A double-ended queue that allows for additions and removals from both the head and the tail. 
* It can be used as a faster alternative to `LinkedList` for both queues and stacks.
* Uses a Resizable Circular Array-based implementation.

### 📝 Source Code (queuelearning.java)

```java
import java.util.LinkedList;
import java.util.Queue;

public class queuelearning {
    public static void main(String args[])

    {
        Queue<String> supportRequests = new LinkedList<>();
        supportRequests.add("Request for flight change");
        supportRequests.add("Request for refund");

        System.out.println("Next request to handle: " + supportRequests.peek()); // peek() gets the head without
                                                                                 // removing
        System.out.println("Handling request: " + supportRequests.poll()); // poll() gets and removes the head

    }
}
```

### 3️⃣ Execution Output (queuelearning)
```text
Next request to handle: Request for flight change
Handling request: Request for flight change
```

---

## 🗺️ Key Map Implementations

### HashMap
* Maps keys to values using a hashing mechanism, allowing quick retrieval by matching keys.
* Does not guarantee any specific iteration order of keys or values.

### 📝 Source Code (hashmap.java)

```java
import java.util.HashMap;
import java.util.Map;

public class hashmap {
    public static void main(String args[])

    {
        Map<Integer, String> customerIdToName = new HashMap<>();
        customerIdToName.put(101, "John Doe");
        customerIdToName.put(102, "Jane Smith");

        System.out.println("Customer with ID 101: " + customerIdToName.get(101));
        System.out.println("Customer with ID 102: " + customerIdToName.get(102));
        System.out.println("Customer with ID 103: " + customerIdToName.get(103));

    }
}
```

### 3️⃣ Execution Output (hashmap)
```text
Customer with ID 101: John Doe
Customer with ID 102: Jane Smith
Customer with ID 103: null
```
*(Note: Attempting to pull key `103` returns `null` because no mapping has been explicitly assigned to it inside the map instance)*
## 🧭 Iterators: The Collection's Tour Guide 
An Iterator is an object that lets you walk through a collection one element at a time. It's a universal way to access elements in any Collection without needing to know its internal structure. This is especially useful for Sets and Maps, which don't have a specific order. The Iterator interface provides three methods: hasNext(), next(), and remove().

ListIterator is an upgraded Iterator specifically for Lists. It allows you to move both forward and backward, and even add or set elements.
Enumeration is a very old, legacy interface, now replaced by Iterator.

### 📝 Source Code (iterator.java)
```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class iterator {
    public static void main(String args[]) {
        Set<String> object = new HashSet<>();
        object.add("mumbai");
        object.add("jalandar");
        object.add("hyderabad");

        Iterator<String> itr = object.iterator();

        for (int i = 0; i < object.size(); i++) {
            System.out.println(itr.next());
        }

        System.out.println("\n");
        // // method 2
        while (itr.hasNext()) {
            System.out.println(itr.next()); // out put should be same
        }
    }
}
```

### 3️⃣ Execution Output (iterator)
```text
hyderabad
jalandar
mumbai


```
*(Note: Since the for-loop completely drains the Iterator elements by calling `.next()` for the size of the set, the subsequent `while (itr.hasNext())` block under Method 2 evaluates to false and does not print anything further because the cursor has already reached the end of the collection)*

---

## ⚖️ Comparable vs. Comparator: The Sorting Rulebook
When you need to sort objects in a collection, you have two primary options.

Comparable: This interface defines a class's natural ordering. If a class implements Comparable, you're saying "objects of this type know how to sort themselves." The compareTo() method is used to compare this object with another.
Comparator: This interface is for external sorting. You use a Comparator when you want to sort objects based on a different rule or if you can't modify the class's source code. You're creating a separate sorting rulebook. Its compare() method takes two objects and compares them.

### 📝 Source Code (SortingDemo.java)
```java
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Flight implements Comparable<Flight> {
    public int price;
    public int duration;

    public Flight(int price, int duration) {
        this.price = price;
        this.duration = duration;
    }

    // Implementing Comparable for natural sorting by price
    @Override
    public int compareTo(Flight otherFlight) {
        return Integer.compare(this.price, otherFlight.price);
    }
}

public class SortingDemo {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(500, 120));
        flights.add(new Flight(250, 60));

        // Sorting by natural order (price)
        Collections.sort(flights);
        System.out.println("Cheapest flight price: $" + flights.get(0).price);

        // Using a Comparator for custom sorting by duration
        flights.sort(Comparator.comparing(f -> f.duration));
        System.out.println("Shortest flight duration: " + flights.get(0).duration + " mins");
    }
}
```

### 3️⃣ Execution Output (SortingDemo)
```text
Cheapest flight price: \$250
Shortest flight duration: 60 mins
```

---

## 🤝 equals() and hashCode() Contract: The Key to Hashing 
This contract is crucial for any object you plan to use as a key in a HashMap or store in a HashSet.

equals(): This method determines if two objects are logically the same.
hashCode(): This method returns an integer hash code for the object.
The Rule: If two objects are considered equal by the equals() method, they must have the same hash code. The reverse is not required. If you violate this rule, HashSet and HashMap can't find your object, leading to bugs.

---

## 🔗 LinkedList Use Case

### 📝 Source Code (Linkedlist.java)
```java
import java.util.LinkedList;
import java.util.List;

public class Linkedlist {
    public static void main(String[] args) {
        List<String> cancellationQueue = new LinkedList<>();
        cancellationQueue.add("VXE-104");
        cancellationQueue.add("VXE-105");
        cancellationQueue.add("VXE-106");
        System.out.println("Processing next cancellation: " + ((LinkedList<String>) cancellationQueue).removeFirst()); // fast removeal from head 
    }
}
```

### 3️⃣ Execution Output (Linkedlist)
```text
Processing next cancellation: VXE-104
```

---

## 🔮 HashSet vs. LinkedHashSet vs. TreeSet: Uniqueness with a Twist
All three are for storing unique elements, but they differ in how they handle order.

HashSet: This is a blazingly fast set that uses a hash table. Think of it as a jumbled box of unique items. You can quickly check if an item is in the box, but you can't rely on the order of the items. It's the go-to for speed.
LinkedHashSet: This one is a bit like a line of unique people waiting to board. It maintains the order in which you added the elements. It's slightly slower than HashSet but is useful when the order of insertion is important.
TreeSet: This set is like an alphabetized directory of unique city destinations. It stores elements in a sorted order (either their natural order or using a Comparator). While slower than the other two, it's invaluable for sorted data retrieval.

### 📝 Source Code (Hashset_LinkedHashSet_Treeset.java)
```java
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Hashset_LinkedHashSet_Treeset {
    public static void main(String[] args) {
        Set<String> unorderedDestinations = new HashSet<>();
        unorderedDestinations.add("London");
        unorderedDestinations.add("New York");
        unorderedDestinations.add("Paris");
        System.out.println("HashSet (unordered): " + unorderedDestinations); // no one as it is 

        Set<String> orderedDestinations = new LinkedHashSet<>();
        orderedDestinations.add("London");
        orderedDestinations.add("Paris");
        orderedDestinations.add("New York");
        System.out.println("LinkedHashSet (insertion order): " + orderedDestinations); // as per order 

        Set<String> sortedDestinations = new TreeSet<>();
        sortedDestinations.add("New York");
        sortedDestinations.add("Paris");
        sortedDestinations.add("London");
        System.out.println("TreeSet (sorted order): " + sortedDestinations); // as per sorting 
    }
}
```

### 3️⃣ Execution Output (Hashset_LinkedHashSet_Treeset)
```text
HashSet (unordered): [New York, Paris, London]
LinkedHashSet (insertion order): [London, Paris, New York]
TreeSet (sorted order): [London, New York, Paris]
```
*(Note: The printed arrangement of elements inside the HashSet can show up differently depending on the Java runtime version setup because it uses bucket hashing positions instead of maintaining user placement sequences)*

---

## 🗺️ Key-Value Map Variant Implementations

### 📝 Source Code (Hashset_LinkedHashSet_Treeset2.java)
```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

public class Hashset_LinkedHashSet_Treeset2 {
    public static void main(String[] args) {

        Map<Integer, String> unorderedCustomers = new HashMap<>();
        unorderedCustomers.put(103, "Sarah");
        unorderedCustomers.put(101, "Alex");
        unorderedCustomers.put(102, "Maria");
        System.out.println("HashMap (unordered): " + unorderedCustomers);

        Map<Integer, String> orderedCustomers = new LinkedHashMap<>();
        orderedCustomers.put(103, "Sarah");
        orderedCustomers.put(101, "Alex");
        orderedCustomers.put(102, "Maria");
        System.out.println("LinkedHashMap (insertion order): " + orderedCustomers);

        Map<Integer, String> sortedCustomers = new TreeMap<>();
        sortedCustomers.put(103, "Sarah");
        sortedCustomers.put(101, "Alex");
        sortedCustomers.put(102, "Maria");
        System.out.println("TreeMap (sorted by key): " + sortedCustomers);
    }
}
```

### 3️⃣ Execution Output (Hashset_LinkedHashSet_Treeset2)
```text
HashMap (unordered): {101=Alex, 102=Maria, 103=Sarah}
LinkedHashMap (insertion order): {103=Sarah, 101=Alex, 102=Maria}
TreeMap (sorted by key): {101=Alex, 102=Maria, 103=Sarah}
```

---

## ⚡ Fail-Fast vs. Fail-Safe Iterators: The Iterator's Promise

This concept is crucial for multi-threaded applications. When you use an Iterator to traverse a collection, you expect the collection to remain stable.

Fail-fast iterators will throw a ConcurrentModificationException if you modify the underlying collection while iterating over it (for example, by adding an item). This is a helpful "fail-fast" behavior that immediately alerts you to a potential bug.
Fail-safe iterators operate on a copy of the collection. This means you can modify the original collection while iterating without an exception, but the iterator won't see the changes.

### 📝 Source Code (VoyexaFailFastDemo.java)
```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VoyexaFailFastDemo {
    public static void main(String[] args) {
        List<String> newBookings = new ArrayList<>();
        newBookings.add("BKG-001");
        newBookings.add("BKG-002");

        Iterator<String> iterator = newBookings.iterator();

        while (iterator.hasNext()) {
            System.out.println("Processing booking: " + iterator.next());

            // Simulating a new booking coming in and modifying the list
            if (newBookings.size() == 2) {
                // This will cause a ConcurrentModificationException
                newBookings.add("BKG-003"); // means create a error
            }
        }
    }
}
```

### 3️⃣ Execution Output (VoyexaFailFastDemo)
```text
Processing booking: BKG-001
Exception in thread "main" java.util.ConcurrentModificationException
    at java.base/java.util.ArrayList\$Itr.checkForComodification(ArrayList.java:1013)
    at java.base/java.util.ArrayList\$Itr.next(ArrayList.java:967)
    at VoyexaFailFastDemo.main(VoyexaFailFastDemo.java:16)
```
