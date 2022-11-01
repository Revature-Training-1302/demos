package org.example.staticExample;

// can't make outer classes static
public class OuterClass {
    private static String str = "Happy Halloween";

    // nested classes can be static
    static class NestedClass {
        // we can access static strings from the outer class in this nested class
        public void display() {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        // creating an instance of the inner class
        OuterClass.NestedClass obj = new OuterClass.NestedClass();
        // this will print out the static field of the outer class:
        obj.display();
    }
}
