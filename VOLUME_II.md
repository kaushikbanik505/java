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
    
