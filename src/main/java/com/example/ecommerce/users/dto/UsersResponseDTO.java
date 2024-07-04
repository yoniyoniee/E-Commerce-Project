package com.example.ecommerce.users.dto;

import com.example.ecommerce.users.entity.Users;

public class UsersResponseDTO {
    private String userId;
    private String userName;


    public UsersResponseDTO(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UsersResponseDTO(Users user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

