package com.example.ecommerce.orderList.entity;

import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.users.entity.Users;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERLIST")
public class OrderList {


    @Column(name = "order_code")
    private String orderCode;

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName = "product_code")
    private Products product;

    private Integer quantity;

    private Integer total;

    public OrderList() {}

    public OrderList(String orderCode, Users user, Products product, Integer quantity, Integer total) {
        this.orderCode = orderCode;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    @PostPersist
    public void postPersist() {
        this.orderCode = generateCustomOrderCode();
    }

    private String generateCustomOrderCode() {

        return "Order-" + LocalDate.now() + "-" + this.seq;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
