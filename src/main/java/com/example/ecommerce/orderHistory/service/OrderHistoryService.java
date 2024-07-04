package com.example.ecommerce.orderHistory.service;

import com.example.ecommerce.balance.entity.BalancesHistory;
import com.example.ecommerce.balance.repository.BalancesRepository;
import com.example.ecommerce.balance.service.BalancesService;
import com.example.ecommerce.orderDemo.service.OrderService;
import com.example.ecommerce.orderHistory.dto.OrderHistoryResponseDTO;
import com.example.ecommerce.orderHistory.entity.OrderHistory;
import com.example.ecommerce.orderHistory.repository.OrderHistoryRepository;
import com.example.ecommerce.orderList.dto.OrderListRequestDTO;
import com.example.ecommerce.orderList.entity.OrderList;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.users.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
public class OrderHistoryService {

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private BalancesService balancesService;


    public OrderHistoryService(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    public List<OrderHistory> getAllOrderHistory() {
        return orderHistoryRepository.findAll();
    }

    public List<OrderHistory> getOrderHistoryByOrderCode(String orderCode) {
        return orderHistoryRepository.findByOrderCode(orderCode);
    }

    public OrderHistory addOrderInfo(OrderList orderList) {
        int quantity = orderList.getQuantity();
        Products product = orderList.getProduct();
        int stock = product.getStock();

        OrderHistory orderHistory = new OrderHistory();

        orderHistory.setOrderList(orderList);

        if(quantity >= stock) {
            orderHistory.setStatus("입금대기");
        }else {
            orderHistory.setStatus("재고부족");
        }
        orderHistory.setOrderDate(LocalDateTime.now());

        return orderHistoryRepository.save(orderHistory);

    }


    public OrderHistory addPayInfo(OrderList orderList) {
        int total = orderList.getTotal();

        Users user = orderList.getUser();
        int balance = balancesService.getCurrentBalance(user.getUserId());

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderList(orderList);

        BalancesHistory balancesHistory = new BalancesHistory();
        balancesHistory.setUsers(user);
        balancesHistory.setBalanceDatetime(LocalDateTime.now());

        if (balance >= total) {
            balancesHistory.setWithdrawalAmount(total);
            balancesHistory.setStatus("출금");
            orderHistory.setStatus("결제완료");
        } else {
            balancesHistory.setStatus("출금거절(잔액부족)");
            orderHistory.setStatus("결제실패(잔액부족)");
        }
        orderHistory.setOrderDate(LocalDateTime.now());

        balancesService.addBalanceHistory(balancesHistory);

        return orderHistory;
    }
}
