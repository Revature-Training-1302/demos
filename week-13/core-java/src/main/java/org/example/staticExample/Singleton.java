package org.example.staticExample;

// Singleton Design Pattern is used to make sure we only have one shared value throughout our program
// https://www.youtube.com/watch?v=yTuwi--LFsM
public class Singleton {
    // if we make a private constructor, we limit the creation of this class
    // this necessary for Singleton because otherwise, we would be free to create many instances of this class
    private Singleton() {
        System.out.println("Singleton being created");
    }

    private static class SingletonHolder {
        // make a static instance of the Singleton (will only happen once)
        public static final Singleton instance = new Singleton();
    }

    // public method that returns the Singleton instance from our private static class
    public static Singleton getInstance() {
        // can access the inner class because this method belongs to the Singleton class
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        Singleton s = getInstance();
        Singleton s2 = getInstance();
        Singleton s3 = getInstance();
        Singleton s4 = getInstance();
        Singleton s5 = getInstance();
        Singleton s6 = getInstance();
    }
}

// We know we've achieve Singleton pattern
// when we set up a class that can retrieve the object but only creates it one time
