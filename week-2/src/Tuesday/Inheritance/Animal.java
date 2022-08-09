package Tuesday.Inheritance;

// the most generic class of the inheritance demo today
// everything in this class must be applicable to the other classes
public class Animal {
    double weight;
    int eyes;
    int legs;

    String species;
    String sound;

    boolean warmBlooded;

    public Animal(double weight, int eyes, int legs, String species, String sound, boolean warmBlooded) {

        this.weight = weight;
        this.eyes = eyes;
        this.legs = legs;
        this.species = species;
        this.sound = sound;
        this.warmBlooded = warmBlooded;
    }

    // empty constructor:
    public Animal() {
        this.species = "undefined";
    }

    // method
    public void speak() {
        // using our member variable:
        System.out.println("The animal says: " + this.sound);
    }

    public void speak(String message) {
        System.out.println(message);
    }

    public void speak_specific() {
        System.out.println("The " + this.species + " says " + this.sound);
    }



}
