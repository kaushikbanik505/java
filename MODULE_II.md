[Back to Table of Contents](./README.md)

                                                              ##DAY--->1
## ⚙️ Concept: Process :-->
The fundamental building block of an application in an operating system is the Process. A process is essentially an independent instance of a running program. It owns its own resources, including a complete, private memory space, code, data, and files. Processes are isolated from each other. If one process crashes, it typically doesn't affect the others.

---

## 🧵 Threads:---> 
A Thread, on the other hand, is the smallest unit of execution within a process. Threads are often called lightweight processes because they share the process's resources, particularly its memory space (Heap and Code segments).

*** threads are a part of a process and generally used the process resource to execute itself . 	
Shares memory space and resources with other threads in the same process.

---

## 🛠️ Basic Thread Operations
### Concept: start(), sleep(), yield(), join()
These static methods in the Thread class provide basic control over thread execution:

* **start():** Mandatory. Puts the thread into the RUNNABLE state and calls the run() method in a new thread of execution. Calling run() directly will execute the method on the current thread, not a new thread!
* **sleep(long millis):** Causes the currently executing thread to move to the TIMED_WAITING state for a specified duration. It does not release any locks the thread might hold.
* **yield():** A hint to the scheduler that the current thread is willing to temporarily pause its execution and allow other threads of the same or higher priority to run. There is no guarantee that the scheduler will follow this hint.
* **join():** Makes the calling thread (e.g., the main thread) wait for the thread on which join() is called to finish its execution (move to the TERMINATED state). This ensures that one thread completes before another begins or continues.

## 🧵 Basic code for threads -->

### 📝 Source Code (basicthread.java)
```java
class A extends Thread {
    public void run()// it is mendetory to use run() only in thread creation
    {
        for (int i = 1; i < 100; i++) {
            System.out.println("hi");
        }
    }
}

class B extends Thread {
    public void run()// it is mendetory to use run() only in thread creation
    {
        for (int i = 1; i < 100; i++) {
            System.out.println("hello");
        }
    }
}

public class basicthread {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        obj1.start();
        obj2.start();
    }

}
```

### 3️⃣ Execution Output (basicthread)
```text
hi
hi
hello
hello
hi
hello
... (repeats 99 times for "hi" and 99 times for "hello" in an interleaved, unpredictable order depending on CPU thread scheduling)
```

---

## ⚠️ Shared Mutable State (SMS)

State refers to the variables (fields) within an object.

* **Mutable** means the value of the variable can be changed after the object is created.
* **Shared** means the same variable is accessible by multiple threads executing concurrently.
* **Shared Mutable State (SMS)** is the primary source of all concurrency bugs. When two or more threads can read and write to the same variable without proper synchronization, the result of the program becomes unpredictable and unreliable.

### Code Illustration:

```java
// count is the Shared Mutable State (SMS)
class Counter {
    private int count = 0; // MUTABLE (can be changed)
    
    public void increment() {
        count = count + 1; // MODIFIES state
    }
    public int getCount() {
        return count; // READS state
    }
}
// If two threads call counter.increment() simultaneously,
// a race condition occurs, and count might only increment once.
```

### 3️⃣ Execution Output / Behavior Illustration (Counter)
```text
// Note: This snippet defines the Counter blueprint without a main() entry point.
// If Thread 1 and Thread 2 both call counter.increment() 1000 times concurrently (2000 expected):
Expected Final Count: 2000
Actual Final Count (Race Condition): 1842 (unpredictable value < 2000 due to lost updates)
```

---

### Why Shared Mutable State is Problematic (Non-Atomic Operations)
The problem arises because simple operations like `count = count + 1` are not executed as a single, indivisible step by the CPU. Instead, the Java Virtual Machine (JVM) breaks this operation into three steps:

1. **Read:** Read the current value of count from memory into a register/cache.
2. **Modify:** Increment the value in the register/cache.
3. **Write:** Write the new value back to main memory.


                                                             ##DAY-->2

   
## 1. Synchronized Blocks & Methods

