package com.example.ecommerce.orderHistory.dto;

import com.example.ecommerce.orderHistory.entity.OrderHistory;
import com.example.ecommerce.orderList.entity.OrderList;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class OrderHistoryResponseDTO {
    private String orderHistoryCode;
    private Integer seq;
    private LocalDateTime orderDate;
    private OrderList orderList;
    private String status;

    public OrderHistoryResponseDTO(OrderHistory orderHistory) {
        this.orderHistoryCode = orderHistory.getOrderHistoryCode();
        this.orderDate = orderHistory.getOrderDate();
        this.orderList = orderHistory.getOrderList();
        this.status = orderHistory.getStatus();
    }

    public OrderHistoryResponseDTO(String orderHistoryCode, Integer seq, LocalDateTime orderDate, OrderList orderList, String status) {
        this.orderHistoryCode = orderHistoryCode;
        this.seq = seq;
        this.orderDate = orderDate;
        this.orderList = orderList;
        this.status = status;
    }

    public String getOrderHistoryCode() {
        return orderHistoryCode;
    }

    public void setOrderHistoryCode(String orderHistoryCode) {
        this.orderHistoryCode = orderHistoryCode;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
