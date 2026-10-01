                                                     ## DAY--1 
                                                     
[Back to Table of Contents](./README.md)                                                     
## OOP Hierarchy: Building Flexible Systems with Inheritance   

--> Inheritance is the OOP concept where a new class (the subclass or child class) is created by basing it on an existing class (the superclass or parent class).

1) parents class (Flight)---> the code of parents class is used in child class ..

2) child class (BusinessFlight) ---> where the parents class code is directly used ..

$${\color{blue}\text{4) ⭐ In Java inheritance, the parent class code is used in the child class.}}$$

5) for example 
   ----> public class BusinessFlight extends Flight { ... }

$${\color{green}\text{6) ⭐ The biggest advantage of Inheritance is Code Reusability.}}$$

7) 

## The super() Keyword: Proper Initialization

When a child object (a BusinessFlight) is created, it needs to ensure that the parent part of the object (the Flight part) is correctly set up first.

$${\color{orange}\text{The super() keyword is used inside the child's constructor to explicitly call the constructor of the parent class.}}$$

Role: It passes the basic, common properties (like flightNumber, origin) up to the parent to handle their initialization, ensuring the entire object is initialized correctly before the child adds its unique details.

## Method Overriding: Specialized Behavior

$${\color{blue}\text{The @Override annotation is used to signal this intent to the compiler.}}$$

Inside the overridden method, you can still call the original parent method using super.methodName() to reuse the core logic while adding new rules around it.



                                                  DAY/2 🧑‍🏫

# The `super()` Keyword: Handling Constructors in Inheritance

--> The `super()` keyword is basically used to call the parent class constructor inside a child class. When an object of a subclass is created, it must initialize the parent part of the object first before handling its own unique properties.

1. parents class (`Santosh`) ---> the constructor initializes the basic properties like age.
2. child class (`Kaushik`) ---> calls the parent constructor to set up parent properties before initializing its own properties.

4) ⭐ In Java inheritance, the parent constructor must be invoked first using `super()`.

5. for example ----> `class Kaushik extends Santosh { ... }`

6) ⭐ The biggest advantage of `super()` is proper initialization of inherited fields.

7. 

# Implementation Example: Proper Initialization

When a child object (a `Kaushik`) is created, it needs to ensure that the parent part of the object (the `Santosh` part) is correctly set up first. 

The `super()` keyword is used inside the child's constructor to explicitly call the constructor of the parent class.

Role: It passes the basic, common properties (like `age`) up to the parent to handle their initialization, ensuring the entire object is initialized correctly before the child adds its unique details (like `name`).

### 📝 Source Code

```java
// Parent Class
class Santosh {
    private int age;

    // Parent constructor
    public Santosh(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

// Child Class
class Kaushik extends Santosh {  
    private String name;

    // Child constructor
    public Kaushik(String name, int age) {
        super(age); // Passing the age up to the parent class constructor
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Main Class to execute the code
public class Main {
    public static void main(String[] args) {
        Kaushik person = new Kaushik("Kaushik", 25);
        
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
```

---

### 3️⃣ Execution Output

When you compile and run the program above, it will yield the following result:

```text
Name: Kaushik
Age: 25
```

# OOP Pillars: Building Dynamic Systems with Polymorphism

--> The third pillar of OOP, **Polymorphism** (meaning "many forms"), becomes your hero's ultimate weapon. It allows you to write one piece of generalized code that can seamlessly and correctly interact with objects of different classes that share a common heritage.

1. Polymorphism works because of the **"is-a" relationship** established by inheritance.

2. **Method Overriding in Action: Dynamic Dispatch** 
The magic happens when you call a method that has been overridden by the child class.

4) <span style="color:#268bd2">⭐ In Java polymorphism, runtime decision determines which overridden method gets executed.</span>

5. for example ----> `public class Dog extends Animal { ... }`

6) <span style="color:#859900">⭐ The biggest advantage of Method Overriding is achieving Runtime Polymorphism (Dynamic Method Dispatch).</span>

7. 

# Implementation Example: Method Overriding

When a child object (a `Dog`) calls a method that exists in both the parent and child classes, Java dynamically selects the child's implementation at runtime.

The `@Override` annotation is used inside the child's class to explicitly tell the compiler that we are redefining a parent method.

