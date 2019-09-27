package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class ApplicationController
{
    @GetMapping("/hello")
    public String greeting(){
        return "Hello world";
    }
}
