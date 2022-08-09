package Tuesday.Inheritance;

// if we want to inherit, we use the "extends" keyword in Java
// Nothing we do here will change the Animal class
public class Mammal extends Animal{

    // attribute that all mammals but not animals
    int litterSize;

    public Mammal(double weight, int eyes, int legs, String species, String sound, int litterSize) {
        // calls the super's (Animal) constructor, pass in true for warm-blooded because that is a guarantee for mammal:
        super(weight, eyes, legs, species, sound, true);
        // extending the functionality of the inherited class
        this.litterSize = litterSize;
    }

    public Mammal() {
        // call the default super constructor:
        super();
    }

    // we're taking the functionality of the parent method and changing it to fit out child's needs:
    @Override
    public void speak() {
        // run the parent version of the speak method
        super.speak();
        // We know that this is a mammal, so we can be more specific with the output:
        System.out.println("The mammal says: " + this.sound);
    }

    @Override
    public void speak(String message) {
        System.out.println(message);
    }

    // Extending the functionality by adding a method (Animals won't have access to this method)
    public void mammal_only() {
        System.out.println("This method only applies mammals");
        System.out.println(super.eyes);
    }


}
