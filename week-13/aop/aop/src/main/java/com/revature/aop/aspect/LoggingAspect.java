package com.revature.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// lets Spring detect this class as a bean:
//@Component
// an aspect is a concern that cuts across multiple classes
@Aspect
public class LoggingAspect {

    private Logger logger;

    // When we set up advice, we use the pointcut defined below:
    @Around("everything()")
    // this parameter represents the join point (execution of a method)
    public Object log(ProceedingJoinPoint pjp) {
        // when we set up a logger, we pass in the class:
        // pass in whatever class called this method:
        this.logger = LoggerFactory.getLogger(pjp.getTarget().getClass());

        // log some information about this method:
        logger.info("Method signature: " + pjp.getSignature());
        logger.info("Arguments: " + Arrays.toString(pjp.getArgs()));

        Object obj = null;
        // have to manually make sure the method is called:
        try {
            // proceed with the method:
            // get the returned value:
            obj = pjp.proceed();
        } catch(Throwable e) {
            logger.error(e.getMessage());
        }
        // log the return value of this method call:
        logger.info("Return value: " + obj);
        // return the object if successful
        return obj;
    }



    // which classes/methods are we going to apply this aspect to:
    // This is a very broad pointcut, accepting all return types, all classes/methods in the package com.revature.aop
    // and all parameter types
    @Pointcut("execution(* com.revature.aop..*(..))")
    private void everything() {
        // Leave the body blank because the important part here is the annotation
    }
}
