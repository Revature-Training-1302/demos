package Thursday.Abstraction;

public class Main {
    public static void main(String[] args) {
        // We can't instantiate an abstract class:
//        Animal animal = new Animal();
//        animal.speak();

        Pig pig = new Pig();
        pig.speak();
        pig.sleep();

        Cow cow = new Cow();
        cow.speak();
        cow.sleep();

    }
}
