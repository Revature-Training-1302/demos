package Tuesday.Inheritance;

public class Main {
    public static void main(String[] args) {
        // ANIMALS:

        Animal shark = new Animal(5000, 2, 0, "Heptranchias perlo", "Gurgle", false);
        Animal lion = new Animal(420, 2, 4, "Panthera leo", "ROAR", true);

        // we can make an empty animal and "fill it in" later
        Animal eagle = new Animal();

        shark.speak();
        lion.speak();

        // speak with the species name included
        shark.speak_specific();
        lion.speak_specific();

        // MAMMALS:

        Mammal rabbit = new Mammal();
        System.out.println(rabbit.species);

        // override the constructor:
        Mammal squirrel = new Mammal(1, 2, 2, "Sciurus carolinensis", "munch", 3);
        // because we overrode the speak method, it will use this new behavior
        squirrel.speak();
        // we didn't override the specific speak so it will use the parent (Animal) method
        squirrel.speak_specific();

        squirrel.mammal_only();

        // DOGS:
        Dog dog = new Dog("German Shepard", 42.4);
        System.out.println(dog.toString());

        // can't use this mammal-only method on an Animal object:
        // shark.mammal_only();

        // Challenge: Let the user make the animal using Scanner

    }
}
