package com.stavre.springstarthere.mvc.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

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

// TODO: Find a better way to suppress PMD.UnitTestShouldIncludeAssert

@WebMvcTest(ProductController.class)
@AutoConfigureRestTestClient
@SuppressWarnings("PMD.UnitTestShouldIncludeAssert")
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void productPageShouldReturnProductsViewWithModelAttributes() throws Exception {

        var first = new Product(UUID.fromString("08886810-5289-42d9-83b9-ad8feef5bc26"),
                "Classic Leather Wallet",
                "/images/23cf4678.png",
                new BigDecimal("12.59"));
        var second = new Product(UUID.fromString("fe23e950-66c9-4f21-8f79-d943c7c87f4b"),
                "Ceramic Coffee Mug",
                "/images/3298b269.png",
                new BigDecimal("12.99"));

                // Arrange
        List<Product> mockProducts = List.of(first, second);
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
