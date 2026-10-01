// we are learning a abstract method here ...-->

// for a abstract method (function ) to implement we need a abatract class .. 

abstract class car {
    public abstract void drive();// as i use the abstract key word here i can implement it later in another class

}

class wagonr extends car {
    public void drive() {
        System.out.println("wagonr is driving");
    }
}

public class abstractmethod {
    public static void main(String[] args) {
        wagonr obj = new wagonr();
        obj.drive();
    }
}
