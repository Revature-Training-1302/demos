package org.example.staticExample;

// static keyword attaches variable to class instead of instances
// don't have to create an object to use that value/method
// shared by all instances, save memory
// if we want a value to be the same for all instances of the class
// ex: keep track of some sort of global counter
// ex: keeping track of school for students
public class Character {
    String name;

    // the name of the show will be the same:
    static String show = "Stranger Things";
    // current season of the show:
    static int season = 4;

    // static blocks get executed once, when the class is first loaded
    static {
        // usually, we initialize our static variables:
        show = show + " season " + season;
        System.out.println("Static block in character class");
    }

    public Character(String name) {
        this.name = name;
    }

    // non-static method
    public void greet() {
        System.out.println("Hi, my name is " + this.name);
        // can access the static variable from within a non-static method
        // we access that show variable through the class rather than an object or the "this" keyword
        System.out.println(Character.show);
    }

    // static method, only accesses static variables
    public static void whatShow() {
        System.out.println("I am from the show " + show);
        // can't reference non-static variable (name) from a static context (method)
//        System.out.println(this.name);
    }

}
