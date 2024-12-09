package ru.boshchenko.rtz_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    @GetMapping
    public String clientMainPage() {
        return "client_main.html";
    }

    @GetMapping("/catalog_products")
    public String clientProductsAllPage() {
        return "client_catalog_products.html";
    }

    @GetMapping("/chat")
    public String clientChatPage() {
        return "client_chat.html";
    }

    @GetMapping("/basket")
    public String clientBasketPage() {
        return "client_basket.html";
    }

    @GetMapping("/product_card")
    public String productCardPage() {
        return "client_product_card.html";
    }

    @GetMapping("/delivery_calendar")
    public String clientDeliveryCalendarPage() {
        return "client_delivery_calendar.html";
    }

    @GetMapping("/chat_bot")
    public String clientChatBotPage() {
        return "client_chat_bot.html";
    }

    @GetMapping("/catalog_order")
    public String clientCatalogOrderPage() {
        return "client_catalog_order.html";
    }

    @GetMapping("/catalog_accounts")
    public String clientCatalogAccountsPage() {
        return "client_catalog_accounts.html";
    }

    @GetMapping("/news")
    public String clientNewsPage() {
        return "client_news.html";
    }
}
