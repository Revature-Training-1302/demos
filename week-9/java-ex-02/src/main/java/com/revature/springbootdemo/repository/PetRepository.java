package com.revature.springbootdemo.repository;

import com.revature.springbootdemo.entity.Pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// indicating that this is a bean, and specifically this is our data access layer
// Stereotypes: Repository, Controller, Service
// All stereotypes are @Component (which means the class/interface will be registered as a bean)
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    // We don't need an implementation of this interface
    // We already have some automatically created methods that will let us interact with the database

    // Derived Queries
    // All we have to do is specify the name of the method and it should work as expected*
    // Take a look at the syntax here:  https://www.baeldung.com/spring-data-derived-queries
    List<Pet> findByName(String name);

    // Custom Query:
    // Come back to this, setting up the relationship:
    @Query(value = "SELECT * FROM pet where person_fk = ?1", nativeQuery = true)
    // ?1 refers to the parameter owner_id
    // If we added more parameters, the syntax would be ?2, ?3, etc.
    public List<Pet> findAdoptedPets(Long owner_id);



}
