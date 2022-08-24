package com.revature.controller;

import com.revature.entity.Pet;
import com.revature.service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PetServlet extends HttpServlet{
    // type out doget, and you should get a shortcut for the get method:
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // create an instance of the pet service so we can use those methods:
        PetService petService = new PetService();
        List<Pet> pets = petService.getAllPets();
        for(Pet pet: pets) {
            System.out.println(pet);
        }
        // TODO return these values as a response
    }
}
