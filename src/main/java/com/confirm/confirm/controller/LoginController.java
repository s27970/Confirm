package com.confirm.confirm.controller;

import com.confirm.confirm.dto.LoginData;
import com.confirm.confirm.service.LoginService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login.html";
    }

    @PostMapping("/login")
    public String postLogin(@RequestBody Map<String, String> requestBody, HttpServletResponse response) {
        response.addCookie(
                loginService.login(
                        new LoginData(requestBody.get("id"), requestBody.get("password"))));

        return "redirect:/";
    }
}
