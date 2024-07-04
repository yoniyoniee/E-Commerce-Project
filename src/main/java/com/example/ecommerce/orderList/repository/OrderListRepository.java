package com.example.ecommerce.orderList.repository;

import com.example.ecommerce.orderList.entity.OrderList;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderListRepository {
    List<OrderList> findAll();

    List<OrderList> findByUserId(String userId);

    OrderList save(OrderList orderList);


}
