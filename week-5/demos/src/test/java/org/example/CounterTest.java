package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class CounterTest {
    // Make a counter field:
    static Counter counter;

    @BeforeAll
    public static void setUp() {
        // because out counter is static and being shared by all tests, the value isn't being reset every time
        CounterTest.counter = new Counter();
    }

    @BeforeEach
    public void init() {
        // reset the counter back to 0 before each test:
        CounterTest.counter.reset();
    }

    @AfterAll
    public static void cleanUp() {
        System.out.println("This should run after all of the tests");
    }

    @AfterEach
    public void endTest() {
        System.out.println("This should run after each test.");
    }

    @Test
    public void testIncrement() {
        CounterTest.counter.increment();
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

    @Test
    public void assertTests() {
//        String animal1 = "cat";
//        String animal2 = "dog";
//        assertFalse(animal1.equals(animal2));
//        assertTrue(animal1.equals(animal1));

        int numbers[] = {1,2,3};
        int numbers2[] = {1,2,3};
        assertArrayEquals(numbers, numbers2);
    }

    @Test
    public void testPrint() {
        counter.print(true);
    }




}
