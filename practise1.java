class value {
    static int a;
    static int b;

}

class result extends value {
    static {
        a = 100;
        b = 200;
    }
}

public class practise1 extends result {
    public static void main(String[] args) {
        System.out.println(a + b);

    }
}
