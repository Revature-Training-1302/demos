package org.example;

public class Apple {
    // we can keep some variables non-static (object scope)
    double weight;
    String color;
    String type;

    static String default_color = "red";

    // We can make the orchard static because every apple is from the same orchard (class scope)
    // otherwise, every time we made a new apple, we would be wasting space by re-initializing this memory
    static String orchard = "Rory's Apples";

    public Apple() {
        // Even if we taje the value from the static variable, we still need to store it as a non-static variable:
        this.color = default_color;
    }


    public Apple(double weight, String color, String type) {
        this.weight = weight;
        this.color = color;
        this.type = type;
    }
}
