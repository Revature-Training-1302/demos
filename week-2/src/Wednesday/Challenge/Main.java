package Wednesday.Challenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String FIRST = in.nextLine();
        String SECOND = in.nextLine();
        String answer = "";

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        for(int i = 0; i < FIRST.length(); i++){
            answer += FIRST.charAt(i);
            System.out.println(answer);
        }

        for(int i = answer.length(); i < SECOND.length(); i++){
            answer += SECOND.charAt((i));
            System.out.println(answer);
        }

        System.out.println("answer: " + answer);



    }
}
