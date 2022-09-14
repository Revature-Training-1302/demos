package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class is an aspect
// a representation of some sort of concern (logging) that cuts across multiple classes
public class AdderAfterReturnAspect {
    // set up a logger to use:
    private Logger logger = LoggerFactory.getLogger(AdderAfterReturnAspect.class);

    // set up a method to use the logger:
    public void afterReturn(Object returnValue) {
        // log the return value of whatever method was called
        logger.info("Value returned is {}", returnValue);
    }


    public void afterThrow(Object exception) {
        Exception e = (Exception) exception;
        e.printStackTrace();
        // log the return value of whatever method was called
        logger.warn("Error happened {}", exception);
    }
}
