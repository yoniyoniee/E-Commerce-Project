package com.example.ecommerce.users.controller;

import com.example.ecommerce.users.dto.UsersResponseDTO;
import com.example.ecommerce.users.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ApiUserController {

    private final UsersService usersService;


    public ApiUserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/api/usersList")
    public ResponseEntity<List<UsersResponseDTO>> getUsersList() {
        List<UsersResponseDTO> users = usersService.userList();
        List<UsersResponseDTO> usersResponseDTO = users.stream()
                .map(user -> new UsersResponseDTO(
                        user.getUserId(),
                        user.getUserName()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usersResponseDTO);
    }


}