Role: It completely overrides the parent class method with a specific, custom implementation tailored to the child class.

### 📝 Source Code

```java
// Parent Class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child Class (inherits from Animal)
class Dog extends Animal {
    // Overriding the parent method to give it a specific behavior
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Execution Class
public class Main {
    public static void main(String[] args) {
        // Creating a child object
        Dog myDog = new Dog();
        
        // This will call the OVERRIDDEN version inside the Dog class
        myDog.makeSound(); 
    }
}
```

---

### 3️⃣ Execution Output

When you compile and run the program above, it will yield the following result (the parent class method was completely overridden by the child class):

```text
Dog barks
```


# OOP Pillars: Code Reusability and Polymorphism

--> Polymorphism allows the **reuse of code blocks** seamlessly. By writing generic code tailored to a parent class, you can instantly make it work with any present or future child classes without rewriting any logic.

1. Polymorphism means **"many forms"**, allowing one reference variable to take different shapes.

2. **Upcasting in Action:** We declare a variable using the parent class type but instantiate it using a child class type.

4) <span style="color:#268bd2">⭐ Java handles method calls dynamically based on the actual object type, not the reference type.</span>

5. for example ----> `Animal myDog = new Dog();`

6) <span style="color:#859900">⭐ The ultimate superpower of polymorphism is write-once, run-anywhere flexibility for custom class families.</span>

7. 

# Implementation Example: VoyexaApp2.java

When we create parent references like `Animal myDog` and `Animal myCat`, Java reuses the parent structure while executing the specific child methods at runtime.

The parent reference acts as a flexible interface, allowing clean management of different behaviors through identical method names.

Role: It completely decouples your code logic from hardcoded individual class types, making your architecture highly reusable.

### 📝 Source Code (VoyexaApp2.java)

```java
// Parent Class
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Child Class 1
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

// Child Class 2
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}

// Execution Class
public class VoyexaApp {
    public static void main(String[] args) {
        // Polymorphism: One common parent type holding different child objects
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        // The same method call produces different behaviors based on the object type
        myDog.makeSound(); 
        myCat.makeSound(); 
    }
}
```

---

### 3️⃣ Execution Output

When you compile and run the program above, it will yield the following result (the parent reference reuses identical code tracks but calls child behaviors):

```text
Dog barks: Woof Woof!
Cat meows: Meow Meow!
```

                                                                    ##DAY3

                                                                                                    

# Abstraction: Hiding Complexity with Contracts 

--> This requires the final OOP pillar: Abstraction. Abstraction is the principle of hiding complexity and only showing the essential features to the user (or to other developers).

1. Interfaces: The Universal Contract
2. In Java, we achieve clean abstraction primarily through Interfaces. An interface is a pure contract that defines a set of required public methods but provides zero implementation.
3. The Contract: We create the Bookable interface, which guarantees any class that implements it will have a specific method.

4) ⭐ Method Defined: The interface dictates: boolean book(int numberOfItems);

5. for example ----> `public class Flight implements Bookable { ... }`

6) ⭐ This abstraction allows your main application logic to be completely decoupled from the internal workings of the Flight or HotelRoom classes.

7. 

# Implementation Example: Fulfilling the Contract

To use the interface, our classes must agree to follow its rules using the implements keyword. Decoupling Logic: Focusing on the "What".

### 📝 Source Code

```java
// Abstract Parent Class (Hides details, defines the concept)
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void makeSound();
}

// Child Class (Provides the actual implementation)
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Main Class to run the code
public class Main {
    public static void main(String[] args) {
        // You cannot create an object of an abstract class like: new Animal();
        
        Animal myDog = new Dog(); // Using abstraction to refer to the object
        myDog.makeSound(); 
    }
}
```

---

### 3️⃣ Execution Output

```text
Dog barks
```

# OOP Hierarchy: Building Flexible Systems with Inheritance

Levels of Hierarchy Possible in Java  --> 
Java allows for virtually unlimited levels of hierarchy through inheritance but inheritance hierarchies (more than 3-4 levels) are generally discouraged 

* **Fragile:** Changes high up the chain can break code everywhere below it.
* **Complex:** Difficult to trace the source of a method implementation.

Also, Classes can inherit only one parent class. Hence, if you require a class to "inherit" features from multiple entities, you may require interfaces. With interfaces in Java, a class can implement more than one interface.

