package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassA {
    public static void main(String[] args) {
        // take in the class itself rather than a string
        Logger logger = LoggerFactory.getLogger(org.example.ClassA.class);
        logger.info("Hello from class A");

        try {
            int x  = 3 / 0;
        } catch (ArithmeticException e) {
            logger.error("Arithmetic exception occured!");
        }
    }
}
