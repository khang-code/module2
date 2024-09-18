public class Student {
    private final int rollno;
    private final String name;
    private static String college = "BBDIT";
    Student(int r,String n) {
        rollno = r;
        name = n;
    }
    static void change() {
        college = "CODEGYM";
    }
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
