package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.entity.Person;
import com.revature.entity.Pet;
import com.revature.service.PersonService;
import com.revature.service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PersonServlet extends HttpServlet {

    // register, but also logging in:
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // print writer and person service intiliaze
        PrintWriter out = resp.getWriter();
        PersonService personService = new PersonService();

        // set up variables to store the person object from the body:
        ObjectMapper mapper = new ObjectMapper();
        Person person;

        // try to read in the credential information:
        try {
            // Object Mapper requires default constructor:
            person = mapper.readValue(req.getReader(), Person.class);
        }catch(Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid person format");
            return;
        }

        // either login or register:
        String authType = req.getParameter("auth");
        if(authType.equals("login")) {
            person = personService.login(person.getId(), person.getPassword());
        }
        else if (authType.equals("register")){
            person = personService.register(person);
        }

        // if invalid credentials, return error code:
        if(person == null) {
            resp.sendError(400, "Invalid credentials");
            return;
        }

        // otherwise print out the person:
        out.println(person.getName());

        // update the session with the person's id: (indicates if we are logged in/registered
        req.getSession().setAttribute("id", person.getId());
    }

    // getting our adopted pets
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        PersonService personService = new PersonService();

        // try to get the person id from the session:
        int personId;
        try {
            // trying to access the session and get the id of the current logged in user:
            personId = (Integer) req.getSession().getAttribute("id");
        } catch (Exception e) {
            // if we don't get the id, we send a 401 (authantication) error
            resp.sendError(401, "Must be logged in to view adopted pets");
            return;
        }
        // Otherwise, get the pet that we want to update (using the id from the session)
        List<Pet> pets = personService.getAdoptedPets(personId);

        for(Pet pet: pets) {
            out.println(pet);
        }

    }

    // adopt a pet (updating the pet table)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        PersonService personService = new PersonService();

        // some variables to store our person id and the pet id:
        int personId;
        int petId;
        // try to get the person id from the session:
        try {
            personId = (Integer) req.getSession().getAttribute("id");
        } catch (Exception e) {
            // if we don't get the id, we send a 401 (authantication) error
            resp.sendError(401, "Must be logged in to adopt.");
            return;
        }
        // make sure we get the pet id from request parameter:
        try {
            petId = Integer.parseInt(req.getParameter("petId"));
        } catch (Exception e) {
            resp.sendError(400, "Must include pet id.");
            return;
        }
        // adopt the pet:
        try {
            personService.adopt(personId, petId);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Make sure pet id exists!");
            return;
        }
        out.println("Pet adopted successfully!");
    }
}
