package com.sunyard.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/first")
    public String first() {
        return "first controller";
    }

    @GetMapping("/doerror")
    public String error() {
        return "error";
    }
}
