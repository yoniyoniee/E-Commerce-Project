package com.example.ecommerce.product.repository;


import com.example.ecommerce.product.entity.Products;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository {

    List<Products> findAll();

    List<Products> findByCategory(String category);

    Products save(Products products);

    // List<Products> findById(String id);

    Products findById(String id);

    Products findByCode(String code);
}
