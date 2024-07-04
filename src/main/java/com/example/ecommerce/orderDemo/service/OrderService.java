package com.example.ecommerce.orderDemo.service;

import com.example.ecommerce.balance.entity.BalancesHistory;
import com.example.ecommerce.balance.repository.BalancesRepository;
import com.example.ecommerce.orderDemo.entity.Orders;
import com.example.ecommerce.orderDemo.repository.OrderRepository;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.product.repository.ProductsRepository;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BalancesRepository balancesRepository;
    @Autowired
    private ProductsRepository productsRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders registerOrder(Orders orders) {

        Products product = orders.getProducts();
        int stock = product.getStock();

        if (stock < orders.getQuantity()) {
            throw new RuntimeException("재고부족");
        } else {
            return orderRepository.save(orders);
        }

    }

    public Orders addPayemntInfo(String orderCode, LocalDateTime paymentDate) {
        Orders orders = orderRepository.findByOrderCode(orderCode);
        System.out.println(orders);
        Users user = orders.getUsers();
        System.out.println(user);
        System.out.println("user.getUserId()="+user.getUserId());
        BalancesHistory balancesHistory = balancesRepository.findCurrentBalance(user.getUserId());
        int balance = balancesHistory.getCurrentBalance();

        if (balance < orders.getTotal()) {
            orders.setStatus("결제실패(잔액부족)");
            throw new RuntimeException("잔액 : " + balance + "결제금액 : " + orders.getTotal() + "=>" + "잔액부족");
        } else if (balance >= orders.getTotal()) {
            return orderRepository.save(orders);
        }else if (orders != null) {
            orders.setPaymentDate(paymentDate);
            return orderRepository.save(orders);
        } else {
            throw new RuntimeException("Order not found");
        }

    }

    public Orders findByOrderCode(String orderCode) {
        Orders orders = orderRepository.findByOrderCode(orderCode);
        return orders;
    }

}
