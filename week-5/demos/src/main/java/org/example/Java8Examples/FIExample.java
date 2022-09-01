package org.example.Java8Examples;
// Declare a functional interface, an interface with one abstract method
@FunctionalInterface
interface Raise {
    // one single abstract method:
    int calculate(int x);
}


public class FIExample {

    public static void main(String[] args) {
        // Now that we've declared a functional interface, we create some lambda expressions and store them in the functional interface

        // declaring a lambda expression using the functional interface that we defined and storing it as a variable
        Raise square = (int x) -> x * x;
        Raise cube = (int x) -> x * x * x;
        // Make sure that the lambda expressions adhere to the method in the functional interface:
        // Raise print = (int x) -> "Hello";

        // how do we call these methods:
//        int x = square.calculate(5);
//        int y = cube.calculate((6));
//
//        System.out.println(x);
//        System.out.println(y);

        // passing these lambda expressions into the method
        applyFuncAndPrint(square, 5);
        applyFuncAndPrint(cube, 7);
    }

    // apply the given function to the value and then print it out:
    public static void applyFuncAndPrint(Raise r, int x) {
        int result = r.calculate(x);
        System.out.println("The result is : " + result);
    }



    // we could do the same thing down here by creating regular methods but the syntax is a bit
    // cleaner with lambda expressions
    public static int square(int x) {
        return x * x;
    }
    public static int cube(int x) {
        return x * x * x;
    }
}
