package Thursday.Abstraction;

// Pig is a concrete class, not abstract and we extend the abstract Animal class:
public class Pig extends Animal{
    // we're going to get yelled at if we don't fill out te abstract methods from the animal class

    // fulfilling the abstract method and doing the implementation:
    @Override
    public void speak() {
        System.out.println("Oink!");
    }


    public void speak(String message) {

    }

    @Override
    public int getLegs() {
        return 4;
    }

}
