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
