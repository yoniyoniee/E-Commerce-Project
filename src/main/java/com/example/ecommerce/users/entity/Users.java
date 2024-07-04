package com.example.ecommerce.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    private String user_id;

    private String user_name;


    public Users() {

    }


    public Users(String user_id, String userName, int balance) {
        this.user_id = user_id;
        this.user_name = userName;
    }


    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String userName) {
        this.user_name = userName;
    }
}
