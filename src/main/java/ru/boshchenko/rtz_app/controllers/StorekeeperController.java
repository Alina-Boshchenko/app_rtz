package ru.boshchenko.rtz_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storekeeper")
public class StorekeeperController {

    @GetMapping
    public String storekeeperMainPage() {
        return "storekeeper_main.html";
    }

    @GetMapping("/create_product")
    public String storekeeperCreateProductPage() {
        return "storekeeper_create_product.html";
    }

    @GetMapping("/create_product_details")
    public String storekeeperCreateTypeProductPage() {
        return "storekeeper_create_product_details.html";
    }

    @GetMapping("/storage")
    public String storekeeperStoragePage() {
        return "storekeeper_storage.html";
    }


    @GetMapping("/product_card")
    public String storekeeperProductCardPage() {
        return "storekeeper_product_card.html";
    }

}
