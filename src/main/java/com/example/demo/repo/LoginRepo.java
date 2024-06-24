package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Login;

import java.util.List;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {
    List<Login> findByUsername(String username);
}
