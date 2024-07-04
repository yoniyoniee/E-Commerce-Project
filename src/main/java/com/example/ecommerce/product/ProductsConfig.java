package com.example.ecommerce.product;

import com.example.ecommerce.product.repository.JpaProductsRepository;
import com.example.ecommerce.product.repository.ProductsRepository;
import com.example.ecommerce.product.service.ProductsService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductsConfig {

    private EntityManager em;

    public ProductsConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public ProductsRepository productsReepository() {
        return new JpaProductsRepository(em);
    }

    @Bean
    public ProductsService productsService() {
        return new ProductsService(productsReepository());
    }



}
