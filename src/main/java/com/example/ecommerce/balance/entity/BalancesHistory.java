package com.example.ecommerce.balance.entity;

import com.example.ecommerce.users.entity.Users;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Table(name="BALANCESHISTORY")
@Entity
public class BalancesHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_id")
    private int balanceId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users users;

    @Column(name = "balance_datetime")
    private LocalDateTime balanceDatetime;

    @Column(name = "deposit_amount")
    private Integer depositAmount = 0;

    @Column(name = "withdrawal_amount")
    private Integer withdrawalAmount = 0;

    @Column(name = "status")
    private String status;

    @Column(name = "current_balance")
    private  int currentBalance;

    @PrePersist
    public void prePersist() {
        this.balanceDatetime = LocalDateTime.now(); // 현재 시간으로 설정
    }

    public BalancesHistory() {}

    public BalancesHistory(Users users, LocalDateTime balanceDatetime, int depositAmount, int withdrawalAmount, String status, int currentBalance) {
        this.users = users;
        this.balanceDatetime = balanceDatetime;
        this.depositAmount = depositAmount;
        this.withdrawalAmount = withdrawalAmount;
        this.status = status;
        this.currentBalance = currentBalance;
    }


    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balance_id) {
        this.balanceId = balance_id;
    }


    public LocalDateTime getBalanceDatetime() {
        return balanceDatetime;
    }

    public void setBalanceDatetime(LocalDateTime balance_datetime) {
        this.balanceDatetime = balance_datetime;
    }

    public Integer getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Integer deposit_amount) {
        this.depositAmount = deposit_amount != null ? deposit_amount : 0;
    }

    public Integer getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Integer withdraw_amount) {
        this.withdrawalAmount = withdraw_amount != null ? withdraw_amount : 0;
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

    public void setCurrentBalance(int current_balance) {
        this.currentBalance = current_balance;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
