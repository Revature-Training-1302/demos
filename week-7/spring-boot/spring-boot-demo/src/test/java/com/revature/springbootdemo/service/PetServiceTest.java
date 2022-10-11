package com.revature.springbootdemo.service;

import com.revature.springbootdemo.entity.Pet;
import com.revature.springbootdemo.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PetServiceTest {

    @Test
    public void testInsert() {
        // create a pet to insert:
        Pet pet = new Pet();
        pet.setSpecies("cat");
        pet.setFood("tuna");
        pet.setName("Ashes");
        // create a mock of the repository:
        PetRepository petRepository = mock(PetRepository.class);
        // configure the mock repository to return a pet with an initialized id value of 1:
        when(petRepository.save(pet)).thenReturn(new Pet(1l, "Ashes", "cat", "tuna"));
        // Create a PetService using this mock repository (note that we need to set up the constructor in the PetService
        // that takes in a PetRepository:
        PetService petService = new PetService(petRepository);

        // insert the pet using the PetService:
        pet = petService.insert(pet);
        // assert that the pet's id is 1:
        assert pet.getId() == 1l;
    }
}
