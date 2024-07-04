package com.example.ecommerce.salesAmount.repository;

import com.example.ecommerce.salesAmount.entity.SalesAmount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesAmountRepository {

    List<SalesAmount> findAll();

    List<SalesAmount> sortingDescending(List<SalesAmount> salesAmounts);

    List<SalesAmount> getSalesAmountByProductCode(String productCode);

    SalesAmount addSalesAmount(SalesAmount salesAmount);
}
