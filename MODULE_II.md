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
