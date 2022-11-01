package org.example.staticExample;

public class Main {
    // can't access this in main:
    int x;

    // main method is static because it is starting point of our program
    // we don't have to create an instance of the class to call it
    public static void main(String[] args) {
        Character character1 = new Character("Steve");
        Character character2 = new Character("Mike");
        Character character3 = new Character("Eleven");
        Character character4 = new Character("Max");
        Character character5 = new Character("Hopper");
        // call our instance method:
        character1.greet();
        // call our static method:
        Character.whatShow();
//        System.out.println(x);


    }
}
