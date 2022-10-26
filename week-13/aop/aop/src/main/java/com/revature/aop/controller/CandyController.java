package com.revature.aop.controller;

import com.revature.aop.entity.Candy;
import com.revature.aop.service.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candy")
public class CandyController {

    @Autowired
    private CandyService candyService;

    // BAD REST, including verbs in the endpoints:
    @GetMapping("/treat")
    public Candy treat() {
        return candyService.treat();
    }

    @GetMapping("/trick")
    public String trick() {
        // try to trick, but catch the exception
        try {
            return candyService.trick();
        } catch (Exception e) {
            // return the message from that exception:
            return e.getMessage();
        }
    }

}
