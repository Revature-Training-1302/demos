package com.revature.cartexample.service;

import com.revature.cartexample.data.PersonRepository;
import com.revature.cartexample.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void add(Person person) {
        personRepository.save(person);
    }

    public Person getById(Long id) {
        return personRepository.findById(id).get();
    }
}
