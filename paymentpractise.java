interface mode

{
    void pay(int amount, String paymentMethod);

    void refund(int amount, String paymentMethod);

    void cancel(int amount, String paymentMethod);
}

class payment implements mode {

    private String paymentMethod;
    private int amount;

    public void pay(int amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        System.out.println("Payment of " + amount + " is successful.");

        if (amount < 0) {
            System.out.println("Invalid amount. Payment failed.");
        }

    }

    public void refund(int amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        if (amount < 0) {
            System.out.println("Invalid amount. Refund failed.");
        } else {
            System.out.println("Refund of " + amount + " is successful.");
        }
    }

    public void cancel(int amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        if (amount < 0) {
            System.out.println("Invalid amount. Cancel failed.");
        } else {
            System.out.println("Cancel of " + amount + " is successful.");
        }
    }

}

class paymentpractise {
    public static void main(String[] args) {
        payment payment1 = new payment();
        payment1.pay(100, "Credit Card");
        payment1.refund(-50, "Credit Card");
        payment1.cancel(30, "Credit Card");
    }
}
