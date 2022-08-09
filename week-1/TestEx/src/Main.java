
import com.sun.source.tree.WhileLoopTree;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // s variable represents our strin
        String s = in.nextLine();

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        int sum = 0;
        for(int i = 0; i < s.length(); i ++) {
            // System.out.println((int)s.charAt(i));
            // this will get the ascii value of each character
            int ascii = (int) s.charAt(i);
            // every iteration, we're adding the current value to the sum so we can keep track of the sum of all characters in the string
            sum += ascii;
            System.out.println("Ascii: " + ascii + ", Sum: " + sum);
        }

        // this is where we print out the answer
        // divide the sum by the length
        int average = sum/s.length();
        System.out.println( (int) average);


    }











    }

