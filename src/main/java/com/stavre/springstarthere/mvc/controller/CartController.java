package com.stavre.springstarthere.mvc.controller;

import com.stavre.springstarthere.mvc.factory.BillFactory;
import com.stavre.springstarthere.mvc.model.Bill;
import com.stavre.springstarthere.mvc.model.Product;
import com.stavre.springstarthere.mvc.service.CartManagementService;
import com.stavre.springstarthere.mvc.service.LoggedInUserManagementService;
import com.stavre.springstarthere.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartManagementService cartManagementService;
    private final ProductService productService;
    private final LoggedInUserManagementService loggedInUserManagementService;
    private final BillFactory billFactory;

    @PostMapping("/cart/add")
    public String addProduct(@RequestParam(name = "productId") String productId) {
        if (!loggedInUserManagementService.isLoggedIn()) {
            return "redirect:/login?message=You need to authenticate before adding products to cart.";
        }

        Product product = productService.getProductById(productId);
        cartManagementService.addProduct(product);
        return "redirect:/products/" + loggedInUserManagementService.getUsername();
    }

    @PostMapping("/cart/remove")
    public String removeProduct(@RequestParam(name = "productId") String productId) {
        Product product = productService.getProductById(productId);
        cartManagementService.removeProduct(product);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        if (!loggedInUserManagementService.isLoggedIn()) {
            return "redirect:/login";
        }

        List<Product> cartProducts = cartManagementService.getProducts();
        Bill bill = billFactory.getBill(cartProducts);

        model.addAttribute("cartProducts", cartProducts);
        model.addAttribute("bill", bill);
        model.addAttribute("username", loggedInUserManagementService.getUsername());
        return "cart.html";
    }
}
