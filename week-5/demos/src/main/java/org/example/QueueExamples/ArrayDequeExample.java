package org.example.QueueExamples;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Deque<String> names = new ArrayDeque();

        names.addLast("Sam");
        names.addLast("Loving");

        System.out.println(names);

        System.out.println("Now helping " + names.pollFirst());
        System.out.println("Now helping " + names.pollFirst());

        names.addLast("Iulia");

        // add to the front of the deque, they will be printed out when we peek
        names.addFirst("Cutting the line");

        // look at the first value of the deque but don't remove it:
        System.out.println(names.peek());
        System.out.println(names.peekLast());
        System.out.println(names);
    }
}
