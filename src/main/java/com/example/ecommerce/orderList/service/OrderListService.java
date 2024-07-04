package com.example.ecommerce.orderList.service;

import com.example.ecommerce.orderHistory.entity.OrderHistory;
import com.example.ecommerce.orderHistory.service.OrderHistoryService;
import com.example.ecommerce.orderList.dto.OrderListRequestDTO;
import com.example.ecommerce.orderList.dto.OrderListResponseDTO;
import com.example.ecommerce.orderList.entity.OrderList;
import com.example.ecommerce.orderList.repository.OrderListRepository;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.product.service.ProductsService;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.service.UsersService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Transactional
public class OrderListService {

    @Autowired
    private OrderListRepository orderListRepository;
    @Autowired
    private OrderHistoryService orderHistoryService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ProductsService productsService;

    public OrderListService(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    public List<OrderList> getAllOrderLists() {
        return this.orderListRepository.findAll();
    }

    public List<OrderList> getOrderListByUserId(String userId) {
        return this.orderListRepository.findByUserId(userId);
    }

    public OrderListResponseDTO addOrderList(String userId, OrderListRequestDTO orderRequest) {


        Users user = usersService.findById(userId);
        orderRequest.setUser(user);
        OrderList orderList = orderRequest.toEntity();
        Products product = productsService.findByCode(orderRequest.getProductCode());
        orderList.setProduct(product);
        orderList.setTotal(product.getPrice() * orderRequest.getQuantity());
        OrderList savedOrderList = orderListRepository.save(orderList);
        orderHistoryService.addOrderInfo(savedOrderList);
        return new OrderListResponseDTO(savedOrderList);
    }


}
