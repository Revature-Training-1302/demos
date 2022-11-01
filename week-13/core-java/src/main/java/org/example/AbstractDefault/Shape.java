package org.example.AbstractDefault;

// if we declare a class as abstract, we should create at least one abstract method (but don't have to)
// can have both concrete and abstract method:
public abstract class Shape {
    public void print() {
        System.out.println("Hello");
    }

    // make an abstract class that will be filled in/implemented in our sub-classes
    // every shape should have some method to get the area:
    public abstract int getArea();

    public static void main(String[] args) {
        // cannot instantiate abstract classes:
//        Shape shape = new Shape();
    }

}
