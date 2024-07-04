package com.example.ecommerce.product.service;

import com.example.ecommerce.product.dto.ProductsResonseDto;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.product.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<ProductsResonseDto> getAllProducts() {

        List<Products> products = productsRepository.findAll();

        return products.stream().map(ProductsResonseDto::new).collect(Collectors.toList());
    }

    public Products registerProduct(Products products) {

        return productsRepository.save(products);
    }

    public List<ProductsResonseDto>getProductsByCategory(String category) {
        List<Products> products = productsRepository.findByCategory(category);

        return products.stream().map(ProductsResonseDto::new).collect(Collectors.toList());
    }

//    public List<ProductsResonseDto> findById(String id) {
//        List<Products> products = productsRepository.findById(id);
//        return products.stream().map(ProductsResonseDto::new).collect(Collectors.toList());
//    }

    public Products findById(String id) {
        Products products = productsRepository.findById(id);
        return products;
    }

    public Products findByCode(String code) {
        Products products = productsRepository.findByCode(code);
        return products;
    }
}
