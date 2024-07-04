package com.example.ecommerce.orderDemo.repository;

import com.example.ecommerce.orderDemo.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {
    List<Orders> findAll();

    Orders findByOrderCode(String orderCode);

    Orders save(Orders orders);


}
