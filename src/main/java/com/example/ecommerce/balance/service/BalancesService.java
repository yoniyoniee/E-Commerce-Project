package com.example.ecommerce.balance.service;

import com.example.ecommerce.balance.dto.BalancesHistoryResponseDTO;
import com.example.ecommerce.balance.entity.BalancesHistory;
import com.example.ecommerce.balance.repository.BalancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class BalancesService {

    @Autowired
    private BalancesRepository balancesRepository;

    public BalancesService(BalancesRepository balancesRepository) {
        this.balancesRepository = balancesRepository;
    }

    // 모든 히스토리 조회
    public List<BalancesHistoryResponseDTO> getAllHistory() {
        List<BalancesHistory> history = balancesRepository.findAll();
        return history.stream().map(BalancesHistoryResponseDTO::new).collect(Collectors.toList());
    }

    // 해당 사용자 히스토리 조회
    public List<BalancesHistoryResponseDTO> getUserHistory(String userId) {
        List<BalancesHistory> history = balancesRepository.findByUserId(userId);

        return history.stream().map(BalancesHistoryResponseDTO::new).collect(Collectors.toList());
    }

    // 현재 잔액 조회
    public int getCurrentBalance(String userId) {
        BalancesHistory history = balancesRepository.findCurrentBalance(userId);

        return history != null ? history.getCurrentBalance() : 0;
    }

    // 잔액 히스토리 추가

    public BalancesHistory addBalanceHistory( BalancesHistory balancesHistory) {

        BalancesHistory latestHistory = balancesRepository.findCurrentBalance(balancesHistory.getUsers().getUserId());
        int prevBalance = latestHistory != null ? latestHistory.getCurrentBalance() : 0;
        int currentBalance = prevBalance + balancesHistory.getDepositAmount() - balancesHistory.getWithdrawalAmount();
        balancesHistory.setCurrentBalance(currentBalance);

        if (balancesHistory.getWithdrawalAmount() > 0) {
            balancesHistory.setStatus("출금");
        } else {
            balancesHistory.setStatus("입금");
        }
        return balancesRepository.save(balancesHistory);
    }


}
