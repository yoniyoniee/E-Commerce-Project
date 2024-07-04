package com.example.ecommerce.product.service;

import com.example.ecommerce.product.dto.ProductsResonseDto;
import com.example.ecommerce.product.entity.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductsServiceTest {

    @Autowired
    ProductsService productsService;


    @Test
    void getAllProducts() {

        List<ProductsResonseDto> products = productsService.getAllProducts();
        assertEquals(1, products.size());

    }

    @Test
    @Commit
    void registerProducts() {

        Products products = new Products();

        products.setProductCode("TP_VEST");
        products.setProductName("나시");
        products.setCategory("top");
        products.setPrice(8000);
        products.setStock(45);


        productsService.registerProduct(products);
        assertEquals(1, productsService.getAllProducts().size());
    }

    @Test
    void getProductByCategory() {

        String category = "top";

        List<ProductsResonseDto> list = productsService.getProductsByCategory(category);

    }
}