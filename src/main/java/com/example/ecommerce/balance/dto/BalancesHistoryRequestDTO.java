package com.example.ecommerce.balance.dto;

import com.example.ecommerce.balance.entity.BalancesHistory;
import com.example.ecommerce.users.entity.Users;

import java.time.LocalDateTime;

public class BalancesHistoryRequestDTO {
   //rivate String userId;
    private Users users;
    private LocalDateTime balanceDatetime;
    private Integer depositAmount;
    private Integer withdrawalAmount;
    private String status;
    private int currentBalance;

    public BalancesHistoryRequestDTO(Users users, LocalDateTime balanceDatetime, int depositAmount, int withdrawalAmount, String status) {
        this.users = users;
        this.balanceDatetime = balanceDatetime;
        this.depositAmount = depositAmount;
        this.withdrawalAmount = withdrawalAmount;
        this.status = status;
        this.currentBalance = 0;

    }

    // Getters and Setters
//    public String getUserId() {
//        return userId;
//    }

//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }

    public LocalDateTime getBalanceDatetime() {
        return balanceDatetime;
    }

    public void setBalanceDatetime(LocalDateTime balanceDatetime) {
        this.balanceDatetime = balanceDatetime;
    }

    public Integer getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Integer depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Integer getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Integer withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BalancesHistory toEntity() {
        BalancesHistory balancesHistory = new BalancesHistory();
        balancesHistory.setUsers(this.users);
        balancesHistory.setBalanceDatetime(this.balanceDatetime);
        balancesHistory.setDepositAmount(this.depositAmount);
        balancesHistory.setWithdrawalAmount(this.withdrawalAmount);
        balancesHistory.setStatus(this.status);
        return balancesHistory;
    }
}
