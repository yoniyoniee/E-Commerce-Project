package com.example.ecommerce.orderDemo.repository;

import com.example.ecommerce.orderDemo.entity.Orders;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaOrderRepository implements OrderRepository {

    EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Orders> findAll() {
        List<Orders> orders = em.createQuery("select o from Orders o", Orders.class).getResultList();

        return orders;
    }

    @Override
    public Orders findByOrderCode(String orderCode) {
        Orders orders = em.createQuery("select o from Orders o where o.orderCode = :orderCode", Orders.class)
                .setParameter("orderCode", orderCode)
                .getSingleResult();

        return orders;
    }

    @Override
    public Orders save(Orders orders) {
        em.persist(orders);
        return orders;
    }


}
