package com.example.ecommerce.balance.repository;

import com.example.ecommerce.balance.entity.BalancesHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalancesRepository {

    // 모든 잔액 히스토리 조회
    List<BalancesHistory> findAll();

    // 해당 사용자 잔액 히스토리 조회
    List<BalancesHistory> findByUserId(String userId);

    // 현재 잔액 조회
    BalancesHistory findCurrentBalance(String userId);

    // 잔액 히스토리 생성
    BalancesHistory save( BalancesHistory balancesHistory);
}
