                                                                      ##DAY1
[Back to Table of Contents](./README.md) 


---

# 🧵 Java Strings: Sequences and Reference Mechanics

A **String in Java** is an object that represents a **sequence of characters**. It's not a primitive data type like `int` or `char`. This distinction is crucial because it means a String variable holds a **reference to an object in memory**, not the value itself.

---

## 2.1 String Pool: The Memory Optimization Technique

The **String Pool** is a memory optimization technique. When you create a string literal (e.g., `"Hello"`), the Java Virtual Machine (JVM) first checks a special area in memory called the **String Pool**. 

* **Existing Value:** If a string with the same value already exists, it doesn't create a new object. Instead, it just **returns a reference** to the existing one. This saves memory. 
* **Using the `new` Keyword:** However, if you use the `new` keyword, you're explicitly telling the JVM to create a **brand new object in the heap memory**, regardless of whether the value already exists in the String Pool.

⭐ When creating a string literal, the JVM checks the String Pool first to optimize memory allocation.

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

\[{\color{green}\text{⭐ String Immutability allows the String Pool to work, as shared string objects can be trusted not to change unexpectedly.}}\]

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

---
