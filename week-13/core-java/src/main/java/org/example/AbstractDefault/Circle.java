package org.example.AbstractDefault;

public class Circle extends Shape{
    int r;

    @Override
    public int getArea() {
        return (int) Math.PI * r * r;
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.r = 5;
        System.out.println(circle.getArea());
    }
}
