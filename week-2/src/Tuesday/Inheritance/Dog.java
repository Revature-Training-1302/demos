package Tuesday.Inheritance;

public class Dog extends Mammal{

    String breed;

    public Dog(String breed, double weight) {
        // call the Mammal constructor:
        // we know for all (or most) dogs, the following conditions will be true:
        super(weight, 2, 4, "Canis familiaris", "bark", 4);
        this.breed = breed;

    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", litterSize=" + litterSize +
                ", weight=" + weight +
                ", eyes=" + eyes +
                ", legs=" + legs +
                ", species='" + species + '\'' +
                ", sound='" + sound + '\'' +
                ", warmBlooded=" + warmBlooded +
                '}';
    }
}
