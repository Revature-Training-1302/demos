package com.revature.springbootdemo.controller;

import com.revature.springbootdemo.entity.Person;
import com.revature.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    // required = true, guarantees that we need a request parameter with the key "auth":
    public Person auth(@RequestBody Person person, @RequestParam(value = "auth", required = true) String authType) {
        if(authType.equals("login")) return personService.login(person);
        else if (authType.equals("register")) return personService.register(person);
        else return null;
    }


}
