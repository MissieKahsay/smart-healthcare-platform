package com.smarthealth.platform.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Smart Healthcare Platform API!";
    }

    @GetMapping("/api/test")
    public String test() {
        return "Test OK ✅";
    }
}
