package com.shrew.consulting.eagleeye.msp.service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1")
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "Hello, world!!";
    }

}
