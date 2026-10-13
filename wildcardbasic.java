import java.util.ArrayList;
import java.util.List;

class student {
    private String studentname;
    private Integer studentID;

    public student(String name, Integer id) {
        this.studentname = name;
        this.studentID = id;
    }

    // FIX: Override the toString method to control how the object prints
    @Override
    public String toString() {
        return "Student Name: " + studentname + ", ID: " + studentID;
    }
}

class employee {
    private String employeename;
    private Integer employeeID;

    public employee(String name, Integer id) {
        this.employeename = name;
        this.employeeID = id;
    }

    @Override
    public String toString() {
        return "employee Name: " + employeename + ", ID: " + employeeID;
    }
}

public class wildcardbasic {
    public static void printlist(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + "/n");
        }
    }

    public static void main(String args[]) {
        student s1 = new student("keya", 15);
        student s2 = new student("Argha", 6);
        employee e1 = new employee("santosh banik", 65);

        List<student> list = new ArrayList<>();
        List<employee> list1 = new ArrayList<>();

        list.add(s1);
        list.add(s2);
        list1.add(e1);

        System.out.println(list);
        System.out.println(list1);

        printlist(list);
        printlist(list1);

    }
}