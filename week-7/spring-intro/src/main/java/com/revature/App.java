package com.revature;

import com.revature.entity.*;
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
//        HelloWorld helloWorld2 = factoryXML.getBean(com.revature.entity.HelloWorld.class);
//        System.out.println(helloWorld2.getMessage());



        // Using Args constructor with no setters:
        Pokemon pokemon1 = (Pokemon) factoryXML.getBean("pokemon1");
        System.out.println(pokemon1);
        // Using No-Args Constructor with Setters
        Pokemon pokemon2 = (Pokemon) factoryXML.getBean("pokemon2");
        System.out.println(pokemon2);

        // property based injection with a nested object
        Trainer trainer1 = factoryXML.getBean(com.revature.entity.Trainer.class);
        System.out.println(trainer1);

        // bean with a list as a field:
        ListExample listExample1 = factoryXML.getBean(ListExample.class);
        System.out.println(listExample1.getNames());









        System.out.println("\n\nAnnotation-based Configuration:");

        Order order1 = factoryXML.getBean(Order.class);
        System.out.println(order1);

        Account account1 = (Account) factoryXML.getBean("ron");
        System.out.println(account1);



    }
}
