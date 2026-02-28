package com.stavre.springstarthere.mvc.repository;

import com.stavre.springstarthere.mvc.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    //    Note: Normally this class would have some sort of database connection,
    //    but this is outside the scope of the book.

    @Getter
    private final List<Product> products = List.of(
        new Product(UUID.randomUUID(), "Classic Leather Wallet", "/images/23cf4678.png", new BigDecimal("12.59")),
        new Product(UUID.randomUUID(), "Ceramic Coffee Mug", "/images/3298b269.png", new BigDecimal("12.99")),
        new Product(UUID.randomUUID(), "Wireless Earbuds Pro", "/images/ad25a693.png", new BigDecimal("79.00")),
        new Product(UUID.randomUUID(), "Bamboo Desk Lamp", "/images/f973a468.png", new BigDecimal("45.50")),
        new Product(UUID.randomUUID(), "Urban Backpack 20L", "/images/7016332f.png", new BigDecimal("59.99")),
        new Product(UUID.randomUUID(), "Stainless Water Bottle", "/images/b0caeff9.png", new BigDecimal("18.25")),
        new Product(UUID.randomUUID(), "Minimalist Watch", "/images/2bf97ef9.png", new BigDecimal("129.00")),
        new Product(UUID.randomUUID(), "Knit Beanie Hat", "/images/36a07721.png", new BigDecimal("14.50")),
        new Product(UUID.randomUUID(), "Portable Phone Charger", "/images/5086a0e6.png", new BigDecimal("34.75")),
        new Product(UUID.randomUUID(), "Scented Candle Set", "/images/53d1ee6a.png", new BigDecimal("22.00"))
        );
}
