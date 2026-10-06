// BUGGY LAB — BANK ACCOUNT EXCEPTION HANDLING

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg); // Bug 1: message not passed to superclass // resolved
    }
}

class BankAccount {
    private double balance;

    BankAccount(double amount) { // no return type for constructor
        balance = amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("insufficient funds "); // Bug 2: no message constructor used //
                                                                           // resolved
        else
            balance = balance - amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance); // Bug 3: executes even after
                                                                                    // exception // resolved ..
    }

    public void deposit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Negative deposit not allowed");
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }
}

public class ExceptionTestDebug {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);

        try {
            acc.deposit(-500); // Bug 4: runtime exception not handled properly // resolved

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        finally {
            System.out.println("Transaction complete.");
        }
        try {
            acc.withdraw(2000); // Bug 5: exception handled incorrect // resloved
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.");
        } // Bug 6: missing braces // resolved
    }
}