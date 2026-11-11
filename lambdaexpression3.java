interface A {
    int add(int i, int j);
}

public class lambdaexpression3 {
    static public void main(String args[]) {

        A obj = (i, j) -> i + j; // return type

        // or
        // A obj = (i, j) ->
        // {
        // return (i+j);
        // }

        int result = obj.add(10, 21);
        System.out.println(result);
    }
}
