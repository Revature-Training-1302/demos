package Wednesday.Challenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String rev = reverse("Federer is the all time tennis champion");
        System.out.print(rev);
    }
    public static String reverse(String x) {
        char [] letters = new char [x.length()];
        int index = 0;
        for(int i = x.length() - 1; i >= 0; i--) {
            letters[index] = x.charAt(i);
            index++;
        }
        String reverse = "";
        for(int i = 0; i < x.length(); i++){
            reverse = reverse + letters[i];
        }
        return reverse;
    }
}
