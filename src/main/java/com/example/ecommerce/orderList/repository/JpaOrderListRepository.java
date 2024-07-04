package com.example.ecommerce.orderList.repository;

import com.example.ecommerce.orderList.entity.OrderList;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class JpaOrderListRepository implements OrderListRepository {

    EntityManager em;

    public JpaOrderListRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrderList> findAll() {
        List<OrderList> orderLists = em.createQuery("select o from OrderList o", OrderList.class).getResultList();
        return orderLists;
    }

    @Override
    public List<OrderList> findByUserId(String userId) {
        List<OrderList> orderLists = em.createQuery("select o from OrderList o where o.user.user_id = :userId", OrderList.class).getResultList();
        return orderLists;
    }

    @Override
    public OrderList save(OrderList orderList) {
        em.persist(orderList);
        return orderList;
    }
}
