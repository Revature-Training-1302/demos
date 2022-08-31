package org.example.QueueExamples;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<String> foods = new PriorityQueue<>();
        foods.add("pizza");
        foods.add("cereal");
        foods.add("brocoli");
        foods.add("milkshake");
        foods.add("sandwich");
        foods.add("pasta");
        foods.add("grapes");

        // notice, as we poll these elements, they're in alphabetically order
        // that's because of the priority queue
        // each element in stored in terms of their priority
        System.out.println(foods.poll());
        System.out.println(foods.poll());
        System.out.println(foods.poll());
        System.out.println(foods.poll());
        System.out.println(foods.poll());
        System.out.println(foods.poll());
        System.out.println(foods.poll());

        // Later on, we'll see how we define our own custom order
        Queue<Movie> movies = new PriorityQueue<>();
        Movie movie1 = new Movie(9, "Avengers", 2012);
        Movie movie2 = new Movie(10, "Jurassic Park", 1993);
        Movie movie3 = new Movie(10, "Isle of Dogs", 2018);
        Movie movie4 = new Movie(8, "Spider-Man", 2002);
        Movie movie5 = new Movie(100, "War of the Worlds", 2005);
        Movie movie6 = new Movie(1, "Gigli", 1999);
        Movie movie7 = new Movie(13, "I am Legend", 2007);
        Movie movie8 = new Movie(6, "World War Z", 2015);
        Movie movie9 = new Movie(8, "Spider-Man", 2012);
        Movie movie10 = new Movie(8, "Spider-Man", 2017);


        List<Movie> moviesList = Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10);

        // this method takes every element from the collection that we pass in and adds it to the queue:
        movies.addAll(moviesList);

        System.out.println("Using Comparable:");
        System.out.println(movies.poll());
        System.out.println(movies.poll());
        System.out.println(movies.poll());
        System.out.println(movies.poll());
        System.out.println(movies.poll());
        System.out.println(movies.poll());

        System.out.println("Using comparator:");
        // pass in our comparator, so it should order these by rating, rather than the default compareTo method
        Queue<Movie> moviesByRating = new PriorityQueue<>(new RatingCompare());
        moviesByRating.addAll(moviesList);

        System.out.println(moviesByRating.poll());
        System.out.println(moviesByRating.poll());
        System.out.println(moviesByRating.poll());
        System.out.println(moviesByRating.poll());
        System.out.println(moviesByRating.poll());
        System.out.println(moviesByRating.poll());
        System.out.println(moviesByRating.poll());

    }
}
