package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

// this annotation is a stereotype
// the other stereotypes are service and repository
// indicates the purpose of the class
@Controller
public class HelloController {

    // this is a regular Java method, and it returns a string:
    // what url maps to this particular method? We define that using the RequestMapping annotation:
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/cat")
    public String cat() {
        return "cat";
    }
}
