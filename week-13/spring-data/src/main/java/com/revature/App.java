package com.revature;

import com.revature.entity.Costume;
import com.revature.service.CostumeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 * Maven Quickstart Archetype
 */
public class App 
{
    public static void main( String[] args )
    {

        // getting out application context from the XML configuration
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/beans.xml");

        // then we can get our costume service from that
        CostumeService costumeService = ctx.getBean(CostumeService.class);

        costumeService.add(new Costume(1, "Mario", "red", "Super Mario Bros", 19.64));

        System.out.println(costumeService.findAll());

        List<Costume> duplicates = new ArrayList<>();
        duplicates.add(new Costume(2, "Luigi", "green", "Super Mario Bros", 19.65));
        duplicates.add(new Costume(2, "Luigi", "green", "Super Mario Bros", 19.65));
        duplicates.add(new Costume(2, "Luigi", "green", "Super Mario Bros", 19.65));

        // It should be add the first Luigi, but the second will have a conflicting id
        // Because we set up the transactional annotation, none of the Luigi's should be persisted
        try {
            costumeService.addAll(duplicates);
        } catch (EntityExistsException e) {
            System.out.println(e.getMessage());
        }

        // Should only see Mario:
        System.out.println(costumeService.findAll());

    }
}
