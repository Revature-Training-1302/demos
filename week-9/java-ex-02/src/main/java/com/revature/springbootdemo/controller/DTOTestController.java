package com.revature.springbootdemo.controller;

import com.revature.springbootdemo.dto.PetPerson;
import com.revature.springbootdemo.entity.Person;
import com.revature.springbootdemo.entity.Pet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dto")
@RestController
public class DTOTestController {

    @PostMapping
    public void post(@RequestBody PetPerson petPerson) {
        System.out.println(petPerson);
        System.out.println("Hello");
        Pet pet = petPerson.getPet();
        Person person = petPerson.getPerson();
        // Do whatever we need to do with the entities:
    }
}
