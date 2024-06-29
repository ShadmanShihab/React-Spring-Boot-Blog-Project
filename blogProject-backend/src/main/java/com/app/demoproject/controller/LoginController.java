package com.app.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginMessage", "Log in to continue");
        return "login.html";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("loginMessage", "Log in to continue");
        return "index.html";
    }
}
