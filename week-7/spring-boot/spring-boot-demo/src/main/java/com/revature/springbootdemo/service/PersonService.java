package com.revature.springbootdemo.service;

import com.revature.springbootdemo.entity.Person;
import com.revature.springbootdemo.entity.Pet;
import com.revature.springbootdemo.repository.PersonRepository;
import com.revature.springbootdemo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    public Person register(Person person) {
        personRepository.save(person);
        return person;
    }

    public Person login(Person person) {
        Person personDB = personRepository.findById(person.getId()).get();
        if(person.getPassword().equals(personDB.getPassword())) return personDB;
        else return null;
    }

    public Person adopt(Long personId, Long petId) {
        Pet pet = petRepository.findById(petId).get();
        Person person = personRepository.findById(personId).get();
        // update the person object:
        person.adopt(pet);
        // persist this change to the database:
        personRepository.save(person);
        return person;
    }

    public List<Pet> getAdopted(Long personId) {
        // return the pets that correspond to this person's id
        return petRepository.findAdoptedPets(personId);
    }
}
