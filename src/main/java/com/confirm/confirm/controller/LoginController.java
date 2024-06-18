package com.confirm.confirm.controller;

import com.confirm.confirm.dto.Login;
import com.confirm.confirm.service.LoginService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String userId, @RequestParam String userPassword, HttpSession session) {
        boolean success = loginService.login(new Login(userId, userPassword), session);
        if (success) {
            return "redirect:/mainpage";
        } else {
            return "redirect:/login?error=true";
        }
    }
}

