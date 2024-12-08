package ru.boshchenko.rtz_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/catalog_products")
    public String clientProductsAllPage() {
        return "client_catalog_products.html";
    }

    @GetMapping("/chat")
    public String clientChatPage() {
        return "client_chat.html";
    }

    @GetMapping
    public String clientMainPage() {
        return "client_main.html";
    }

    @GetMapping("/order")
    public String clientOrderPage() {
        return "client_basket.html";
    }

    @GetMapping("/product_card")
    public String productCardPage() {
        return "client_product_card.html";
    }

}
