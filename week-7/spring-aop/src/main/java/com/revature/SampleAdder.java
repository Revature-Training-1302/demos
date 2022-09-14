package com.revature;

// simple Java class, note how there's nothing "Springy" about this class
// no beans, no Spring annotations
public class SampleAdder {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double divide (int a, int b) {
        return a/b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
