package com.example.ecommerce.users.repository;

import com.example.ecommerce.users.entity.Users;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaUsersRepository implements UsersRepository{

    private final EntityManager em;

    public JpaUsersRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Users> findAll() {

        List<Users> users = em.createQuery("select e from Users e", Users.class).getResultList();

        return users;
    }

//    @Override
//    public List<Users> findById(String id) {
//
//        List<Users> user = em.createQuery("select e from Users e where e.user_id = :id", Users.class).setParameter("id", id).getResultList();
//
//        return user;
//    }

    @Override
    public Users findById(String id) {

        Users user = em.createQuery("select e from Users e where e.user_id = :id", Users.class).setParameter("id", id).getSingleResult();

        return user;
    }

    @Override
    public List<Users> findByUsername(String username) {
        List<Users> user = em.createQuery("select e from Users e where e.user_name = :username", Users.class).setParameter("username", username).getResultList();

        return user;
    }
}
