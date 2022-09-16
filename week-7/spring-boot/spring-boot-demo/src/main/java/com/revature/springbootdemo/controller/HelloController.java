package com.revature.springbootdemo.controller;

import com.revature.springbootdemo.entity.Monster;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello from project";
    }

    // Rest Template - allows us to access external apis from our Spring project:
    @GetMapping("/pokemon/{id}")
    public String pokemon(@PathVariable("id") Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://pokeapi.co/api/v2/pokemon/" + id;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(resourceUrl, String.class);
        // return the body of the response that we get from the API:
        return responseEntity.getBody();
    }

    @GetMapping("/monster")
    public String monster() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://dnd5eapi.co/api/conditions/blinded";
        // getForObject lets us return the data into an object
        Monster monster = restTemplate.getForObject(resourceUrl, Monster.class);
        // Now that we have this data encapsulated in a Java object, we could do whatever we want with it:
        return monster.getName();
    }
}
