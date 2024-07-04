package com.example.ecommerce.orderList.dto;

import com.example.ecommerce.orderList.entity.OrderList;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.users.entity.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderListResponseDTO {
    private String orderCode;
    private Integer seq;
    private Users user;
    private Products product;
    private Integer quantity;
    private Integer total;

    public OrderListResponseDTO() {}

    public OrderListResponseDTO(OrderList orderList) {
        this.orderCode = orderList.getOrderCode();
        this.seq = orderList.getSeq();
        this.user = orderList.getUser();
        this.product = orderList.getProduct();
        this.quantity = orderList.getQuantity();
        this.total = orderList.getTotal();
    }

    public OrderListResponseDTO(String orderCode, Integer seq, Users user, Products product, Integer quantity, Integer total) {
        this.orderCode = orderCode;
        this.seq = seq;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
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
