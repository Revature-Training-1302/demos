package org.example.AbstractDefault;

// Rectangle is a shape:
public class Rectangle extends Shape {
    int length;
    int width;

    @Override
    public int getArea() {
        return length * width;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.width = 5;
        rectangle.length = 6;
        System.out.println(rectangle.getArea());
    }
}
