package com.revature.aop.aspect;

import com.revature.aop.service.CandyService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CandyAspect {
    @Autowired
    CandyService candyService;

    // Make sure we have candy in the database before we try executing our method
    // this will run before any method that's specified by the pointcut
    @Before("candy()")
    public void assertCandy() {
        Logger logger = LoggerFactory.getLogger(CandyService.class);
        logger.info("Checking if there is candy.");
        // if we don't have enough candy, fill out the repo with some starting values:
        if(candyService.getCandyCount() < 5) candyService.initRepo();
    }



    // Set up pointcut to match all methods in the candyService
    // We want the pointcut to ignore the getCandyCount and initRepo, otherwise we will get an infinite recursion:
    // We use boolean logic to accept all methos from candy service but not initRepo and also not getCandyCount
    @Pointcut("execution(* com.revature.aop.service.CandyService..*(..)) &&" +
    "! execution(* com.revature.aop.service.CandyService.initRepo(..)) && " +
    "! execution(* com.revature.aop.service.CandyService.getCandyCount(..))")
    private void candy() {
        // empty body:
    }
}
