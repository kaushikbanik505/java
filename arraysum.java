
/// this code is done by mee 😊😊😊😊😊😊😊
import java.util.Scanner;

class sum {
    private int n;
    private int[] arr;
    private int sumz = 0;

    public sum(int[] inputarr) {
        this.arr = inputarr;
        this.n = inputarr.length;

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
            sumz += arr[i];
        }

    }

    public int getsum() {
        return sumz;
    }
}

public class arraysum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        sum s = new sum(arr);
        System.out.println(s.getsum());
    }
}
