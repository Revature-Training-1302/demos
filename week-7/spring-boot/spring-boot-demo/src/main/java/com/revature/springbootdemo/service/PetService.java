package com.revature.springbootdemo.service;

import com.revature.springbootdemo.entity.Pet;
import com.revature.springbootdemo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    // Automatically inject the repository bean into this class:
    // Declaring a member variable that has the type PetRepository:
    // kind of similar to : petRepository = daoFactory.getPetDao()
    @Autowired
    PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet insert(Pet pet) {
        // insert our pet object into database:
        return petRepository.save(pet);
        // Because we're generating the id of the pet, we want to return it:
    }

    public Pet getById(Long id) {
        return petRepository.findById(id).get();
    }

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public Pet update(Pet pet) {
        petRepository.save(pet);
        return pet;
    }

    public void delete(Long id) {
        petRepository.deleteById(id);
    }

}
