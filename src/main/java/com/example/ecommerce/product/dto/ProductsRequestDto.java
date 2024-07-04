package com.example.ecommerce.product.dto;

import com.example.ecommerce.product.entity.Products;
import jakarta.persistence.Column;

public class ProductsRequestDto {

    @Column(name = "product_code")
    private String productCode;
    private Integer seq;

    @Column(name = "product_Name")
    private String productName;
    private String category;
    private Integer price;
    private Integer stock;

    public ProductsRequestDto(String productCode, Integer seq, String productName, String category, Integer price, Integer stock) {
        this.productCode = productCode;
        this.seq = seq;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
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

    public Products toEntity() {
        Products entity = new Products();
        entity.setProductName(this.productName);
        entity.setCategory(this.category);
        entity.setPrice(this.price);
        entity.setStock(this.stock);

        return entity;
    }
}
