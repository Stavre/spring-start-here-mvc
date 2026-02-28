package com.stavre.springstarthere.mvc.service;

import com.stavre.springstarthere.mvc.model.Product;
import com.stavre.springstarthere.mvc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }
}
