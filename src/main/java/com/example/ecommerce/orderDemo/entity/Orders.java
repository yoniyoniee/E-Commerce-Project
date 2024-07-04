package com.example.ecommerce.orderDemo.entity;

import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.users.entity.Users;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Column(name = "order_code", unique = true)
    private String orderCode;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users users;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName = "product_code")
    private Products products;

    @Column(name = "quantity")
    private int quantity;

    private int total;

    private String status;

    public Orders() {
    }

    public Orders(Integer seq, String orderCode, Users users, LocalDateTime orderDate, LocalDateTime paymentDate) {
        this.seq = seq;
        this.orderCode = orderCode;
        this.users = users;
        this.orderDate = orderDate;
        this.paymentDate = paymentDate;
    }

    @PrePersist
    public void onPrePersist() {
        this.orderDate = LocalDateTime.now();
    }

    @PostPersist
    public void postPersist() {
        this.orderCode = generateCustomOrderCode();
    }

    private String generateCustomOrderCode() {

        return "order-" + LocalDate.now() + "-" + this.seq;
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


    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
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
