package org.example.QueueExamples;

import java.util.*;

// to provide a compareTo method, we need to implement the Comparable interface
public class Movie implements Comparable<Movie>{
    private int rating;
    private String name;
    private int year;

    public Movie(int rating, String name, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public Movie() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    // compare to takes in one object and compare it to "this"
    @Override
    public int compareTo(Movie other) {
        // lets say we want to define a movie as being "less than" another if its name is alphabetically smaller
        // first we compare the strings using the compare to method
        int nameCompare = this.name.compareTo(other.getName());
        // if the names are the same
        if(nameCompare == 0) {
            // if this.year is bigger, will return positive
            // if the 2 years are the same return 0
            // if the other year is greater, we will return negative
            int yearCompare = this.year - other.getYear();
            return yearCompare;
        }else {
            return nameCompare;
        }
    }

    public static void main(String[] args) {
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

        List<Movie> movies = Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10);
        System.out.println(movies);
        // Collections.sort method sort the members of the list
        Collections.sort(movies);
        System.out.println(movies);

        // we can sort a list based on a comparator by passing in an instance of the comparator as the second argument:
        // if we pass in a comparator, we ignore the default compareTo method and just use the compare method from the Comparator
        Collections.sort(movies, new RatingCompare());
        System.out.println(movies);




    }
}

