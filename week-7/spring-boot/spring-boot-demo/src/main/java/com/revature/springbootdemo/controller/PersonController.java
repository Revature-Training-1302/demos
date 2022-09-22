package com.revature.springbootdemo.controller;

import com.revature.springbootdemo.entity.Person;
import com.revature.springbootdemo.entity.Pet;
import com.revature.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    // sample request: localhost:/8080/people/1/pets/4
    // indicating that person with id 1 is adopting pet with id 4
    @PatchMapping("/{personId}/pets/{petId}")
    public Person adopt(@PathVariable("personId") Long personId, @PathVariable("petId") Long petId) {
        return personService.adopt(personId, petId);
    }

    @GetMapping("/{personId}/pets")
    public List<Pet> getAdopted(@PathVariable("personId") Long id) {
        return personService.getAdopted(id);
    }


}
