package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.entity.Pet;
import com.revature.service.PetService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
This is the entry point to our project from Postman (or any client). This servlet class is mapped the end point "/books" in the pom.xml.
In Postman, we would enter an endpoint that looks something like "localhost:8080/book/book" and change which request
we trigger by selecting POST, GET, PUT, or DELETE from the dropdown on Postman.

The reason that we have /book/book in our url is that the url to our project is "localhost:8080/book". We add the second "/book"
because this is what we mapped this http servlet class to.
 */
public class PetServlet extends HttpServlet {
    /*
    For this method, depending on whether or not we pass in a parameter, we return all books or just a specific book:
    Example: "localhost:8080/book/book" would return all books
    "http://localhost:8080/book/book?id=10" would return the book corresponding to that id
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // set up the response type of this response:
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        // create an instance of our service:
        PetService petService = new PetService();

        // get the path info:
        String pathInfo = req.getPathInfo();
        // if our path is null, that means we didn't pass in an id:
        if (pathInfo == null) {
            out.println("All pets: ");
            List<Pet> pets = petService.getAllPets();
            for(Pet pet: pets) {
                out.println(pet.toString());
            }
            return;
        }
        // remove the / from the path info:
        pathInfo = pathInfo.substring(1);
        int id = Integer.parseInt(pathInfo);

        Pet pet = petService.getById(id);

        // if pet doesn't exist, send a 400 bad request
        if (pet == null) {
            res.sendError(400, "Pet with id " + id + " does not exist!");
        }
        else {
            out.println(pet.toString());
        }


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        PetService petService = new PetService();
        // here, we are mapping the json request (What we put into Postman) to a Java object (entity.Pet).
        ObjectMapper mapper = new ObjectMapper();
        Pet pet;
        try{
            pet = mapper.readValue(req.getReader(), Pet.class);
        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(400, "Invalid pet format");
            return;
        }
        // call the service and return the pet:
        pet = petService.insert(pet);
        out.write(pet.toString());
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        PetService petService = new PetService();
        // here, we are mapping the json request (What we put into Postman) to a Java object (entity.Pet).
        ObjectMapper mapper = new ObjectMapper();
        Pet pet;
        try{
            pet = mapper.readValue(req.getReader(), Pet.class);
        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(400, "Invalid pet format");
            return;
        }
        // call the service and return the pet:
        pet = petService.updatePet(pet);
        if(pet == null) {
            res.sendError(400, "Must include id that is present in database");
            return;
        }
        out.write(pet.toString());
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PetService petService = new PetService();
        PrintWriter out = res.getWriter();

        String pathInfo = req.getPathInfo();
        pathInfo = pathInfo.substring(1);
        int id = Integer.parseInt(pathInfo);

        // call the service:
        boolean success = petService.deletePet(id);
        // check if deletion was successful and send the appropriate response:
        if(success) {
            out.write("Deletion success!");
        }
        else {
            res.sendError(400, "Id doesn't exist.");
        }


    }
}
