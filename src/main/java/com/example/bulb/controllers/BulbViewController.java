package com.example.bulb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BulbViewController {
    @GetMapping
    public String mainView() {
        return "bulb";
    }
}
