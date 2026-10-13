import java.util.ArrayList;

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

}

public class generic_practise1 {
    public static void main(String args[]) {
        student s1 = new student("kauhsik", 77);
        student s2 = new student("saheli", 76);
        employee e1 = new employee("saheli", 12);

        // if if i want tocreate a arraylist for student and try to input data of
        // employee i will get a compile time error ..

        ArrayList<student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        // as soon as we try to add "e1" to the list we get a compile time error ;;

        // list.add(e1); //The method add(student) in the type ArrayList<student> is not
        // applicable for the arguments (employee)

        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}