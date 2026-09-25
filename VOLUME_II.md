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
