package com.revature;

import com.revature.config.PokemonConfig;
import com.revature.entity.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws InterruptedException {

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


        System.out.println("\n\n\nJava-based Configuration:");


        // regular Java object
        Pokemon poke1 = new Pokemon("Charmander", "char", "fire", "dragon", 5);

        // Bean:
        // we instantiate this application context using the config class that we made:
        GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(PokemonConfig.class);

        // using the get bean method, we can retrieve a Pokemon bean from the Pokemon config class:
        Pokemon pokemon3 = (Pokemon) applicationContext.getBean("random");
        Pokemon pokemon4 = (Pokemon) applicationContext.getBean("regular");
        Pokemon pokemon5 = (Pokemon) applicationContext.getBean("random"); // if singleton scope, take the bean value that we got for pokemon 3 (it wouldn't call the method again)

        System.out.println(pokemon3);
        System.out.println(pokemon5);

        // because we imported the berry config class into the pokemon config class, we can get the berry beans from the same application context:
        Berry berry = applicationContext.getBean(Berry.class);
        System.out.println(berry);

        // Force our clean-up methods (Look more into this):
        applicationContext.close();


    }
}
