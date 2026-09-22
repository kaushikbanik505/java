public class kaushik {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        System.out.println(a + b);
        System.out.println("--------------->");
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = i + 1;
            System.out.println(arr[i]);
        }
        System.out.println("--------------->");
        String str = "hello";
        String str2 = " world";
        System.out.println(str + str2 + " how are you");
        System.out.println("--------------->");

        String[] strarr = new String[5];

        for (int i = 0; i < 5; i++) {
            strarr[i] = "hello" + (i + 1);
            System.out.println(strarr[i]);
        }

        System.out.println("--------------->");

    }

}