4) ⭐ Java allows virtually unlimited inheritance levels, but deep hierarchies (more than 3-4 levels) are discouraged.

5. for example ----> `class BusinessFlight extends Flight { ... }`

6) ⭐ Multiple inheritance is achieved using interfaces, as a class can inherit from only one parent class.

7.

# Introducing Inheritance: When and When Not To

--> Inheritance should only be introduced when the "is-a" relationship is logically and structurally sound.

### When to Introduce Inheritance
* **When there's a Clear "is-a" Relationship:** A `BusinessFlight` is a `Flight`. A `SavingsAccount` is an `Account`.
* **For Polymorphism:** When you want to treat a group of related objects in a unified way (e.g., calling `item.book()` on both `Flight` and `HotelRoom` if they extend an abstract `TravelItem` class).
* **To Share Common Code:** When subclasses need to inherit methods and fields from a parent, reducing redundant code.

### When NOT to Introduce Inheritance (Prefer Composition)
* **The "Has-a" Relationship:** If the relationship is "has-a" instead of "is-a."
  * **Bad Example:** Making an `Engine` extend a `Car`. A car has an engine, it is not an engine. **Prefer Composition:** The `Car` class should contain an `Engine` object.
* **Code Reuse is the Only Goal:** If you only need to reuse one or two methods from another class, use **Composition** (pass the object into your class or use its instance) instead of inheriting the entire class structure.

---

# Use "super" Carefully

--> The `super` keyword provides access to the immediate parent class member. Use it deliberately to maintain class contracts:

* **Constructors (super()):** This is essential. Always call the parent's constructor using `super(...)` as the first line in the child's constructor to ensure proper initialization of inherited fields.
* **Method Overriding (super.methodName()):** Use `super.methodName(...)` to execute the parent's implementation of an overridden method. This is useful when you want to extend the parent's logic, not replace it entirely (e.g., `BusinessFlight` adds a check, then calls `super.bookSeats()`).
* **Avoid Overuse:** If you find yourself constantly calling super methods, it might be a sign that the inheritance hierarchy is too deep or that the child class is too reliant on the parent's implementation details.

4) ⭐ The `super(...)` call must be the very first line inside a child class constructor.

6) ⭐ Use `super.methodName()` to extend parent logic during method overriding rather than completely replacing it.

---

# Cyclic Dependencies to be Prevented

--> A **Cyclic Dependency** occurs when Class A depends on Class B, and Class B simultaneously depends on Class A.

* **Example:** `Flight` contains a reference to `Airport`, and `Airport` contains a reference back to `Flight`.
* **Problem:** This tight, circular coupling makes the code very fragile and difficult to test and maintain. If you change Class A, you may have to change Class B, and that change in B might force another change in A.
* **Best Practice:** Design your classes to follow a **unidirectional dependency** (A depends on B, but B does not depend on A) or use **Interfaces** to break the direct coupling. For example, have a third entity (the `BookingService`) manage the relationships between `Flight` and `Airport`, instead of making them reference each other directly.

4) ⭐ Cyclic dependencies tightly couple classes, making code fragile, hard to test, and difficult to maintain.

6) ⭐ Break direct circular coupling by enforcing unidirectional dependencies or introducing intermediate interfaces.


# Abstract Class vs. Interface: Choosing Your Tool

--> The distinction is crucial for robust OOP design:

| Feature | Abstract Class | Interface |
| :--- | :--- | :--- |
| **Core Purpose** | Define a family of objects and share common code (related objects). | Define a contract or capability (unrelated objects can share). |
| **Implementation** | Can provide partial method implementation (concrete methods) and abstract methods. | Typically provides no method implementation (only signatures or default/static methods). |
| **Inheritance** | **Single Inheritance:** A class can only extend **one** abstract class. | **Multiple Implementation:** A class can implement **many** interfaces. |
| **Members** | Can have fields, constructors, and any access modifiers. | Cannot have instance fields or constructors (before Java 8, all members were implicitly public static final). |
| **Use Case** | Use for **core entities** where you need shared state/methods (e.g., abstract class `TravelItem`). | Use for **capabilities** that can cross entity lines (e.g., `Bookable`, `Priced`, `Schedulable`). |

4) ⭐ A class can extend only one abstract class but can implement multiple interfaces to achieve multiple inheritance of type.

