// 1. Base class
class kaushik {
    static int a = 5;
    static int b = 6;
}

// 2. Middle class inherits from kaushik
class hello extends kaushik {
    static int[] arr = new int[5];
}

// 3. Final class inherits everything down the chain
public class practise extends hello {
    public static void main(String[] args) {
        System.out.println(a + b); // Works! Inherited from kaushik

        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i] + i); // Works! Inherited from hello
        }
    }
}
