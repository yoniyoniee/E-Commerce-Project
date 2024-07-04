package com.example.ecommerce.balance.service;

import com.example.ecommerce.balance.dto.BalancesHistoryResponseDTO;
import com.example.ecommerce.balance.entity.BalancesHistory;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BalancesServiceTest {
    @Autowired BalancesService balancesService;
    @Autowired
    UsersService usersService;

    @Test
    void getAllHistory() {
        List<BalancesHistoryResponseDTO> histories = balancesService.getAllHistory();
        assertEquals(7, histories.size());
    }

    @Test
    void getUserHistory() {
        String userId = "2400534";
        List<BalancesHistoryResponseDTO> histories = balancesService.getUserHistory(userId);
        assertEquals(7, histories.size());
    }

    @Test
    void getCurrentBalance() {
        String userId = "2400534";
        int currentBalance = balancesService.getCurrentBalance(userId);
        //assertEquals(26000, histories.get(0).getCurrentBalance());
        assertEquals(26000, currentBalance);
    }

    @Test
    void addHistory() {
        String userId = "2400534";
        int withdrawalAmount = 10000;

        Users user = usersService.findById(userId);

        BalancesHistory newHistory = new BalancesHistory();
        newHistory.setUsers(user);
        newHistory.setWithdrawalAmount(withdrawalAmount);

        //balancesService.addBalanceHistory(userId, newHistory);

        assertEquals(36000, newHistory.getCurrentBalance());
    }
}