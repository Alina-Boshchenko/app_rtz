package ru.boshchenko.rtz_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String mainPage(){
        return "main.html";
    }

    @GetMapping("/registration")
    public String registrationPage(){
        return "registration.html";
    }


}
