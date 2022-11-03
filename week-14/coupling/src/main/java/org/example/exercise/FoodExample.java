package org.example.exercise;

/*
For this exercise, take this tightly coupled spaghetti code and refactor to
be more loosely coupled. The end goal should be that you can make a meal of any food types
without having to change the code in the Meal class
 */
public class FoodExample {
    public static void main(String[] args) {
        Meal meal = new Meal();
        meal.serve();
    }
}

class Meal {
    Spaghetti spaghetti;

    public Meal() {
        spaghetti = new Spaghetti();
    }
    public void serve() {
        spaghetti.describe();
    }
}

class Spaghetti {
    public void describe() {
        System.out.println("Tastes good with red sauce and parmesan");
    }
}