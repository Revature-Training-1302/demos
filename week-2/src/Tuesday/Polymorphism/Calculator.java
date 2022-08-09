package Tuesday.Polymorphism;

// this class is a "holder" for some methods that we would want to call
public class Calculator {

    // if we have a variable that is applicable to the class itself rather than the object, we can make it static
    // In other words, if there's no need to differentiate based on what object, we can make the variable static
    static String name = "Calculator";
    // since pi is the same for all calulators, we can make it static
    static final double pi = 3.14159;

    // some examples of overloading, where we have the same method name but different parameters
    // introduce static keyword

    public static int add(int a, int b) {
        return a + b;
    }

    // we can overload by changing the number of parameters:
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    // we can change the order of the types and they still count as 2 different methods:
    public static double add(int a, double b) {
        return a + b;
    }

    public static double add(double a, int b) {
        return a + b;
    }

    // pass in array of numbers:
    public static int add(int [] numbers) {

        // initiliaze our sum to be 0:
        int sum = 0;
        for(int i = 0; i < numbers.length; i ++) {
            // cumulatively add up the numbers in the array:
            sum += numbers[i];
        }
        // return sum of everything in the array:
        return sum;
    }

    public static double add(int a, long b, double c, float f, String s) {
        return a + b + c + f;
    }

    // static keyword means we associate this method with the class, rather than the object
    public static int multiply(int a, int b) {
        return a * b;
    }


}
