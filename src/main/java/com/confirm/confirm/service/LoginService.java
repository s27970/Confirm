package com.confirm.confirm.service;

import com.confirm.confirm.dto.Login;
import com.confirm.confirm.entity.User;
import com.confirm.confirm.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(Login loginData, HttpSession session) {
        User user = userRepository.findByUserName(loginData.getUserId());
        if (user != null && user.getUserPassword().equals(loginData.getUserPassword())) {
            session.setAttribute("userId", user.getUserId());
            return true;
        } else {
            return false;
        }
    }
}

