package org.example.finalExample;

public class Main {
    public static void main(String[] args) {
        // final keyword non-access modifier
        // non modifiable?
        // can't re-assign value of variables
        final int x = 5;
        // can't change the value
//        x = 3;

        final Pumpkin pumpkin = new Pumpkin();
        // cannot directly re-assign the pumpkin variable:
//        pumpkin = new Pumpkin();

        // we CAN change the fields of the final object
        pumpkin.weight = 10.0;
        pumpkin.color = "orange";
        pumpkin.species = "pepo";

        // because the genus field itself is final, we can't change it:
//        pumpkin.genus = "";

        // bottom line: if a variable is final, we can't directly reassign with "=" sign
    }
}
