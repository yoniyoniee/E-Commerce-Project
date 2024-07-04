package com.example.ecommerce.balance.controller;

import com.example.ecommerce.balance.dto.BalancesHistoryRequestDTO;
import com.example.ecommerce.balance.dto.BalancesHistoryResponseDTO;
import com.example.ecommerce.balance.entity.BalancesHistory;
import com.example.ecommerce.balance.service.BalancesService;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiBalancesHistoryController {
    private final BalancesService balancesService;
    private final UsersService usersService;

    public ApiBalancesHistoryController(BalancesService balancesService, UsersService usersService) {
        this.balancesService = balancesService;
        this.usersService = usersService;
    }

    // 모든 잔액 리스트 조회
    @GetMapping("/api/balances-history-list")
    public ResponseEntity<List<BalancesHistoryResponseDTO>> getBalancesHistoryList() {
        List<BalancesHistoryResponseDTO> balances = balancesService.getAllHistory();
        List<BalancesHistoryResponseDTO> balancesHistoryResponseDTO = balances.stream()
                .map(balance -> new BalancesHistoryResponseDTO(
                        balance.getBalanceDatetime(),
                        balance.getBalanceId(),
                        balance.getCurrentBalance(),
                        balance.getStatus(),
//                        balance.getUserId(),
                        balance.getUsers(),
                        balance.getDepositAmount(),
                        balance.getWithdrawalAmount()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(balancesHistoryResponseDTO);

    }

    // 특정 사용자 잔액 리스트 조회
    @GetMapping("/api/balances-history-list/{userId}")
    public ResponseEntity<List<BalancesHistoryResponseDTO>> getUserBalancesHistoryList(@PathVariable String userId) {
        List<BalancesHistoryResponseDTO> balances = balancesService.getUserHistory(userId);
        List<BalancesHistoryResponseDTO> balancesHistoryResponseDTO = balances.stream()
                .map(balance -> new BalancesHistoryResponseDTO(
                        balance.getBalanceDatetime(),
                        balance.getBalanceId(),
                        balance.getCurrentBalance(),
                        balance.getStatus(),
                        //balance.getUserId(),
                        balance.getUsers(),
                        balance.getDepositAmount(),
                        balance.getWithdrawalAmount()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(balancesHistoryResponseDTO);
    }


    // 특정 사용자 현재 잔액 조회
    @GetMapping("/api/current-balance/{userId}")
    public ResponseEntity<Integer> getUserCurrent(@PathVariable String userId) {
        int balances = balancesService.getCurrentBalance(userId);

        return ResponseEntity.ok(balances);
    }

    @PostMapping("/api/balance/{userId}/charge")
    public ResponseEntity<BalancesHistoryResponseDTO> addBalanceHistory(@PathVariable String userId, @RequestBody BalancesHistoryRequestDTO request) {
        //request.setUserId(userId);
        Users user = usersService.findById(userId);
        request.setUsers(user);
        BalancesHistory savedHistory = balancesService.addBalanceHistory(request.toEntity());
        BalancesHistoryResponseDTO response = new BalancesHistoryResponseDTO(savedHistory);
        return ResponseEntity.ok(response);
    }
}
