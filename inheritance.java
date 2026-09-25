// Parent Class
class Parent {
    // Parent Constructor
    public Parent() {
        System.out.println("Parent constructor called!");
    }
}

// Child Class
class Child extends Parent {
    // Child Constructor
    public Child() {
        super(); // Explicitly calling the parent's constructor
        System.out.println("Child constructor called!");
    }
}

// Main execution class to run the code
public class inheritance {
    public static void main(String[] args) {
        Child obj = new Child(); // Creating a child object
    }
}
