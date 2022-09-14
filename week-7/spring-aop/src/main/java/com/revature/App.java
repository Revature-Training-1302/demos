package com.revature;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");

        SampleAdder adder = (SampleAdder) beanFactory.getBean("sampleAdder");

        // The first 2 methods should invoke the logging, they match the pointcut expression:
        adder.add(7,5);
        adder.subtract(10,6);
        adder.add(3,4,5);




        try {
            adder.divide(3,0);
        } catch (Exception e) {
            System.out.println("Exception happened");
        }

    }
}
