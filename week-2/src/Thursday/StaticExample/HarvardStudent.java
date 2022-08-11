package Thursday.StaticExample;

// For this example, we have a student class
// Assume all of these students go to the same school
// We can make a variable static if it applies to the entire class, rather than a particular instance:
public class HarvardStudent {
    // because each student has a different name, we want it to be non-static
    // that way each instance of the class can have its own value
    String student_name;
    // each student will have a different id, so non-static:
    int student_id;
    // because every student is going to the same school, we can keep this static so we don't waste memory
    static String student_school;
    // each student is going to have a different schedule:
    String schedule;
    // static, mascot will be same
    static String mascot;

    // introduce ourselves
    // because this method relies on a non-static variable
    // this is going to look different for every student:
    public void introduce() {
        System.out.println("My name is " + this.student_name);
    }

    // sing the school song:
    // static, because it is the same for every student:
    public static void sing_school_song() {
        System.out.println("We love Harvard");
    }
}
