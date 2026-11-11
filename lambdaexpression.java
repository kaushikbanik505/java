
interface A {
    void show();
}

public class lambdaexpression {
    public static void main(String[] args) {

        A obj = () -> // this -> is called the lambda expression
        {
            System.out.println("hello lambda expression");

        };

        obj.show();

    }
}
