package com.dailycodebuffer.springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping(value  = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloworld() {
        return "Welcome to Spring Boot tutorial";
    }
}
