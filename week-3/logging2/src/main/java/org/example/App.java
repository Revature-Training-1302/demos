package org.example;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // create the logger using the logger factory and pass in the class that this logger is used for:
        Logger logger = LoggerFactory.getLogger("org.example.App");

        // we can log different values:
        logger.trace("Something happened");
        logger.debug("Hello World.");
        logger.info("Give some information about the program.");
        logger.error("Something bad happened!");
        logger.warn("Something might happen that's bad.");
        logger.trace("Trace test\n");


        System.out.println("message");
    }
}