* **Core Purpose:** The `synchronized` keyword enforces thread safety by ensuring only one thread can execute a critical section of code at a time.
* **Dual Protection:** It solves both Race Conditions (atomicity) and Visibility Problems (flushing/reading changes directly to and from main memory).
* **Synchronized Methods:** Locks the entire method automatically using `this` (for instance methods) or `ClassName.class` (for static methods).
* **Synchronized Blocks:** Locks only a specific section of code using an explicit lock object, which lowers thread contention and improves performance.

### 📝 Source Code (Counter.java)
```java
public class Counter {
    private int count = 0;
    private final Object lock = new Object();

    // 1. Synchronized Method (Locks 'this')
    public synchronized void increment() {
        count++;
    }

    // 2. Synchronized Block (Locks only the critical section)
    public void safeAdd() {
        synchronized (lock) {
            count++;
        }
    }
}
```

### 3️⃣ Execution Output / Behavior Illustration (Counter)
```text
// Note: This class defines thread-safe increment operations without a main() method.
// If Thread 1 and Thread 2 each call increment() or safeAdd() 1000 times concurrently:
Expected Final Count: 2000
Actual Final Count (Thread-Safe): 2000 (Zero lost updates due to mutual exclusion)
```

---

## 2. Intrinsic Locks (Monitors) & Thread States

* **Built-in Locks:** Every Java object has an invisible Intrinsic Lock (Monitor) built into its header, managed automatically by the JVM (even if an exception occurs).
* **Happens-Before Guarantee:** Releasing a lock flushes changes to main memory before the next thread acquires that lock, ensuring fresh data.
* **Thread Lifecycle Effects:**
  * Waiting for a busy lock puts a thread in the `BLOCKED` state.
  * Calling `Object.wait()` inside a synchronized block moves the thread to `WAITING` and temporarily releases the lock.
  * Exiting the synchronized code releases the lock and lets waiting threads become `RUNNABLE`.

---

## 3. Reentrancy

* **Definition:** Java's intrinsic locks are reentrant, meaning a thread can re-acquire a lock it already holds without blocking itself.
* **Hold Count:** The JVM tracks a hold count for the lock (incrementing on entry, decrementing on exit) and only fully releases it when the count reaches `0`.
* **Why it Matters:** It prevents self-deadlocks when a synchronized method calls another synchronized method on the same object, uses recursion, or calls a super method.

### 📝 Source Code (ReentrantDemo.java)
```java
public class ReentrantDemo {
    public synchronized void methodA() {
        // Thread acquires lock (hold count = 1)
        methodB(); 
    } // Thread releases lock (hold count = 0)

    public synchronized void methodB() {
        // Same thread safely re-enters (hold count = 2)
    } // Decrements (hold count = 1)
}
```

### 3️⃣ Execution Output / Behavior Illustration (ReentrantDemo)
```text
// Note: Blueprint class without a main() entry point.
// When a thread invokes obj.methodA():
1. Acquires lock on 'obj' -> Hold Count = 1
2. Enters methodB() on 'obj' without blocking -> Hold Count = 2
3. Exits methodB() -> Hold Count = 1
4. Exits methodA() -> Hold Count = 0 (Lock completely released)
```

---

## 4. volatile Keyword

* **Visibility Only:** `volatile` forces threads to always read and write a variable directly to main memory instead of local CPU caches.
* **No Atomicity:** It prevents stale data, but it does not make compound operations (like `count++`) thread-safe.
* **Best Use Case:** Ideal for simple status flags shared across threads (like stopping a background loop).

### 📝 Source Code (Worker.java)
```java
public class Worker {
    // Guarantees all threads immediately see when this changes to true
    public volatile boolean shutdownRequested = false;

    public void stop() {
        shutdownRequested = true;
    }

    public void run() {
        while (!shutdownRequested) {
            // Keep working until another thread calls stop()
        }
    }
}
```

### 3️⃣ Execution Output / Behavior Illustration (Worker)
```text
// Note: Blueprint class without a main() entry point.
// Thread A executes worker.run() continuously while shutdownRequested == false.
// Thread B invokes worker.stop() -> writes shutdownRequested = true directly to main memory.
// Thread A immediately reads the updated value from main memory and cleanly exits the while loop.
```


## 1. Synchronized Blocks & Methods

