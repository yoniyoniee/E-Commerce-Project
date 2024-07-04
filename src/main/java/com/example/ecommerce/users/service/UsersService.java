package com.example.ecommerce.users.service;

import com.example.ecommerce.users.dto.UsersResponseDTO;
import com.example.ecommerce.users.entity.Users;
import com.example.ecommerce.users.repository.UsersRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class UsersService {
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // 모든 사용자 리스트 반환
    public List<UsersResponseDTO> userList() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map(UsersResponseDTO::new).collect(Collectors.toList());
    }

    // 해당 사용자 정보 반환
    public List<UsersResponseDTO> findByName(String name) {
        List<Users> user = usersRepository.findByUsername(name);

        return user.stream().map(UsersResponseDTO::new).collect(Collectors.toList());
    }

//    public List<UsersResponseDTO> findById(String id) {
//        List<Users> user = usersRepository.findById(id);
//        return user.stream().map(UsersResponseDTO::new).collect(Collectors.toList());
//    }

    public Users findById(String id) {
        Users user = usersRepository.findById(id);
        return user;
    }

}
