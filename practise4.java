// this code is just basic to find sum array element next up we will see upto "n" number sum
class ArrayPractise {
    private int[] arr = new int[5];
    private int sum = 0;

    // 1. Fixed: Removed 'int' return type so it is a proper constructor
    public ArrayPractise(int[] arr) {
        this.arr = arr; // Optionally store the passed array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
    }

    // Added a getter method to access the private sum variable safely
    public int getSum() {
        return sum;
    }
}

public class practise4 {
    public static void main(String[] args) {
        // 2. Fixed: Used 'new int[]{}' syntax
        // 3. Fixed: Added missing semicolon
        ArrayPractise obj = new ArrayPractise(new int[] { 1, 2, 3, 4, 5 });

        // 4. Fixed: Accessed sum through the object's public getter method
        System.out.println(obj.getSum());
    }
}
