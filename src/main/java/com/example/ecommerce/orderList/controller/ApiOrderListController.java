package com.example.ecommerce.orderList.controller;

import com.example.ecommerce.orderList.dto.OrderListRequestDTO;
import com.example.ecommerce.orderList.dto.OrderListResponseDTO;
import com.example.ecommerce.orderList.entity.OrderList;
import com.example.ecommerce.orderList.service.OrderListService;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class ApiOrderListController {

    @Autowired
    OrderListService orderListService;
    @Autowired
    private UsersService usersService;

    //주문생성
    @PostMapping("/{userId}")
    public ResponseEntity<OrderListResponseDTO> createOrder(@PathVariable String userId, @RequestBody OrderListRequestDTO orderRequest) {
        // 사용자 정보 가져오기
        Users user = usersService.findById(userId);
        orderRequest.setUser(user);

        // 주문 정보 추가하기
        try {
            OrderListResponseDTO orderResponse = orderListService.addOrderList(userId, orderRequest);
            return ResponseEntity.ok(orderResponse);
        }  catch (Exception e) {
            // 예외 로그 출력
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }



}
