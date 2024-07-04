package com.example.ecommerce.orderDemo.dto;

import com.example.ecommerce.orderDemo.entity.Orders;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.users.entity.Users;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    private Integer id;
    private String orderCode;
    private Users users;
    private LocalDateTime orderDate;
    private LocalDateTime paymentDate;
    private Products products;
    private int quantity;
    private int total;
    private String status;

    public OrderResponseDTO(Orders orders) {
        this.orderCode = orders.getOrderCode();
        this.users = orders.getUsers();
        this.orderDate = orders.getOrderDate();
        this.paymentDate = orders.getPaymentDate();
        this.quantity = orders.getQuantity();
        this.total = orders.getTotal();
        this.status = orders.getStatus();
    }

    public OrderResponseDTO(Integer id, String orderCode, Users users, LocalDateTime orderDate, LocalDateTime paymentDate, int quantity, int total, String status, Products products) {
        this.id = id;
        this.orderCode = orderCode;
        this.users = users;
        this.orderDate = orderDate;
        this.paymentDate = paymentDate;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

}


