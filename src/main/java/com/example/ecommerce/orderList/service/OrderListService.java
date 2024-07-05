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

        // 사용자 정보 가져오기
        Users user = usersService.findById(userId);
        orderRequest.setUser(user);
        OrderList orderList = orderRequest.toEntity();

        // 제품 정보 가져오기
        Products product = productsService.findByCode(orderRequest.getProductCode());
        orderList.setProduct(product);
        orderList.setTotal(product.getPrice() * orderRequest.getQuantity());

        // OrderList 엔티티 저장
        OrderList savedOrderList = orderListRepository.save(orderList);

        // orderList 저장된 후 OrderHistory 생성 및 저장
        orderHistoryService.addOrderInfo(savedOrderList);

        return new OrderListResponseDTO(savedOrderList);
    }


}
