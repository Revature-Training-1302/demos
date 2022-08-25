package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // because i is defined within this block scope, we can redefine it in a different block scope
        for(int i = 0; i < 10; i ++) {

        }
        for(int i = 0; i < 10; i ++) {

        }

        // we can't print out i, it wasn't defined in this scope:
//        System.out.println(i);

        int i = 0;
        for(; i < 10; i ++) {

        }
        System.out.println(i);

        Apple apple = new Apple(20, "green", "granny smith");
        // values for the individual apple:
        System.out.println(apple.weight);
        System.out.println(apple.color);
        System.out.println(apple.type);
        // this is a static value, we can still access it from the object scope
        System.out.println(apple.orchard);
        // but we can also and should access it from the class scope:
        System.out.println(Apple.orchard);

        // we can't access object scoped variables from the class:
        // System.out.println(Apple.weight);

    }
}
