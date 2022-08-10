package Wednesday.FinalExample;

import Wednesday.FinalExample.Mammal;

public class Main {
    public static void main(String[] args) {
        final double pi = 3.1415;
        // we can't reassign a value of pi:
        // pi = 4;

        final Mammal dog = new Mammal("Scooby Doo", 4, "Furry");
        // we can change the name using the public setter
        // Even if if an object is final, we can still "change" it by altering its fields
        dog.setName("Scrappy Doo");
        // We cannot reassign it if it's final
        // dog = new Mammal("Blue", 4, "Furry");

        dog.speak();
    }
}
