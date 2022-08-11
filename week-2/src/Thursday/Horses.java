package Thursday;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Horses {

    public static void main(String args[]) {

        // TODO How can we make this faster?
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        // create an array to store all the values for now:
        // we can create an array to store our strengths
        int[] strengths = new int[N];
        for(int i = 0; i < N; i ++) {
            //System.out.println(strengths[i]);
        }
        for (int i = 0; i < N; i++) {
            // read in the individual strength values
            int p = in.nextInt();
            // update the array with this value that we read in from the scanner:
            strengths[i] = p;
            //System.out.println("i: " + i + ", p: " + p);
        }

        // initialize this value to be the highest possible strength
        int min = 10000000;

        // we use nested for loops to compare each value with each other
        for(int i = 0; i < N; i ++) {
            // could start i + 1:
            for(int j = 0; j < N; j ++) {
                // don't want to check the same horse against itself:
                // because we check the indexes here, rather than the values,
                // we could still have 2 horses with the same value
                if(i == j) {
                    // skip this iteration of the loop:
                    continue;
                }
                // get every combination of 2 values in this array:
                //System.out.println(strengths[i] + " " + strengths[j]);
                // we take the difference
                int difference = strengths[i] - strengths[j]; // 3 - 5 == -2
                difference = Math.abs(difference); // -2 -> 2
                //System.out.println(difference);
                // if our current difference is lower than the minimum, that means
                // we've found a new minimum:
                if (difference < min) {
                    System.out.println(min);
                    // update the minimum with the difference value:
                    min = difference;
                }
            }
        }
        System.out.println(min);


//
// 0 : 5
// 1 : 8
// 2 : 9
// 3
// 4











        // Scanner in = new Scanner(System.in);
        // int N = in.nextInt();
        // int[] strengths = new int [N];
        // for (int i = 0; i < N; i++) {
        //     strengths[i] = in.nextInt();
        // }
        // int min = 10000000;
        // Arrays.sort(strengths);
        // for(int i = 1; i < strengths.length; i ++) {
        //     int diff = strengths[i] - strengths[i-1];
        //     if( diff < min ) {
        //         min = diff;
        //     }
        // }

        // // Write an answer using System.out.println()
        // // To debug: System.err.println("Debug messages...");

        // System.out.println(min);
    }
}
