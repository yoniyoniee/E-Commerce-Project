package com.example.ecommerce.salesAmount.repository;

import com.example.ecommerce.salesAmount.entity.SalesAmount;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaSalesAmountRepository implements SalesAmountRepository {

    private EntityManager em;

    public JpaSalesAmountRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<SalesAmount> findAll() {
        List<SalesAmount> list = em.createQuery("select e from SalesAmount e", SalesAmount.class).getResultList();
        return list;
    }

    @Override
    public List<SalesAmount> sortingDescending(List<SalesAmount> salesAmounts) {

        return List.of();
    }

    @Override
    public List<SalesAmount> getSalesAmountByProductCode(String productCode) {
        List<SalesAmount> list = em.createQuery("select e from SalesAmount e where e.product.productCode = :productCode", SalesAmount.class)
                .setParameter("productCode", productCode)
                .getResultList();

        return list;
    }

    @Override
    public SalesAmount addSalesAmount(SalesAmount salesAmount) {
        em.persist(salesAmount);
        return salesAmount;
    }
}
