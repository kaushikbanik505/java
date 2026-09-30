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

## DAY -- 4

# OOP Pillars: Code Reusability and Polymorphism

--> Polymorphism allows the **reuse of code blocks** seamlessly. By writing generic code tailored to a parent class, you can instantly make it work with any present or future child classes without rewriting any logic.

1. Polymorphism means **"many forms"**, allowing one reference variable to take different shapes.

2. **Upcasting in Action:** We declare a variable using the parent class type but instantiate it using a child class type.

4) <span style="color:#268bd2">⭐ Java handles method calls dynamically based on the actual object type, not the reference type.</span>

5. for example ----> `Animal myDog = new Dog();`

6) <span style="color:#859900">⭐ The ultimate superpower of polymorphism is write-once, run-anywhere flexibility for custom class families.</span>

7. 

# Implementation Example: VoyexaApp.java

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
