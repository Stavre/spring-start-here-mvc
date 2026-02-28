package com.stavre.springstarthere.mvc.controller;

import com.stavre.springstarthere.mvc.model.Product;
import com.stavre.springstarthere.mvc.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
@AutoConfigureRestTestClient
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void productPageShouldReturnProductsViewWithModelAttributes() throws Exception {

        // Arrange
        List<Product> mockProducts = List.of(
                new Product(UUID.randomUUID(), "Classic Leather Wallet", "/images/23cf4678.png", new BigDecimal("12.59")),
                new Product(UUID.randomUUID(), "Ceramic Coffee Mug", "/images/3298b269.png", new BigDecimal("12.99"))
                );
        given(productService.getAllProducts()).willReturn(mockProducts);

        // Act & Assert
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("products.html"))
                .andExpect(xpath("//div[@id=\"no-products-message\"]").doesNotExist())

                .andExpect(model().attribute("products", mockProducts));
    }
    @Test
    void productPageShouldReturnEmptyMessageViewWithModelAttributes() throws Exception {

        // Arrange
        List<Product> mockProducts = List.of();
        given(productService.getAllProducts()).willReturn(mockProducts);

        // Act & Assert
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("products.html"))
                .andExpect(xpath("//div[@id=\"no-products-message\"]").exists())
                .andExpect(model().attribute("products", mockProducts));
    }
}
