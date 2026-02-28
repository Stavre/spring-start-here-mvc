package com.stavre.springstarthere.mvc.service;

import com.stavre.springstarthere.mvc.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
@RequiredArgsConstructor
public class CartManagementService {
    private final List<Product> cartProducts = new ArrayList<>();

    public void addProduct(Product product) {
        cartProducts.add(product);
    }

    public void removeProduct(Product product) {
        cartProducts.remove(product);
    }

    public List<Product> getProducts() {
        return cartProducts;
    }
}
