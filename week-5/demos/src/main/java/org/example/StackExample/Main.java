package org.example.StackExample;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> pancakes = new Stack<>();

        pancakes.push("pancake1");
        pancakes.push("pancake2");
        pancakes.push("pancake3");
        pancakes.push("pancake4");
        pancakes.push("pancake5");
        pancakes.push("pancake6");

        // pop removes and returns the top of the stack
        System.out.println("Removing " + pancakes.pop());
        System.out.println("Removing " + pancakes.pop());
        // peek just takes a look at the top value
        System.out.println("Looking at " + pancakes.peek());

        System.out.println(pancakes.search("pancake1")); // position 4
        System.out.println(pancakes.search("pancake2")); // position 3
        System.out.println(pancakes.search("pancake3")); // position 2
        System.out.println(pancakes.search("pancake4")); // position 1

        // while there are still pancakes in the stack
        while(!pancakes.isEmpty()) {
            System.out.println("Removing " + pancakes.pop());
        }

        System.out.println("Stack is empty");
    }
}
