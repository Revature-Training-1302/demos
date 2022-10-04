package com.revature.springbootdemo.controller;

import com.revature.springbootdemo.entity.Pet;
import com.revature.springbootdemo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping()
    public Pet insert(@RequestBody Pet pet) {
        return petService.insert(pet);
    }

    @GetMapping()
    public List<Pet> getAll() {
        return petService.getAll();
    }

    @GetMapping("/{id}")
    public Pet getById(@PathVariable("id") Long id) {
        return petService.getById(id);
    }

    @PutMapping()
    public Pet update(@RequestBody Pet pet) {
        return petService.update(pet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        petService.delete(id);
    }


}
