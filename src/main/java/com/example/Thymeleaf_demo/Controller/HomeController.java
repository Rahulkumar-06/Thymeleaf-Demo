package com.example.Thymeleaf_demo.Controller;

import com.example.Thymeleaf_demo.Models.Content;
import com.example.Thymeleaf_demo.Repository.ContentGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private ContentGateWay repo;
    @Autowired
    public void setRepo(ContentGateWay repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showForm(Model model) {
        model.addAttribute("content", new Content());
        return "home";
    }

    @PostMapping("/content/save")
    public String saveContent(@ModelAttribute Content content) {
        repo.save(content);
        return "redirect:/content/list";
    }

    @GetMapping("/content/list")
    public String listContent(Model model) {
        model.addAttribute("contents", repo.findAll());
        return "content-list";
    }
}
