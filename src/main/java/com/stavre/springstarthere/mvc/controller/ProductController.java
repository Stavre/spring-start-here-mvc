package com.stavre.springstarthere.mvc.controller;

import com.stavre.springstarthere.mvc.service.LoggedInUserManagementService;
import com.stavre.springstarthere.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;
    private final LoggedInUserManagementService loggedInUserManagementService;

    @GetMapping("/products")
    public String productPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products.html";
    }

    @GetMapping("/products/{username}")
    public String productPageForAuthenticatedUsers(@PathVariable String username, Model model) {
        if (!loggedInUserManagementService.isLoggedIn()) {
            return "redirect:/login?message=You need to authenticate first before accessing your personal page.";
        }
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("username", loggedInUserManagementService.getUsername());
        return "products.html";
    }
}
