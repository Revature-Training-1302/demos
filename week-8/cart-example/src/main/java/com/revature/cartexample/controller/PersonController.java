package com.revature.cartexample.controller;

import com.revature.cartexample.entity.Person;
import com.revature.cartexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public Person add(@RequestBody Person person) {
        personService.add(person);
        return person;
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") Long id) {
        return personService.getById(id);
    }


}
