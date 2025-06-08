package com.example.Thymeleaf_demo.Services;

import com.example.Thymeleaf_demo.Models.UserPrincpal;
import com.example.Thymeleaf_demo.Models.users;
import com.example.Thymeleaf_demo.Repository.GateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServices implements UserDetailsService {
    private GateWay repo;
    @Autowired
    public void setRepo(GateWay repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users user = repo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Not found user"));
        return new UserPrincpal(user);
    }
}
