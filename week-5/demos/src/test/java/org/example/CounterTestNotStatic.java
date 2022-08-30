package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CounterTestNotStatic {
    // Make a counter field:
   Counter counter;

//    @BeforeAll
//    public static void setUp() {
//        // because out counter is static and being shared by all tests, the value isn't being reset every time
//        CounterTest.counter = new Counter();
//    }

    @BeforeEach
    public void init() {
        // reset the counter back to 0 before each test:
        counter = new Counter();
    }

    @Test
    public void testIncrement() {
        counter.increment();
        // the answer should be 1:
        // the assertEquals ensures that the 2 values match, otherwise, the test will fail:
        assertEquals(1, counter.getValue());
    }

    @Test
    public void testIncrementMultiple() {
        counter.increment();
        counter.increment();
        counter.increment();
        assertEquals(3, counter.getValue());
    }

    @Test
    public void testDecrement() {
        counter.decrement();
        assertEquals(-1, counter.getValue());
    }

    @Test
    public void testGetValue() {
        assertEquals(0, counter.getValue());
    }




}