* **Core Purpose:** The `synchronized` keyword enforces thread safety by ensuring only one thread can execute a critical section of code at a time.
* **Dual Protection:** It solves both Race Conditions (atomicity) and Visibility Problems (flushing/reading changes directly to and from main memory).
* **Synchronized Methods:** Locks the entire method automatically using `this` (for instance methods) or `ClassName.class` (for static methods).
* **Synchronized Blocks:** Locks only a specific section of code using an explicit lock object, which lowers thread contention and improves performance.

### 📝 Source Code (Counter.java)
```java
public class Counter {
    private int count = 0;
    private final Object lock = new Object();

    // 1. Synchronized Method (Locks 'this')
    public synchronized void increment() {
        count++;
    }

    // 2. Synchronized Block (Locks only the critical section)
    public void safeAdd() {
        synchronized (lock) {
            count++;
        }
    }
}
```

### 3️⃣ Execution Output / Behavior Illustration (Counter)
```text
// Note: This class defines thread-safe increment operations without a main() method.
// If Thread 1 and Thread 2 each call increment() or safeAdd() 1000 times concurrently:
Expected Final Count: 2000
Actual Final Count (Thread-Safe): 2000 (Zero lost updates due to mutual exclusion)
```

---

## 2. Intrinsic Locks (Monitors) & Thread States

* **Built-in Locks:** Every Java object has an invisible Intrinsic Lock (Monitor) built into its header, managed automatically by the JVM (even if an exception occurs).
* **Happens-Before Guarantee:** Releasing a lock flushes changes to main memory before the next thread acquires that lock, ensuring fresh data.
* **Thread Lifecycle Effects:**
  * Waiting for a busy lock puts a thread in the `BLOCKED` state.
  * Calling `Object.wait()` inside a synchronized block moves the thread to `WAITING` and temporarily releases the lock.
  * Exiting the synchronized code releases the lock and lets waiting threads become `RUNNABLE`.

---

## 3. Reentrancy

* **Definition:** Java's intrinsic locks are reentrant, meaning a thread can re-acquire a lock it already holds without blocking itself.
* **Hold Count:** The JVM tracks a hold count for the lock (incrementing on entry, decrementing on exit) and only fully releases it when the count reaches `0`.
* **Why It Matters:** It prevents self-deadlocks when a synchronized method calls another synchronized method on the same object, uses recursion, or calls a super method.

### 📝 Source Code (ReentrantDemo.java)
```java
public class ReentrantDemo {
    public synchronized void methodA() {
        // Thread acquires lock (hold count = 1)
        methodB(); 
    } // Thread releases lock (hold count = 0)

    public synchronized void methodB() {
        // Same thread safely re-enters (hold count = 2)
    } // Decrements (hold count = 1)
}
```

### 3️⃣ Execution Output / Behavior Illustration (ReentrantDemo)
```text
// Note: Blueprint class without a main() entry point.
// When a thread invokes obj.methodA():
1. Acquires lock on 'obj' -> Hold Count = 1
2. Enters methodB() on 'obj' without blocking -> Hold Count = 2
3. Exits methodB() -> Hold Count = 1
4. Exits methodA() -> Hold Count = 0 (Lock completely released)
```

---

## 4. volatile Keyword

* **Visibility Only:** `volatile` forces threads to always read and write a variable directly to main memory instead of local CPU caches.
* **No Atomicity:** It prevents stale data, but it does not make compound operations (like `count++`) thread-safe.
* **Best Use Case:** Ideal for simple status flags shared across threads (like stopping a background loop).

### 📝 Source Code (Worker.java)
```java
public class Worker {
    // Guarantees all threads immediately see when this changes to true
    public volatile boolean shutdownRequested = false;

    public void stop() {
        shutdownRequested = true;
    }

    public void run() {
        while (!shutdownRequested) {
            // Keep working until another thread calls stop()
        }
    }
}
```

### 3️⃣ Execution Output / Behavior Illustration (Worker)
```text
// Note: Blueprint class without a main() entry point.
// Thread A executes worker.run() continuously while shutdownRequested == false.
// Thread B invokes worker.stop() -> writes shutdownRequested = true directly to main memory.
// Thread A immediately reads the updated value from main memory and cleanly exits the while loop.
```




