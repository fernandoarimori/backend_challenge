package com.example.backendpicPay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorld {
    @GetMapping
    public String helloWorld() {
        return "Hello World! DevToolsTest";
    }
}
