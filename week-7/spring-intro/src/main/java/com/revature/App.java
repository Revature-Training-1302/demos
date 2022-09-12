package com.revature;

import com.revature.entity.HelloWorld;
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
        // this is how setter-based injection works:
        // first create an empty object
        HelloWorld helloWorld = new HelloWorld();
        // Then use setters to populate the values
        helloWorld.setMessage("Hello");

        // Start using the Bean Factory to create beans:
        BeanFactory factoryXML = new ClassPathXmlApplicationContext("beans.xml");
        // We ue the factory to create some beans:
        HelloWorld helloWorld1 = (HelloWorld) factoryXML.getBean("helloWorld");
        System.out.println(helloWorld1.getMessage());
        // can only get bean by class if we only have a single bean of that class:
        HelloWorld helloWorld2 = factoryXML.getBean(com.revature.entity.HelloWorld.class);
        System.out.println(helloWorld2.getMessage());
    }
}
