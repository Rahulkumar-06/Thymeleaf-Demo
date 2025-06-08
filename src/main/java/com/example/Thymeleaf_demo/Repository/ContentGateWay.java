package com.example.Thymeleaf_demo.Repository;

import com.example.Thymeleaf_demo.Models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentGateWay extends JpaRepository<Content,Long> {
}
