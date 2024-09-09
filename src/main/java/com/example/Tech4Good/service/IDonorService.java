package com.example.Tech4Good.service;

import com.example.Tech4Good.entities.Donor;
import com.example.Tech4Good.entities.User;

import java.util.List;

public interface IDonorService {

    Donor save(Donor donor);
    List<Donor> findAll();
    Donor findById(Long id);
    void deleteUserById(Long id);
    List<Donor> findByUser(User user);
}
