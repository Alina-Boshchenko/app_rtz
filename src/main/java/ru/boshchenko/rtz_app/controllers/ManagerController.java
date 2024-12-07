package ru.boshchenko.rtz_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping
    public String managerMainPage() {
        return "manager_main.html";
    }

    @GetMapping("/product_card")
    public String managerProductCardPage() {
        return "manager_product_card.html";
    }

}
