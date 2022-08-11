package Thursday.WrapperExample;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // primitive
        int j = 1;
        // wrapper class:
        Integer i = 1;
        System.out.println(i);
        System.out.println(j);

        // we can call methods in a wrapper class:
        System.out.println(i.toString());

        // arrays are statically sized, we can't add values once we create it
        Double[] grades = {100.0,90.0,80.0};

        // To use a primitve in an ArrayList (or data structures)
        // we need to use the wrapper class

        ArrayList<Double> grades2 = new ArrayList<>(Arrays.asList(grades));
        grades2.add(75.6);
        grades2.add(80.6);
        grades2.add(45.6);
        grades2.add(31.6);

        System.out.println(grades);
        System.out.println(grades2.toString());

        for(int counter = 0; counter < grades2.size(); counter ++) {
            System.out.println(grades2.get(counter));
        }



    }
}
