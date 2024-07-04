package com.example.ecommerce.balance;

import com.example.ecommerce.balance.repository.BalancesRepository;
import com.example.ecommerce.balance.repository.JpaBalancesRepository;
import com.example.ecommerce.balance.service.BalancesService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalanceConfig {

    private EntityManager em;

    public BalanceConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BalancesRepository balancesRepository() {
        return new JpaBalancesRepository(em);
    }

    @Bean
    public BalancesService balancesService() {
        return new BalancesService(balancesRepository());
    }
}
