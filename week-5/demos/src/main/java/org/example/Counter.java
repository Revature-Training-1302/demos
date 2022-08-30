package org.example;

public class Counter {
    private int value;

    // when we initialize the counter, we set the value to be 0
    public Counter() {
        this.value = 0;
    }

    public void increment() {
        this.value ++;
    }

    public void decrement() {
        this.value --;
    }

    public int getValue() {
        return value;
    }

    public void reset() {
        this.value = 0;
    }

    public void print(boolean flag) {
        if(flag) {
            System.out.println("Hello");
        }
        else {
            System.out.println("Goodbye");
        }
    }


}
