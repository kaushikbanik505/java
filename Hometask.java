// Phase 1: Foundation and Abstraction
// Start by defining the universal contract and the base blueprint for any customer in the system.

// 1A. Define the Contract (LoyaltyMember)
// Create the following Interface to define the required behavior for any customer participating in the loyalty system:

// LoyaltyMember:
// void earnPoints(double dollarsSpent): Defines how the customer earns points (must be implemented by all).
// boolean redeemPoints(int pointsToUse): Defines the rules for spending points.

import java.util.ArrayList;
import java.util.List;

interface loyaltymember {
    void earnPoints(double dollarsSpent);
    boolean redeemPoints(int pointsToUse);
}

// 1B. Create the Base Blueprint (Customer)
// Create the following Abstract Class that serves as the base for all customer
// types. It holds shared data and forces children to implement unique logic.

// Customer:
// Fields: private int customerId; private String name; protected int
// loyaltyPoints;
// Abstract Method: public abstract double getPointMultiplier(); (Forces unique
// multiplier logic)
// Concrete Method: public void displayStatus() (Prints shared info: ID, Name,
// Points)
// Note: Use the protected access modifier for loyaltyPoints so child classes
// can access and modify the total points directly, demonstrating another level
// of access control.

abstract class Customer {
    private int customerId;
    private String name;
    protected int loyaltyPoints;

    public abstract double getPointMultiplier();// written logic later ;;

    public Customer(int customerId, String name, int loyaltyPoints) {
        this.customerId = customerId;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public void displayStatus() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Loyalty Points: " + loyaltyPoints);
    }
}

// Phase 2: Inheritance and Specialization

// 2A. Implement the Basic Class (StandardCustomer)
// Create the standard implementation for a basic user.

// StandardCustomer extends Customer and implements LoyaltyMember.
// Constructor: Calls super() to initialize basic customer data.
// Multiplier Logic: Implement getPointMultiplier() to return a basic rate
// (e.g., 1.0).
// Earn Logic: Implement earnPoints() to apply the multiplier to the dollars
// spent.
// Redeem Logic: Implement redeemPoints() with basic rules (e.g., must have 1000
// points to redeem).

class StandardCustomer extends Customer implements loyaltymember {
    public StandardCustomer(int customerId, String name, int loyaltyPoints) {
        super(customerId, name, loyaltyPoints);
    }

    @Override
    public double getPointMultiplier() {
        return 1.0;
    }

    @Override
    public void earnPoints(double dollarsSpent) {
        loyaltyPoints += (int) (dollarsSpent * getPointMultiplier());
    }

    @Override
    public boolean redeemPoints(int pointsToUse) {
        if (loyaltyPoints >= pointsToUse) {
            loyaltyPoints -= pointsToUse;
            return true;
        }
        return false;
    }
}

// 2B. Implement the Specialized Class (EliteCustomer)
// Create the specialized implementation for a premium user.

// EliteCustomer extends Customer and implements LoyaltyMember.
// Constructor: Calls super().
// Multiplier Logic: Implement getPointMultiplier() to return a higher rate
// (e.g., 1.5).
// Redeem Logic: Implement redeemPoints() with more flexible rules (e.g., can
// redeem with only 500 points). Use the @Override annotation.

class EliteCustomer extends Customer implements loyaltymember {
    public EliteCustomer(int customerId, String name, int loyaltyPoints) {
        super(customerId, name, loyaltyPoints);
    }

    @Override
    public double getPointMultiplier() {
        return 1.5;
    }

    @Override
    public void earnPoints(double dollarsSpent) {
        loyaltyPoints += (int) (dollarsSpent * getPointMultiplier());
    }

    @Override
    public boolean redeemPoints(int pointsToUse) {
        if (loyaltyPoints >= pointsToUse) {
            loyaltyPoints -= pointsToUse;
            return true;
        }
        return false;
    }
}

// application logic

class Hometask {
    public static void main(String args[]) {
        List<loyaltymember> members = new ArrayList<>();
        members.add(new StandardCustomer(101, "Jane Smith", 0));
        members.add(new EliteCustomer(102, "Tom Davis", 0));
        for (loyaltymember member : members) {
            member.earnPoints(100.00); // Same call, different results
            ((Customer) member).displayStatus(); // Downcast to access the abstract parent method
        }

    }
}