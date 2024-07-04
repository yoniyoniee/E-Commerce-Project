package com.example.ecommerce.orderHistory.entity;

import com.example.ecommerce.orderList.entity.OrderList;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERHISTORY")
public class OrderHistory {


    @Column(name = "order_history_code")
    private String orderHistoryCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seq;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "order_code", referencedColumnName = "order_code")
    private OrderList orderList;

    private String status;

    public OrderHistory(String orderHistoryCode, Integer seq, LocalDateTime orderDate, OrderList orderList, String status) {
        this.orderHistoryCode = orderHistoryCode;
        this.seq = seq;
        this.orderDate = orderDate;
        this.orderList = orderList;
        this.status = status;
    }

    public OrderHistory() {}

    @PrePersist
    public void onPrePersist() {
        this.orderDate = LocalDateTime.now();
    }

    @PostPersist
    public void postPersist() {
        this.orderHistoryCode = generateCustomOrderCode();
    }

    private String generateCustomOrderCode() {

        return "OH-" + LocalDate.now() + "-" + this.seq;
    }

    public String getOrderHistoryCode() {
        return orderHistoryCode;
    }

    public void setOrderHistoryCode(String orderHistoryCode) {
        this.orderHistoryCode = orderHistoryCode;
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
