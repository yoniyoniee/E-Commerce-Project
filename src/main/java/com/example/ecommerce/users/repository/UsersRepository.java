package com.example.ecommerce.users.repository;


import com.example.ecommerce.users.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository {
    List<Users> findAll();

    //List<Users> findById(String id);

    Users findById(String id);

    List<Users> findByUsername(String username);

}
