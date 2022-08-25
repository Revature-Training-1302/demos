package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.entity.Person;
import com.revature.service.PersonService;
import com.revature.service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PersonServlet extends HttpServlet {

    // register, creating/inserting a new user:
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        PersonService personService = new PersonService();

        ObjectMapper mapper = new ObjectMapper();

        Person person;

        try {
            // Object Mapper requires default constructor:
            person = mapper.readValue(req.getReader(), Person.class);

        }catch(Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid person format");
            return;
        }

        person = personService.register(person);

        out.println(person);
    }

    //login will be getting a user:

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        // get credentials from request parameters(bad form)
        // The proper way to do this would be to set up a DTO (Data Transfer Object), which would be a class that stores id and a password
        // And then use ObjectMapper to take the body and convert that into a DTO
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");

        // set up an instance of our service:
        PersonService personService = new PersonService();

        // call the service method:
        Person person = personService.login(id, password);

        // check if the login was successful and return corresponding response:
        if(person == null) {
            resp.sendError(400, "Invalid credentials");
        }
        else {
            out.println("You are logged in!");
        }
    }
}
