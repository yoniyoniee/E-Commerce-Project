package com.example.ecommerce.orderHistory.service;

import com.example.ecommerce.orderHistory.entity.OrderHistory;
import com.example.ecommerce.orderList.entity.OrderList;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.product.service.ProductsService;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderHistoryServiceTest {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private OrderHistoryService orderHistoryService;

    @Test
    void getAllOrderHistory() {
    }

    @Test
    void getOrderHistoryByOrderCode() {
    }

    @Test
    @Commit
    void addOrderInfo() {
        Users user = usersService.findById("2400534");
        OrderList orderList = new OrderList();
        orderList.setOrderCode("Order-2024-07-05-38");
        orderList.setUser(user);
        orderList.setQuantity(1);
        Products product = productsService.findByCode("BT_12");
        orderList.setProduct(product);

        OrderHistory orderHistory = orderHistoryService.addOrderInfo(orderList);
        assertNotNull(orderHistory);
    }

    @Test
    void addPayInfo() {
    }
}