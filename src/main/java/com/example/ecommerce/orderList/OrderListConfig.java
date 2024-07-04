package com.example.ecommerce.orderList;

import com.example.ecommerce.orderList.repository.JpaOrderListRepository;
import com.example.ecommerce.orderList.repository.OrderListRepository;
import com.example.ecommerce.orderList.service.OrderListService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderListConfig {

    private EntityManager em;

    public OrderListConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public OrderListRepository orderListRepository() {
        return new JpaOrderListRepository(em);
    }

    @Bean
    public OrderListService orderListService() {
        return new OrderListService(orderListRepository());
    }




}
