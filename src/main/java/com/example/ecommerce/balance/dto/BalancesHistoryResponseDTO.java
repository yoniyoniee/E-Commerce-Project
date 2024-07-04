package com.example.ecommerce.balance.dto;

import com.example.ecommerce.balance.entity.BalancesHistory;
import com.example.ecommerce.users.entity.Users;

import java.time.LocalDateTime;

public class BalancesHistoryResponseDTO {
    private int balanceId;
    Users users;
    //private String userId;
    private LocalDateTime balanceDatetime;
    private Integer depositAmount;
    private Integer withdrawalAmount;
    private String status;
    private int currentBalance;

    public BalancesHistoryResponseDTO(BalancesHistory balancesHistory) {
        this.balanceId = balancesHistory.getBalanceId();
        this.users = balancesHistory.getUsers();
        //this.userId = balancesHistory.getUserId();
        this.balanceDatetime = balancesHistory.getBalanceDatetime();
        this.depositAmount = balancesHistory.getDepositAmount();
        this.withdrawalAmount = balancesHistory.getWithdrawalAmount();
        this.status = balancesHistory.getStatus();
        this.currentBalance = balancesHistory.getCurrentBalance();
    }

    public BalancesHistoryResponseDTO(LocalDateTime balanceDatetime, int balanceId, int currentBalance, String status, Users users, Integer depositAmount, Integer withdrawalAmount) {
        this.balanceDatetime = balanceDatetime;
        this.balanceId = balanceId;
        this.currentBalance = currentBalance;
        this.status = status;
        this.users = users;
        this.depositAmount = depositAmount;
        this.withdrawalAmount = withdrawalAmount;
    }


    // Getters and Setters
    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }


    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }

//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

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
}
