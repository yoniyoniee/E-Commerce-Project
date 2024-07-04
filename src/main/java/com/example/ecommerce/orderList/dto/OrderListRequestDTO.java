package com.example.ecommerce.orderList.dto;

import com.example.ecommerce.orderList.entity.OrderList;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.users.entity.Users;

public class OrderListRequestDTO {
    private String orderCode;
    private String productCode;
    private Integer quantity;
    private Users user;

    public OrderListRequestDTO() {}

    public OrderListRequestDTO(Users user, String orderCode, String productCode, Integer quantity) {
        this.orderCode = orderCode;
        this.productCode = productCode;
        this.quantity = quantity;
//        this.seq = seq;
        this.user = user;
//        this.product = product;
//        this.quantity = quantity;
//        this.total = total;
    }


    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

//    public Integer getSeq() {
//        return seq;
//    }
//
//    public void setSeq(Integer seq) {
//        this.seq = seq;
//    }
//
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
//
//    public Products getProduct() {
//        return product;
//    }
//
//    public void setProduct(Products product) {
//        this.product = product;
//    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

//    public Integer getTotal() {
//        return total;
//    }
//
//    public void setTotal(Integer total) {
//        this.total = total;
//    }

    public OrderList toEntity() {
        OrderList orderList = new OrderList();
        orderList.setOrderCode(orderCode);
//        orderList.setSeq(seq);
        orderList.setUser(user);
//        orderList.setProduct(product);
        orderList.setQuantity(quantity);
//        orderList.setTotal(total);
        return orderList;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
