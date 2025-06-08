package com.example.Thymeleaf_demo.Repository;

import com.example.Thymeleaf_demo.Models.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GateWay extends JpaRepository< users,Long> {
    Optional<users> findByUsername(String username);
}
