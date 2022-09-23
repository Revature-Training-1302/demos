package com.revature.cartexample.controller;

import com.revature.cartexample.entity.Cart;
import com.revature.cartexample.entity.Person;
import com.revature.cartexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonService personService;

    // adding a new person:
    @PostMapping
    public Person add(@RequestBody Person person) {
        personService.add(person);
        return person;
    }

    // get a person by id:
    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") Long id) {
        return personService.getById(id);
    }

    // Given a personId, a productId, and an optional quantity
    // add *quantity* amount of product to that person's cart (quantity defaults to 1)
    @PatchMapping("/{personId}/products/{productId}")
    public Cart addToCart(@PathVariable("personId") Long personId, @PathVariable("productId") Long productId, @RequestParam(value = "quantity", required = false) Integer quantity) {
        // if our quantity is null, default to 0:
        if(quantity == null) {
            quantity = 1;
        }
        // return the updated cart:
        return personService.addToCart(personId, productId, quantity);
    }

    @PatchMapping("/{personId}")
    public void checkout(@PathVariable("personId") Long personId) {
        personService.checkout(personId);
    }


}
