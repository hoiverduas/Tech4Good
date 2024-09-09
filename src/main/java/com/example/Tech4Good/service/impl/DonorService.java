package com.example.Tech4Good.service.impl;

import com.example.Tech4Good.entities.Donor;
import com.example.Tech4Good.entities.User;
import com.example.Tech4Good.repository.IDonorRepository;
import com.example.Tech4Good.service.IDonorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService implements IDonorService {

    private final IDonorRepository donorRepository;

    public DonorService(IDonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public Donor save(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Override
    public Donor findById(Long id) {
        return donorRepository.findById(id).get();
    }

    @Override
    public void deleteUserById(Long id) {
        donorRepository.deleteById(id);
    }

    @Override
    public List<Donor> findByUser(User user) {
        return donorRepository.findByUser(user);
    }
}
