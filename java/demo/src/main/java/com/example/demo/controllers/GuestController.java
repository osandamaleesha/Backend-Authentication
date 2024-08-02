package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")

public class GuestController {
    @GetMapping("/login_dashboard")
    public String home(){
        return "Welcome to dashboard!";
    }
}