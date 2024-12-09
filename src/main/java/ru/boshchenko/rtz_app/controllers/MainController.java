package ru.boshchenko.rtz_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String mainPage() {
        return "main.html";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration.html";
    }

    @GetMapping("/about_company")
    public String aboutCompanyPage() {
        return "main_about_company.html";
    }

    @GetMapping("/job_openings")
    public String jobOpeningsPage() {
        return "main_job_openings.html";
    }

    @GetMapping("/products")
    public String productsPage() {
        return "main_products.html";
    }

    @GetMapping("/privacy_policy")
    public String privacyPolicyPage() {
        return "privacy_policy.html";
    }

    @GetMapping("/user_agreement")
    public String userAgreementPage() {
        return "user_agreement.html";
    }
}
