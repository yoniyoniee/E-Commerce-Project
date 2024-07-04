package com.example.ecommerce.balance.repository;

import com.example.ecommerce.balance.entity.BalancesHistory;
import jakarta.persistence.EntityManager;

import java.sql.SQLOutput;
import java.util.List;

public class JpaBalancesRepository implements BalancesRepository {

    private final EntityManager em;

    public JpaBalancesRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<BalancesHistory> findAll() {

        List<BalancesHistory> histories = em.createQuery("select e from BalancesHistory e", BalancesHistory.class).getResultList();
        return histories;
    }

    @Override
    public List<BalancesHistory> findByUserId(String userId) {

        List<BalancesHistory> histories = em.createQuery("select e from BalancesHistory e where e.users.user_id = :userId", BalancesHistory.class)
                .setParameter("userId", userId)
                .getResultList();
        return histories;
    }

    @Override
    public BalancesHistory findCurrentBalance(String userId) {

        BalancesHistory current = em.createQuery("select e from BalancesHistory e where e.users.user_id = :userId ORDER BY e.balanceId DESC", BalancesHistory.class)
                .setParameter("userId", userId)
                .setMaxResults(1)
                .getSingleResult();

        if (current == null) {
            System.out.println("No BalancesHistory found for userId: " + userId);
            return null;
        }
        return current;
    }

    @Override
    public BalancesHistory save(BalancesHistory balancesHistory) {

        em.persist(balancesHistory);
        return balancesHistory;
    }
}
