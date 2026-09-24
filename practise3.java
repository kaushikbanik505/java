// this is a practise 3 code written by me ----->

import java.util.Scanner;

class studentname {
    private String name;
    private int rollno;
    private int age;
    private String college_name;

    public studentname(String name, int rollno, int age, String college_name) {
        this.name = name;
        this.rollno = rollno;
        this.age = age;
        this.college_name = college_name;
    }

    public String getname() {
        return name;
    }

    public int getrollno() {
        return rollno;
    }

    public int getage() {
        return age;
    }

    public String getcollge_name() {
        return college_name;
    }

}

public class practise3 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        while (number > 0) {
            studentname s1 = new studentname("kaushik", 2, 24, "NIT-AGARTALA");
            System.out.println(s1.getname());
            System.out.println(s1.getrollno());
            System.out.println(s1.getage());
            System.out.println(s1.getcollge_name());
            number--;
        }

        System.out.println("ended of student1 info \n");
    }
}