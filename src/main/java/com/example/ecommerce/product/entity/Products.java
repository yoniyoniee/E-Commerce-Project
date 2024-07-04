package com.example.ecommerce.product.entity;

import jakarta.persistence.*;

@Table(name = "PRODUCTS")
@Entity
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    private String category;

    private Integer price;

    private Integer stock;


    //@PrePersist // 엔티티가 영속성 컨텍스트에 추가되기 전, seq 값이 아직 생성되지 않은 상태
    @PostPersist //엔티티가 데이터베이스에 저장된 후, seq 값이 생성된 상태
    public void postPersist() {

        this.productCode = generateCustomId();

    }

    public Products() {}

    public Products(String productCode, String productName, String category, Integer price, Integer stock) {

        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;

    }

    // product_id 형식 자동 생성
    private String generateCustomId() {
        if ("top".equals(this.category)) {
            return "TP_" + seq;
        } else if ("bottom".equals(this.category)) {
            return "BT_" + seq;
        } else {
            return "OT_" + seq;
        }
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productId) {
        this.productCode = productId;
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
