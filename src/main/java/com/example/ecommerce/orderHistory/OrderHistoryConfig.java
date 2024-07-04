package com.example.ecommerce.orderHistory;

import com.example.ecommerce.orderHistory.repository.JpaOrderHistoryRepository;
import com.example.ecommerce.orderHistory.repository.OrderHistoryRepository;
import com.example.ecommerce.orderHistory.service.OrderHistoryService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderHistoryConfig {
    private EntityManager em;

    public OrderHistoryConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public OrderHistoryRepository orderHistoryRepository() {
        return new JpaOrderHistoryRepository(em);
    }

    @Bean
    public OrderHistoryService orderHistoryService() {
        return new OrderHistoryService(orderHistoryRepository());
    }


}
