package com.example.ecommerce.orderDemo;

import com.example.ecommerce.orderDemo.repository.JpaOrderRepository;
import com.example.ecommerce.orderDemo.repository.OrderRepository;
import com.example.ecommerce.orderDemo.service.OrderService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    private EntityManager em;

    public OrderConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public OrderRepository orderRepository() {
        return new JpaOrderRepository(em);
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(orderRepository());
    }
}
