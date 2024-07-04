package com.example.ecommerce.product.dto;

import com.example.ecommerce.product.entity.Products;
import jakarta.persistence.Column;

public class ProductsResonseDto {

    @Column(name = "product_code")
    private String productCode;
    private Integer seq;
    @Column(name = "product_name")
    private String productName;
    private String category;
    private Integer price;
    private Integer stock;

    public ProductsResonseDto(String productCode, Integer seq, String productName, String category, Integer price, Integer stock) {
        this.productCode = productCode;
        this.seq = seq;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public ProductsResonseDto(Products products) {
        this.productCode = products.getProductCode();
        this.seq = products.getSeq();
        this.productName = products.getProductName();
        this.category = products.getCategory();
        this.price = products.getPrice();
        this.stock = products.getStock();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