5. for example ----> `abstract class TravelItem { ... }` vs `interface Bookable { ... }`

6) ⭐ Use abstract classes for core, related entities and interfaces for flexible, cross-cutting capabilities.

7. 
# Abstract Classes and Methods: Enforcing Blueprint Rules

--> An abstract class serves as an incomplete template. Its primary purpose is to provide a base structure that other classes can inherit and complete. You cannot instantiate an abstract class directly.

* **Instantiation Restriction:** If a class is declared abstract, you cannot create an object of it using the `new` keyword.
* **Abstract Methods:** These are method declarations without any implementation body `{}`. They act as placeholders, forcing child classes to provide the actual working logic.

4) ⭐ You cannot create an object of an abstract class directly in the main function using the `new` keyword.

5. for example ----> `abstract class Car { ... }`

6) ⭐ An abstract method has no body and can only exist inside an abstract class, forcing subclasses to implement it.

7.

# Implementation Example: Overriding Abstract Methods

When a child class extends an abstract parent class, it must implement all declared abstract methods to compile successfully. This allows you to define a common operation that behaves differently across child classes.

### 📝 Source Code

```java
// For an abstract method (function) to implement we need an abstract class
abstract class Car {
    // As I use the abstract keyword here, I can implement it later in another class
    // I may not need to implement the function here, all I need is to call it 
    // and implement later by using extends then the abstract class name
    public abstract void drive();
}

class WagonR extends Car {
   @override // using this is not necessary but it is a good practise ..
    public void drive() {
        System.out.println("WagonR is driving");
    }
}

public class AbstractMethod {
    public static void main(String[] args) {
        // We cannot make an object of an abstract class like: Car obj = new Car();
        WagonR obj = new WagonR();
        obj.drive();
    }
}
```

---

### 3️⃣ Execution Output

When you compile and run the program above, it will yield the following result:

```text
WagonR is driving
```

4) ⭐ Subclasses use the `extends` keyword to inherit from an abstract class and must override its abstract methods.

6) ⭐ The concrete child class provides the actual logic inside its own method block to fulfill the parent contract.

# Interfaces in Java: Designing Clean Contracts

--> An interface is not a class. It is a special, pure architectural tool that acts as a strict contract, defining capabilities without any concrete implementation. It provides a cleaner and more structured approach when designing application systems.

* **Implicit Modifiers:** Every method declared inside an interface is implicitly `public` and `abstract` by default. You do not need to explicitly write these keywords.
* **Fulfilling the Contract:** Since an interface only declares method signatures, the actual implementation logic must be provided later inside a concrete class using the `implements` keyword.

4) ⭐ An interface is not a class; it is a structural contract where all methods are implicitly public and abstract by default.

5. for example ----> `class WagonR implements Car { ... }`

6) ⭐ Interfaces offer a cleaner design architecture by separating the definition of actions from their actual implementation.

7.

# Implementation Example: Fulfilling the Interface Contract

A concrete class must implement all the methods declared by the interface. It overrides the signatures to provide the operational rules for that specific object type.

### 📝 Source Code

```java
// Look, an interface is not a class, but what is written inside an interface is public abstract by default.
// Using an interface gives us a better structure when it comes to designing something.
// It is not a class; all it does is hold the functions and allows us to implement them in later stages
// inside a class using (class A implements interface-name)
interface Car {
    // I'm defining the functions here but implementing them later --->
    void drive();
    void safety();
}

class WagonR implements Car {
    @Override
    public void drive() {
        System.out.println("WagonR is driving");
    }

    @Override
    public void safety() {
        System.out.println("WagonR is safe");
    }
}

public class InterfaceImplement {
    public static void main(String[] args) {
        WagonR obj = new WagonR();
        obj.drive();
        obj.safety();
    }
}
```

---

### 3️⃣ Execution Output

When you compile and run the program above, it will yield the following result:

```text
WagonR is driving
WagonR is safe
```

4) ⭐ Concrete classes use the `implements` keyword to commit to an interface and must provide public definitions for all its methods.

6) ⭐ Failing to implement any interface method inside a concrete subclass results in a compilation failure.

# for further decode use the file VoyexaApp4.java

# Essential OOP Best Practices in Java

