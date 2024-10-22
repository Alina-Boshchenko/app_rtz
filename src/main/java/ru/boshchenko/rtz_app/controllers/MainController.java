package ru.boshchenko.rtz_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

    @GetMapping
    public String mainPage(){
        return "main.html";
    }

    // TODO тут происходит какая-то хуета / уже не происходит
    @GetMapping("/client_catalog_products")
    public String clientProductsAllPage(){
        return "client_catalog_products.html";
    }

    @GetMapping("/client_chat")
    public String clientChatPage(){
        return "client_chat.html";
    }

    @GetMapping("/client_main")
    public String clientMainPage(){
        return "client_main.html";
    }

    @GetMapping("/client_order")
    public String clientOrderPage(){
        return "client_order.html";
    }
    @GetMapping("/registration")
    public String registrationPage(){
        return "registration.html";
    }

    @GetMapping("/storekeeper_main")
    public String storekeeperMainPage(){
        return "storekeeper_main.html";
    }
    @GetMapping("/storekeeper_create_product")
    public String storekeeperCreateProductPage(){
        return "storekeeper_create_product.html";
    }

    @GetMapping("/storekeeper_create_product_details")
    public String storekeeperCreateTypeProductPage(){
        return "storekeeper_create_product_details.html";
    }

    @GetMapping("/storekeeper_storage")
    public String storekeeperStoragePage(){
        return "storekeeper_storage.html";
    }



    // storekeeper_create_product
}
