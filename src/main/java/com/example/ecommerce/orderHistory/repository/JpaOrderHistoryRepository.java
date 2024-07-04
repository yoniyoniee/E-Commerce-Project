package com.example.ecommerce.orderHistory.repository;

import com.example.ecommerce.orderHistory.entity.OrderHistory;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class JpaOrderHistoryRepository implements OrderHistoryRepository {

    EntityManager em;

    public JpaOrderHistoryRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrderHistory> findAll() {
        List<OrderHistory> orderHistoryList = em.createQuery("select e from OrderHistory e", OrderHistory.class).getResultList();
        return orderHistoryList;
    }

    @Override
    public List<OrderHistory> findByOrderCode(String orderCode) {
        List<OrderHistory> orderHistoryList = em.createQuery("select e from OrderHistory e where e.orderList.orderCode = :orderCode", OrderHistory.class)
                .setParameter("orderCode", orderCode)
                .getResultList();

        return orderHistoryList;
    }

    @Override
    public OrderHistory save(OrderHistory orderHistory) {
        em.persist(orderHistory);
        return orderHistory;
    }
}
