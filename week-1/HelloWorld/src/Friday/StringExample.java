package Friday;
import java.util.Scanner;

public class StringExample {
    public static void main(String [] args) {
        System.out.println("String example");

        // this notation is similar to primitives
        // 1. We don't use the new keyword
        // 2. We don't use a constructor
        String name = "rory";
        int a = 4;

        // Normally, when we instantiate a class, it looks like this:
        Scanner scanner = new Scanner(System.in);

        // We can create strings using the new keyword
        String food = new String("pizza");

        // These 2 strings are in the string pool
        // Only one instance of the "spiderman" string exists in memory
        // Both of these variables point to that instance
        String superhero1 = "spiderman";
        String superhero2 = "spiderman";
        // Because we use the "new" keyword, the string is going to be outside of the String pool, which means the reference will be different
        String superhero3 = new String("spiderman");

        // If we remember, == checks reference while .equals checks the value:
        System.out.println("superhero1.equals(superhero2): " + superhero1.equals(superhero2));
        System.out.println("superhero1.equals(superhero3): " + superhero1.equals(superhero3));

        // If we check the reference:
        System.out.println("superhero1 == superhero2: " + (superhero1 == superhero2));
        // different reference here
        System.out.println("superhero1 == superhero3: " + (superhero1 == superhero3));

        // Different String methods
        //                  012345
        String superhero = "batman";
        String superhero_spelled_wrong = "batmam";
        System.out.println("char at 3: " + superhero.charAt(3));
        System.out.println("superhero compared to spelled wrong: " + superhero.compareTo(superhero_spelled_wrong));
        System.out.println("spelled wrong compared to superhero: " + superhero_spelled_wrong.compareTo(superhero));
        System.out.println("compare to self: " + superhero.compareTo(superhero));

        String villain = "Joker";
        System.out.println("Length of Joker: " + villain.length());

        String sentence = "Batman is fighting joker";
        // split up the string based on spaces
        String[] words = sentence.split("t");
        // for each loop, print out everything in an array
        for(String word: words) {
            System.out.println(word);
            // does not affect
            word = "new word";
        }

        for(int i = 0; i < words.length; i ++) {
            // manually add back the letter
            words[i] = words[i] + "t";
        }

        for(String word: words) {
            System.out.println(word);
        }

        String fruit = " \t apple         \n";
        System.out.println(fruit);
        // trim get rid of white spaces (newlines, spaces, tabs)
        System.out.println(fruit.trim());




    }
}
