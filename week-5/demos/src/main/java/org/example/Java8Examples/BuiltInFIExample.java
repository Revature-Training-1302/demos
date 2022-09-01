package org.example.Java8Examples;

// importing everything from the function package:
import java.util.Random;
import java.util.function.*;

public class BuiltInFIExample {
    public static void main(String[] args) {
        // consumerExample();
        // predicateExample();
//        functionExample();
        supplierExample();
    }

    // separate the functional interface demos into different methods
    public static void consumerExample() {
        // set up a consumer that takes in a single string and prints that string 10 times
        Consumer<String> printABunch = (value) -> {
            for(int i = 0; i < 10; i ++) {
                System.out.println(value);
            }
        }; // end with a semicolon

        // BiConsumer takes in 2 values and still doesn't return anything:
        BiConsumer<String, Integer> printABunch2 = (value, times) -> {
            for(int i = 0; i < times; i ++) {
                System.out.println(value);
            }
        }; // end with a semicolon

        // accept method to call these:
        printABunch.accept("Hello World");
        printABunch2.accept("Hello World 2", 5);
    }

    // predicates take in a single value and return a boolean
    public static void predicateExample() {
        // because we're just returning a single value, we just put the expression and it knows to just return that value:
        Predicate<Integer> isEven = (value) -> (value % 2 == 0);
        // take the sum of 2 values and return whether the sum is even:
        BiPredicate<Integer, Integer> isEven2 = (value1, value2) -> ((value1 + value2) % 2 == 0);
        BiPredicate<Integer, Integer> isDivisible = (value1, value2) -> (value1 % value2 == 0);

        System.out.println(isEven.test(5)); // false
        System.out.println(isEven.test(6)); // true
        System.out.println(isEven2.test(4,5)); // false
        System.out.println(isDivisible.test(20,5)); // true
        System.out.println(isDivisible.test(20,6)); // false
    }

    // functions take in a single value and return a value
    public static void functionExample() {
        // take in a name and return a greeting
        Function<String, String> greet = (name) -> "Hello " + name;
        // takes in 2 names and returns a greeting to both
        //        param1   param2  return value
        BiFunction<String, String, String> greet2 = (name1, name2) -> "Hello " + name1 + " and " + name2;

        System.out.println(greet.apply("Rory"));
        System.out.println(greet2.apply("Mario", "Luigi"));
    }

    // suppliers don't take in any parameters, just return something
    public static void supplierExample() {
        Supplier<Integer> random = () -> {
            Random generator = new Random();
            // return a random value between 0 and 99 (100 - 1)
            return generator.nextInt(100);
        };

        for(int i = 0; i < 10; i ++) {
            // the get method executes the expression:
            System.out.println(random.get());
        }
    }
}
