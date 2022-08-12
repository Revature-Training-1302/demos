package com.revature.service;

import com.revature.data.PetDao;
import com.revature.data.PetDaoTempImpl;
import com.revature.entity.Pet;

import java.util.List;

// for this class, a lot of our methods
// are going to be a matter of creating a dao and then calling the method:
public class PetService {
    public Pet insert(Pet pet) {
        // declare a pet dao and give it the temporary implementation that we have:
        PetDao petDao = new PetDaoTempImpl();
        // insert the pet and return the return value:
        return petDao.insert(pet);
    }

    public Pet getById(int id) {
        PetDao petDao = new PetDaoTempImpl();
        return petDao.getById(id);
    }

    public List<Pet> getAllPets() {
        PetDao petDao = new PetDaoTempImpl();
        return petDao.getAllPets();
    }

    public Pet updatePet(Pet pet) {
        PetDao petDao = new PetDaoTempImpl();
        return petDao.update(pet);
    }

    public boolean deletePet(int id) {
        PetDao petDao = new PetDaoTempImpl();
        return petDao.delete(id);
    }


}
