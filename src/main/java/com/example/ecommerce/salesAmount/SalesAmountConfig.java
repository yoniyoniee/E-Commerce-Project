package com.example.ecommerce.salesAmount;

import com.example.ecommerce.salesAmount.repository.JpaSalesAmountRepository;
import com.example.ecommerce.salesAmount.repository.SalesAmountRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalesAmountConfig {

    private EntityManager em;

    public SalesAmountConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public SalesAmountRepository salesAmountRepository(EntityManager em) {
        return new JpaSalesAmountRepository(em);
    }
}
