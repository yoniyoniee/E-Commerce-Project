package com.example.ecommerce.balance.repository;

import com.example.ecommerce.orderDemo.entity.Orders;
import com.example.ecommerce.orderDemo.repository.OrderRepository;
import com.example.ecommerce.users.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaBalancesRepositoryTest {

    @Autowired private BalancesRepository balancesRepository;
    @Autowired private OrderRepository orderRepository;

    @Test
    void findAll() {
    }

    @Test
    void findByUserId() {
    }

    @Test
    void findCurrentBalance() {
        Orders orders = orderRepository.findByOrderCode("order-2024-06-28-1");
        System.out.println(orders);
        Users user = orders.getUsers();
        System.out.println(user);
        String userId = user.getUserId();

        assertEquals(10, balancesRepository.findCurrentBalance(userId).getBalanceId());
    }

    @Test
    void save() {
    }
}