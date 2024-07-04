package com.example.ecommerce.salesAmount.entity;

import com.example.ecommerce.product.entity.Products;
import jakarta.persistence.*;

@Entity
public class SalesAmount {

    @Id
    @Column(name = "sales_amount_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesAmountId;


    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName = "product_code")
    private Products product;

    @Column(name = "category")
    private String category;

    @Column(name = "sales_amount")
    private Integer salesAmount;

    public int getSalesAmountId() {
        return salesAmountId;
    }

    public void setSalesAmountId(int salesAmountId) {
        this.salesAmountId = salesAmountId;
    }



    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }
}
