package com.example.ecommerce.orderHistory.repository;

import com.example.ecommerce.orderHistory.entity.OrderHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository {
    List<OrderHistory> findAll();
    List<OrderHistory> findByOrderCode(String orderCode);
    OrderHistory save(OrderHistory orderHistory);

}
