package com.revature.cartexample.service;

import com.revature.cartexample.data.PersonRepository;
import com.revature.cartexample.entity.Cart;
import com.revature.cartexample.entity.Person;
import com.revature.cartexample.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    CartService cartService;

    public void add(Person person) {
        personRepository.save(person);
    }

    public Person getById(Long id) {
        return personRepository.findById(id).get();
    }

    // add a product to a particular user's current cart
    public Cart addToCart(Long personId, Long productId, int quantity) {
        Person person = getById(personId);
        Cart cart = person.getCurrent();
        // take this person's cart and sending it to the cart service, so it can be properly updated:
        cartService.addToCart(cart, productId, quantity);
        return cart;
    }

    public void checkout(Long personId) {
        Person person = getById((personId));
        // add the current cart to previous orders:
        person.getPrevious().add(person.getCurrent());
        // reset the current cart to be empty (removing all the items)
        person.setCurrent(new Cart());
        // persist
        personRepository.save(person);
    }
}

// 1 banana left
// user A puts 1 banana in cart
// user B puts 1 banana in cart
// when they try to checkout, there's only one banana to go around
