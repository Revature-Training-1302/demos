package com.revature.controller;

import com.revature.entity.Pet;
import com.revature.exception.PetNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/*
To make sure we can return JSON objects:
1. Make sure we have the proper dependencies in the pom.xml (Jackson)
2. Make sure we're using the appropriate annotations (ResponseBody, RequestMapping)
3. Set up some configuration in dispatcher-servlet.xml
 */

// The @RestController annotation lets us create HTTP Requests in our controller:
@RestController
// if we use the request mapping annotation at the class level, we get a prefix for all of these requests:
@RequestMapping("/pets")
public class PetController {

    // Put our GET/POST/PUT/DELETE
    @RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
    @ResponseBody
    // add an optional request parameter to specify the species:
    public List<Pet> getPets(@RequestParam(value = "species", required = false) String species) {
        if(species.equals("cat")) {
            // return some dummy cats:
            List<Pet> cats = new ArrayList<>();
            cats.add(new Pet(1, "Garfield", "cat"));
            cats.add(new Pet(2, "Tom", "cat"));
            cats.add(new Pet(3, "Ashes", "cat"));
            return cats;
        }
        List<Pet> pets = new ArrayList<>();
        // returning some dummy generic pets:
        pets.add(new Pet(1, "Pet 1", "Cat"));
        pets.add(new Pet(2, "Pet 2", "Dog"));
        pets.add(new Pet(3, "Pet 3", "Fish"));
        pets.add(new Pet(4, "Pet 4", "Turtle"));
        return pets;
    }

    // Get a pet by id:
    @GetMapping(value = "/{id}")
    public Pet getPetById(@PathVariable("id") int id) {
        // return some dummy data:
        return new Pet(id, "Pet 1", "Cat");
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        // set some dummy generated id:
        pet.setId(2);
        return pet;
    }

    @PutMapping
    public Pet updatePet(@RequestBody Pet pet) {
        System.out.println("Updating pet....");
        // return dummy data:
        return pet;
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable("id") int id) throws PetNotFoundException {
        System.out.println("Deleting pet with id " + id);
        // in reality, you would send this id to the service layer
        // imagine we're trying to delete a pet with an id that doesn't exist:
        // hard-code this dummy value, but we'd really want to check if the id is in the database:
        if(id == 5) {
            throw new PetNotFoundException();
        }

    }

}
