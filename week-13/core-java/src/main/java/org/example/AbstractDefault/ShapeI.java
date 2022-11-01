package org.example.AbstractDefault;

// interfaces are better for behavior, since we can't store states/variables
public interface ShapeI {
    // interfaces can only have abstract methods (at least until Java 8)
    public int getArea();

    // can have default methods as of java 8
    public default int getPerimeter() {
        return 34;
    }


    // can also have static methods in our interface, as of Java 8
    static void print() {
        System.out.println("Hello");
    }
}
