package com.example.ecommerce.orderList.service;

import com.example.ecommerce.orderList.dto.OrderListRequestDTO;
import com.example.ecommerce.orderList.dto.OrderListResponseDTO;
import com.example.ecommerce.orderList.entity.OrderList;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.product.service.ProductsService;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderListServiceTest {

    @Autowired
    private UsersService usersService;

    @Autowired
    private OrderListService orderListService;

    @Autowired
    ProductsService productsService;

    @Test
    void getAllOrderLists() {
    }

    @Test
    void getOrderListByUserId() {
    }

    @Test
    void addOrderList() {
        String userId = "2400534";
        String productCode = "BT_12";
        int quantity = 1;
        OrderListRequestDTO requestDTO = new OrderListRequestDTO();

        Products products = productsService.findByCode(productCode);
        requestDTO.setProduct(products);
        requestDTO.setQuantity(quantity);

        Users user = usersService.findById(userId);
        requestDTO.setUser(user);
        OrderListResponseDTO responseDTO = orderListService.addOrderList(userId, requestDTO);
        assertNotNull(responseDTO);
    }
}