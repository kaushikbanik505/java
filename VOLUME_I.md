# VOLUME I: FUNDAMENTALS

[Back to Table of Contents](./README.md)

---

## Chapter 1: Variables and Primitive Data Types

### 📄 Page 1.1: The Java Virtual Machine & Memory Basics
Java is a statically-typed, class-based language. When Java code is compiled, it is not turned into machine code that your computer's CPU runs directly. Instead, it is compiled into bytecode (.class files). 

$${\color{blue}\text{The Java Virtual Machine (JVM) reads and executes this bytecode.}}$$

$${\color{green}\text{This architecture allows Java to achieve its core philosophy: "Write Once, Run Anywhere" (WORA).}}$$

In memory, variables are containers that hold data. Because Java is strictly typed, every container must be declared with a specific data type before it can be used to store values.

---

### 📄 Page 1.2: Primitive Data Types Reference
Java features eight built-in primitive data types. 

$${\color{orange}\text{Primitive types hold pure values directly in memory rather than referencing objects.}}$$

* **byte**: 8-bit signed integer. Range: -128 to 127.
* **short**: 16-bit signed integer. Range: -32,768 to 32,767.
* **int**: 32-bit signed integer. Range: -2^31 to 2^31-1. This is the default choice for whole numbers.
* **long**: 64-bit signed integer. Used for values exceeding the integer range. Declared with an L suffix (e.g., 3000000000L).
* **float**: 32-bit single-precision floating-point number. Declared with an f suffix (e.g., 3.14f).
* **double**: 64-bit double-precision floating-point number. This is the default choice for decimal values.
* **boolean**: Represents 1 bit of information. Can only hold the values true or false.
* **char**: 16-bit Unicode character. Stores a single character enclosed in single quotes (e.g., 'A').

---

## Chapter 2: Control Flow Structures

### 📄 Page 2.1: Conditional Branching (if-else, switch)
Control flow structures determine the order in which statements execute based on runtime evaluations.

Conditional execution relies on boolean expressions that resolve to either true or false:

* **if statement**: Executes a block of code if the specified condition resolves to true.
* **else if statement**: Specifies a new condition to test if the first condition resolves to false.
* **else statement**: Executes a fallback block of code if all preceding conditions resolve to false.

$${\color{red}\text{switch statement: Tests a variable against cases. Requires a break; statement to prevent falling through.}}$$

---

### 📄 Page 2.2: Loops and Iteration (for, while)
Iteration structures allow code blocks to execute repeatedly based on terminal conditions.

* **while loop**: Continuously executes a block of code as long as its target condition evaluates to true. The condition is checked before the loop body runs.
* **do-while loop**: Evaluates the condition after executing the loop body, guaranteeing that the code block runs at least once.
* **for loop**: Combines initialization, condition evaluation, and variable updates into a single line. Ideal when the total number of required iterations is known before execution begins.

$${\color{green}\text{enhanced for loop (for-each): Designed to iterate through arrays and collections without index tracking.}}$$

---

## Chapter 3: String Architecture and Manipulation

### 📄 Page 3.1: String Immutability and Memory Management
In Java, strings are treated as objects rather than primitive data types. They are managed by the java.lang.String class.

$${\color{red}\text{A critical structural property of Java strings is immutability.}}$$

Once a String object is allocated in memory, its value cannot be modified. Any operation that appears to alter a string (such as concatenation using the + operator) actually instantiates a completely new String object in memory.

$${\color{blue}\text{To optimize performance and save space, Java stores strings inside the String Constant Pool.}}$$

---

### 📄 Page 3.2: Essential String Methods and StringBuilder
Because strings cannot be edited directly, Java provides tools to read data from them or construct new strings efficiently.

* **.length()**: Returns the total number of characters in the string, including spaces and symbols.
* **.charAt(int index)**: Extracts the single character located at the specified index. Java strings use 0-based indexing.

$${\color{red}\text{Never use the == operator to compare string values, as == checks memory locations, not text matching.}}$$

* **.equals(Object obj)**: Compares the actual character sequences of two strings to check if they are identical.
* **StringBuilder**: A companion class used when a program needs to modify text repeatedly (such as inside a loop). StringBuilder creates a mutable sequence of characters, preventing the memory overhead of creating multiple temporary String objects.

---

## Chapter 4: Arrays and Linear Data Storage

### 📄 Page 4.1: Array Initialization and Memory Layout
An array is a fixed-size data structure that stores a collection of elements sharing the exact same data type.

$${\color{orange}\text{Fixed Size: The capacity of an array must be explicitly declared when it is created. It cannot grow or shrink.}}$$

* **Contiguous Memory**: Arrays allocate a single continuous block of memory to store elements. This allows the system to access any element instantly if its index is known.
* **Default Values**: When an array is instantiated without explicit values, Java automatically fills it with default values (0 for numeric types, false for booleans, and null for objects).

---

### 📄 Page 4.2: Array Indexing and Traversal
Elements within an array are managed using numerical position indicators called indices.

* **Index Constraints**: Array indexing begins at 0. The final element of any array is always located at index length - 1.

$${\color{blue}\text{The length Property: Arrays track their size using a built-in variable named .length without parentheses.}}$$

$${\color{red}\text{Boundary Safety: Out-of-bounds index tracking causes the JVM to throw an ArrayIndexOutOfBoundsException error.}}$$

---

[Back to Table of Contents](./README.md)

[⬅️ Back to Table of Contents](./README.md)