--> Adhering to proven architectural design patterns across Classes, Objects, Encapsulation, Inheritance, Polymorphism, and Abstraction ensures that your systems remain secure, flexible, and easy to maintain.

* **Data Integrity:** Keeping state fields well-defended prevents accidental corruption from outside layers.
* **Loose Coupling:** Programming toward abstract declarations rather than solid entities keeps modules clean and swap-friendly.

4) ⭐ Protecting object states with strict access limits prevents external components from corrupting application flow.

5. for example ----> `private int availableSeats;` instead of `public int availableSeats;`

6) ⭐ Favoring shared capabilities over rigid class families lowers system dependency and long-term code fragility.

7.

# Architectural Guidelines: Decoupling and Class Design

---

### 1. Encapsulation Best Practices (Data Protection)
* **Always Declare Fields as private:** This is the most fundamental rule of Encapsulation. Make all instance variables (`customerID`, `availableSeats`, etc.) private to hide the internal data representation from the outside world.
  * **Why?** It prevents external code from accidentally corrupting the object's state, improving security and reliability.
* **Use Public Getters and Setters Judiciously:** Provide public methods (getters and setters) for controlled access. Better yet, avoid setters if the state shouldn't change after creation, promoting **Immutability**.
  * **Example:** The `Flight` class uses a `bookSeats()` method instead of a simple `setAvailableSeats()` to enforce business logic (checking capacity) before modifying the state.

4) ⭐ Declare internal variables private and control manipulation using custom verification methods instead of naked setters.

6) ⭐ Design immutable fields where updates are prohibited after construction to establish safe, predictable data structures.

7.

---

### 2. Abstraction Best Practices (Contracts and Clarity)
* **Program to Interfaces, Not Implementations:** When declaring variables or method parameters, use the Interface type rather than the concrete class type.
  * **Example:** Use `List<String> myQueue = new ArrayList<>();` instead of `ArrayList<String> myQueue = new ArrayList<>();`. This makes your code flexible, allowing you to easily switch to `LinkedList` later without changing the surrounding logic.
* **Use Interfaces for Capabilities:** Define a contract using an Interface (`Bookable`, `Comparable`) for what an object can do, especially when unrelated classes need to share that capability.
* **Use Abstract Classes for Families:** Use an Abstract Class (`TravelItem`) when you need to provide a base implementation and shared state for a closely related hierarchy of classes.

4) ⭐ Code variables using interface definitions rather than concrete class initializations to allow seamless structural swaps.

6) ⭐ Assign separate interfaces for individual features and use abstract structures only for highly cohesive class lines.

7.

---

### 3. Inheritance and Polymorphism Best Practices (Hierarchy)
* **Prefer Composition Over Inheritance:** Avoid deep, complex inheritance hierarchies. Inheritance tightly couples the parent and child. If you only need to reuse code, **Composition** (where one class has an object of another class) is often a safer choice.
* **Use @Override Annotation:** Always use the `@Override` annotation when overriding a parent's method (as done in `BusinessFlight`).
  * **Why?** It tells the compiler you intend to override a method, catching errors if you accidentally misspell the method name or use the wrong parameter list.
* **Use the super() Keyword:** Always use `super()` in a subclass constructor to ensure the parent class's fields are correctly initialized before the child class's construction begins.

4) ⭐ Utilize composition strategies instead of multi-tiered inheritance networks to avoid brittle subclass interdependency.

6) ⭐ Attach the `@Override` compile check marker to prevent signature mistakes from executing as separate hidden operations.

7.

---

### 4. General Class Design (Code Quality)
* **Single Responsibility Principle (SRP):** Each class should have only one reason to change (one clear job).
  * **Example:** The `Flight` class only manages flight data and booking logic; it doesn't also handle user authentication.
* **Override equals() and hashCode() Together:** If you override `equals()` in a custom object (like our `Passenger` class), you must also override `hashCode()` to maintain the hash code contract. This is essential for objects used in hash-based collections (`HashSet`, `HashMap`).
* **Keep Classes Small:** Keep your classes focused and manageable. Large classes (often called "God Objects") violate SRP and are difficult to maintain.

4) ⭐ Isolate discrete business operations into independent classes so a single structural update changes exactly one unit.

6) ⭐ Override both `equals()` and `hashCode()` hooks uniformly to secure object integrity across dynamic search maps.

                                                                 ##DAY4

