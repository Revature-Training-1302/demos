package org.example.Java8Examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(2);
        numbers.add(5);
        numbers.add(7);
        numbers.add(3);
        numbers.add(8);
        numbers.add(12);
        numbers.add(72);
        numbers.add(8);

        // Operations
        // Map and Collect
        // specify what's happening in the map using a lambda expression
        List<Integer> squares = numbers.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println("Squared numbers: " + squares);

        // Sort and Collect:
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);

        // we can assign the result of the stream back to the original variable:
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(numbers);

        // Filter and collect:
        List<Integer> evenNumbers = numbers.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // forEach
        numbers.stream().forEach(x -> System.out.println("x: " + x));

        // taking a collection and reducing it to a single value:
        int sumEven = numbers.stream().filter(x -> x %2 == 0).reduce(0, (ans, current) -> ans + current);
        System.out.println(sumEven);


        // taking a collection and reducing it to a single value:
        int numEven = numbers.stream().filter(x -> x %2 == 0).reduce(0, (ans, current) -> ans + 1); //Bi-Function, takes in 2 values, returns single value
        System.out.println(numEven);
        System.out.println(evenNumbers.size());

        // taking a collection and reducing it to a single value:        start     result, current    applying some function
        int productEven = numbers.stream().filter(x -> x %2 == 0).reduce(1, (result, current) -> result * current); //Bi-Function, takes in 2 values, returns single value
        System.out.println(productEven);
    }
}
