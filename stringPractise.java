// this code is to understand the special features of Strings that we can use in java programming language

public class stringPractise {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println(str1 == str2); // Output: true
        System.out.println(str3 == str2); // Output: false

        String original = "Java";
        System.out.println("Original String: " + original); // Output: Original String: Java
        String concatenated = original.concat(" Programming");
        System.out.println("Concatenated String: " + concatenated); // Output: Concatenated String: Java Programming
        System.out.println("Original String after concat: " + original); // Output: Original String after concat: Java

        // trim method

        String email = "   kauhsik@gmail.com";
        System.out.println("Email before trim: " + email); // Output: Email before trim:
        String trimmedEmail = email.trim();
        System.out.println("Email after trim: " + trimmedEmail); // Output: Email after

        // toUpperCase and toLowerCase methods

        String strr = "kauhsik";
        String uppercase = strr.toUpperCase();
        String lowercase = strr.toLowerCase();
        System.out.println(strr == uppercase);// false
        System.out.println(strr == lowercase);// true ;

        // replace --->

        String booking = "USA-5002-INDIA";
        String replacebooking = booking.replace("USA", "DUBAI");
        System.out.println("new one is " + replacebooking);

        // startsWith() and endsWith()

        String check = "BANIK-123-KAUHSIK";
        String check1 = check.startsWith("BANIK") ? "Yes, it starts with BANIK" : "No, it does not start with BANIK";
        String check2 = check.endsWith("KAUHSIK") ? "Yes, it ends with KAUHSIK" : "No, it does not end with KAUHSIK";
        String check3 = check.endsWith("123") ? "Yes, it ends with 123" : "No, it does not end with 123";
        System.out.println(check1);
        System.out.println(check2);
        System.out.println(check3);

        // isEmpty()

        String nully = "";
        if (nully.isEmpty()) {
            System.out.println("String is empty");
        }

        else {
            System.out.println("has character ");
        }

        // substring()

        String sub = "hello-world";
        String sub1 = sub.substring(0, 5);
        System.out.println("Substring: " + sub1);

        String sub2 = sub.substring(6);
        System.out.println("Substring: " + sub2);

        // contains();

        String obj = " i am going to shooping";
        if (obj.contains("going")) {
            System.out.println("Yes, it contains going");
        } else {
            System.out.println("No, it does not contain going");
        }
        // split()

        String flightDetails = "VXE101, New York, London";
        String[] details = flightDetails.split(", ");
        System.out.println("Flight Code: " + details[0]);
        System.out.println("Origin: " + details[1]);
        System.out.println("Destination: " + details[2]);

    }
}