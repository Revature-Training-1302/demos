package org.example;

import java.util.Scanner;

// X input number
// N number of categories
// next N lines
// F, T, category
// Take the number X and see which of the bounds it fits into (F is the lower bound and T is the upper bound) and print out whatever cateory it belongs to
public class CodingChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            // lower bound
            int F = in.nextInt();
            // upper bound:
            int T = in.nextInt();
            // category:
            String category = in.next();
            // solution:
            if(X >= F && X <= T) System.out.println(category);
        }
    }
}
