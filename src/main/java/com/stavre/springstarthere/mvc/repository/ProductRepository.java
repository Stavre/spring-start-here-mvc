package com.stavre.springstarthere.mvc.repository;

import com.stavre.springstarthere.mvc.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("LineLength")
@Repository
public class ProductRepository {
    //    Note: Normally this class would have some sort of database connection,
    //    but this is outside the scope of the book.

    @Getter
    private final List<Product> products = List.of(
        new Product(UUID.fromString("08886810-5289-42d9-83b9-ad8feef5bc26"), "Classic Leather Wallet", "/images/23cf4678.png", new BigDecimal("12.59")),
        new Product(UUID.fromString("fe23e950-66c9-4f21-8f79-d943c7c87f4b"), "Ceramic Coffee Mug", "/images/3298b269.png", new BigDecimal("12.99")),
        new Product(UUID.fromString("ff3455ce-de6b-478e-8fb0-8d732ce094c8"), "Wireless Earbuds Pro", "/images/ad25a693.png", new BigDecimal("79.00")),
        new Product(UUID.fromString("8f0997a6-51af-4db7-ae89-940560c4a172"), "Bamboo Desk Lamp", "/images/f973a468.png", new BigDecimal("45.50")),
        new Product(UUID.fromString("5c57861d-b994-4ab9-9307-69fb729b06a6"), "Urban Backpack 20L", "/images/7016332f.png", new BigDecimal("59.99")),
        new Product(UUID.fromString("8902c5fc-634c-4a1d-86fc-ce00937576bd"), "Stainless Water Bottle", "/images/b0caeff9.png", new BigDecimal("18.25")),
        new Product(UUID.fromString("4b24f1c9-6be9-48e8-9414-3854e0f39c21"), "Minimalist Watch", "/images/2bf97ef9.png", new BigDecimal("129.00")),
        new Product(UUID.fromString("0c48cf22-8240-4481-b30b-80cbd78dc636"), "Knit Beanie Hat", "/images/36a07721.png", new BigDecimal("14.50")),
        new Product(UUID.fromString("2e15c140-0e40-4b06-8da4-ccbb9f384bc6"), "Portable Phone Charger", "/images/5086a0e6.png", new BigDecimal("34.75")),
        new Product(UUID.fromString("734a78fc-bf54-4038-8544-2f1c9ec00c31"), "Scented Candle Set", "/images/53d1ee6a.png", new BigDecimal("22.00"))
        );
}
