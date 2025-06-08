package com.example.Thymeleaf_demo.Controller;

import com.example.Thymeleaf_demo.Models.users;
import com.example.Thymeleaf_demo.Repository.GateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private GateWay repo;
    @Autowired
    public void setRepo(GateWay repo) {
        this.repo = repo;
    }
    @GetMapping("/register")
            public String reg(Model model){
        model.addAttribute("user",new users());
        return "register";
    }
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @PostMapping("/register")
    public String register(@ModelAttribute users user){
    user.setPassword(encoder.encode(user.getPassword()));
    repo.save(user);
    return "Registered";
    }
}
