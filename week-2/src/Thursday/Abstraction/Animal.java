package Thursday.Abstraction;

// Without this abstract key-word, we can't make any abstract methods in the class:
public abstract class Animal  {

    // this is an abstract method, we only declare it but don't fill out the body
    // promise that we are going to fulfill this method in a sub-class
    public abstract void speak() ;

    public abstract void speak(String message);

    abstract int getLegs();

    // an abstract class can have a concrete method (has a body)
    public void sleep() {
        System.out.println("ZZZ");
    }


}
