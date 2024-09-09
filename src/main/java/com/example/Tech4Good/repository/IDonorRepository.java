package com.example.Tech4Good.repository;

import com.example.Tech4Good.entities.Donor;
import com.example.Tech4Good.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonorRepository extends JpaRepository<Donor,Long> {
    List<Donor> findByUser(User user);
}
