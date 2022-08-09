package Tuesday.Inheritance;

// the most generic class of the inheritance demo today
// everything in this class must be applicable to the other classes
public class Animal {
    double weight;
    int eyes;
    int legs;

    String species;
    String sound;

    public Animal(double weight, int eyes, int legs, String species, String sound) {
        this.weight = weight;
        this.eyes = eyes;
        this.legs = legs;
        this.species = species;
        this.sound = sound;
    }

    // empty constructor:
    public Animal() {

    }

    // method
    public void speak() {
        // using our member variable:
        System.out.println("The animal says: " + this.sound);
    }

    public void speak_specific() {
        System.out.println("The " + this.species + " says " + this.sound);
    }



}
