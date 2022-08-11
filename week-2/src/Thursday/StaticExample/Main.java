package Thursday.StaticExample;

public class Main {
    public static void main(String[] args) {
        HarvardStudent new_student = new HarvardStudent();
        // non-static fields are accessed by the object:
        new_student.student_name = "Rory";
        // when we set the static fields, we access it through the class:
        HarvardStudent.student_school = "Harvard";
        HarvardStudent.mascot = "Bird";
    }
}
