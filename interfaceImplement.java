// look interface is not a class ,, but what written in side interface is a
// public abstract by default ..
// using interface giving us better structure when its comes to design something
// ,,it is not a class all it did just hold the fucntions and allows us to
// implemt it in later stages inside a class using   (class A impliments interface-name )

interface car {
    // im define the function here but impliment them later --->
    void drive();

    void safety();
}

class wagonr implements car {
    public void drive() {
        System.out.println("wagonr is driving");
    }

    public void safety() {
        System.out.println("wagonr is safe");
    }
}

public class interfaceImplement {
    public static void main(String[] args) {
        wagonr obj = new wagonr();
        obj.drive();
        obj.safety();
    }
}