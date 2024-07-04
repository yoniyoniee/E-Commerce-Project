package com.example.ecommerce.orderDemo.dto;

import com.example.ecommerce.orderDemo.entity.Orders;
import com.example.ecommerce.users.entity.Users;

import java.time.LocalDateTime;

public class OrderRequestDTO {
    private Integer id;
    private String orderCode;
    private Users users;
    private LocalDateTime orderDate;
    private LocalDateTime paymentDate;
    private int quantity;
    private int total;
    private String status;

    public OrderRequestDTO(Orders orders) {
        this.orderCode = orders.getOrderCode();
        this.users = orders.getUsers();
        this.orderDate = orders.getOrderDate();
        this.paymentDate = orders.getPaymentDate();
        this.quantity = orders.getQuantity();
        this.total = orders.getTotal();
        this.status = orders.getStatus();

    }

    public Orders toEntity() {
        Orders orders = new Orders();
        orders.setOrderCode(orderCode);
        orders.setOrderDate(orderDate);
        orders.setPaymentDate(paymentDate);
        orders.setQuantity(quantity);
        orders.setTotal(total);
        orders.setStatus(status);
        return orders;
    }
}
