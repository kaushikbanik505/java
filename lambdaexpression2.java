import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface A {
    void show(String s);

}

@FunctionalInterface // for use more than one interface ..
interface B {
    void intiger(int i);
}

public class lambdaexpression2 {
    public static void main(String[] args) {
        A obj = (String str) -> {
            System.out.println(str);
        };// ; here is important for lenbda expression ;;
        obj.show("kaushik");
        B obj2 = (int intiger_value) -> {
            System.out.println(intiger_value);
        };

        obj2.intiger(8);
    }
}
