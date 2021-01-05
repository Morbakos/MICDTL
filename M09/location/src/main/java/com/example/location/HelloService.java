package com.example.location;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {
    @GetMapping (value="/")
    public String hello() {
        return "Bonjour !";
    }
}