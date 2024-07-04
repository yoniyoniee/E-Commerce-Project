package com.example.ecommerce.product.repository;

import com.example.ecommerce.product.entity.Products;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaProductsRepository implements ProductsRepository {

    private EntityManager em;

    public JpaProductsRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Products> findAll() {

        List<Products> productsList = em.createQuery("select e from Products e", Products.class).getResultList();

        return productsList;
    }

    @Override
    public List<Products> findByCategory(String category) {
        List<Products> list = em.createQuery("select e from Products e where e.category = :catecgory", Products.class).setParameter("catecgory", category).getResultList();

        return list;
    }

    @Override
    public Products save(Products products) {

        em.persist(products);

        return products;
    }

//    @Override
//    public List<Products> findById(String id) {
//        List<Products> list = em.createQuery("select e from Products e where e.id = :id", Products.class).setParameter("id", id).getResultList();
//
//        return list;
//    }

    @Override
    public Products findById(String id) {
        Products list = em.createQuery("select e from Products e where e.id = :id", Products.class).setParameter("id", id).getSingleResult();

        return list;
    }

    @Override
    public Products findByCode(String code) {
        Products product = em.createQuery("select e from Products e where e.productCode = :code", Products.class).setParameter("code", code).getSingleResult();
        return product;
    }



}
