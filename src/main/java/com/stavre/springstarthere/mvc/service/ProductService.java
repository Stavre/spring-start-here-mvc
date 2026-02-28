package com.stavre.springstarthere.mvc.service;

import com.stavre.springstarthere.mvc.model.Product;
import com.stavre.springstarthere.mvc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    public Product getProductById(String id) {
        return getAllProducts().stream()
                .filter(product -> product.id().equals(UUID.fromString(id)))
                .findFirst().orElseThrow();
    }
}
