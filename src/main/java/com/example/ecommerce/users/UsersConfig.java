package com.example.ecommerce.users;

import com.example.ecommerce.users.repository.JpaUsersRepository;
import com.example.ecommerce.users.repository.UsersRepository;
import com.example.ecommerce.users.service.UsersService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersConfig {

    private EntityManager em;

    @Autowired
    public UsersConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UsersRepository usersRepository() {
        return new JpaUsersRepository(em);
    }

    @Bean
    public UsersService usersService() {
        return new UsersService(usersRepository());
    }


}
