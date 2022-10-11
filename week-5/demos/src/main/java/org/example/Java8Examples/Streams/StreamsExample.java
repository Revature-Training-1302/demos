package org.example.Java8Examples.Streams;

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


        List<Person> people = new ArrayList<>();
        people.add(new Person("Harry Potter", "Gryffindor"));
        people.add(new Person("Ron Weasley", "Gryffindor"));
        people.add(new Person("Hermione Granger", "Gryffindor"));
        people.add(new Person("Penelope Clearwater", "Ravenclaw"));
        people.add(new Person("Luna Lovegood", "Ravenclaw"));
        people.add(new Person("Padma Patil", "Ravenclaw"));
        people.add(new Person("Cedric Diggory", "Hufflepuff"));
        people.add(new Person("Ernie Macmillan", "Hufflepuff"));
        people.add(new Person("Hannah Abbot", "Hufflepuff"));
        people.add(new Person("Draco Malfoy", "Slytherin"));
        people.add(new Person("Vincent Crabbe", "Slytherin"));
        people.add(new Person("Gregory Goyle", "Slytherin"));

        /* With Streams, we have intermediate operations
        * map - for each element in the collection, apply some function to it (ex: squaring a number)
        * filter - filter and keep only entries that satisfy a certain condition
        * sort - sort the collection by default ordering or we can specify a custom ordering
        * Similar to JS array methods
        *
        * Terminal operations, after intermediate operations:
        * forEach - for each of the elements do something to it (ex: printing the value)
        * collect - collect the results of the stream into a collection
        * reduce - reduce the stream to a single value (ex: count, sum, cumulative product)
         */

        // map the elements and then print out each result:
        people.stream().map(person -> person.name + " is in " + person.house).forEach(result -> {
            System.out.println(result);
        });

        // map the elements but store the results in a list:
        List<String> descriptions = people.stream().map(person -> person.name + " is in " + person.house).collect(Collectors.toList());
        System.out.println(descriptions);

        System.out.println();

        // if we don't specify anything in the sorted method, we use the default sorting
        // in this case, sort by name (that's what we defined in the Comparable:
        List<Person> sorted = people.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
        // define our own sorting using a lambda expression that takes in 2 parameters and returns an integer
        // Note: We can replace with Comparator.comparing to make syntax a bit cleaner:
        people.stream().sorted((p1, p2) -> p1.house.compareTo(p2.house)).forEach(result -> {
            System.out.println(result);
        });

        System.out.println();

        people.stream().filter(person -> person.house.equals("Gryffindor")).forEach(x -> {
            System.out.println(x);
        });

        // because the return type of the reduce is different than the type of our collection, we have to add the third argument
        // 0 -> starting value
        // lambda expression -> tells us what happens at each step, takes in the cumulative result as well as the current person, defining how we calculate
        // our result at each step. In this case, we just add 1 to the result because every person we get to in the list is 1 more for our count
        // Integer:compareTo -> we need this because count integer is different type than Person
        int countSlytherin = people.stream().filter(person -> person.house.equals("Slytherin")).reduce(0, (result, current) -> result + 1, Integer::compareTo);
        System.out.println(countSlytherin);

        String hufflepuffs = people.stream().filter(person -> person.house.equals("Hufflepuff")).reduce("", (result, current)-> result += current.name, String::concat);
        // cumulative String of all Hufflepuff names
        System.out.println(hufflepuffs);

        // For Practice:
        // Make a Collection of objects (custom objects) and apply each of the intermediate operations and each of the terminal operations on them





    }
}
