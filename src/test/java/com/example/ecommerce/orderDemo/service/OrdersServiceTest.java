package com.example.ecommerce.orderDemo.service;

import com.example.ecommerce.orderDemo.entity.Orders;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.product.service.ProductsService;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdersServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ProductsService productsService;

    @Test
    void getAllOrders() {
        List<Orders> orders = orderService.getAllOrders();
        assertEquals(0, orders.size());
    }

    @Test
    @Commit
    void registerOrder() {
        String userId = "2400534";
        String productCode = "BT_11";
        int quantity = 1;
        int total;

        Users user = usersService.findById(userId);
        Products product = productsService.findByCode(productCode);

        total = quantity * product.getPrice();

        Orders order = new Orders();
        order.setUsers(user);
        order.setProducts(product);
        order.setQuantity(quantity);
        order.setTotal(total);
        order.setStatus("입금전");

        orderService.registerOrder(order);

        List<Orders> orders = orderService.getAllOrders();

        assertEquals(1,orders.size());

        // 새로운 주문 생성
    }

    @Test
    void addPayemntInfo() {
        String orderCode = "order-2024-06-28-1";
        LocalDateTime paymentDate = LocalDateTime.now();

        Orders order = orderService.addPayemntInfo(orderCode, paymentDate);

        List<Orders> orders = orderService.getAllOrders();

        assertEquals(1,orders.size());

    }
}