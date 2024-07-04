package com.example.ecommerce.users.service;

import com.example.ecommerce.users.dto.UsersResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersServiceTest {
    @Autowired UsersService usersService;

    @Test
    void userList() {
        List<UsersResponseDTO> users = usersService.userList();
        assertEquals(10, users.size());
    }

    @Test
    void findByName() {
    }
}