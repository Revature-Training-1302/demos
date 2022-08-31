package org.example.StringBB;

public class Main {
    public static void main(String[] args) {
        StringBuilder alphabet = new StringBuilder("abcdmnop");

        System.out.println(alphabet);
        // because string builder is mutable, we can reverse it and that change will be reflected when we print it out:
        alphabet.reverse();
        System.out.println(alphabet);
        alphabet.reverse();
        alphabet.insert(4, "efghijkl");
        System.out.println(alphabet);
        alphabet.append("qrstuvqxyz");
        System.out.println(alphabet);
        alphabet.replace(0,13, "ABCDEFGHIJKLM");
        System.out.println(alphabet);


    }
}
