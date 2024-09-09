package com.example.Tech4Good.service;

import com.example.Tech4Good.entities.User;

import java.util.List;

public interface IUserService {

    User save(User user);
    List<User> findAll();
    User findById(Long id);
    void deleteUserById(Long id);
}
