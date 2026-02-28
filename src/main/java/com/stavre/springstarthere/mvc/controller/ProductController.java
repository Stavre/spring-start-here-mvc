package com.stavre.springstarthere.mvc.controller;

import com.stavre.springstarthere.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String productPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products.html";
    }
}
