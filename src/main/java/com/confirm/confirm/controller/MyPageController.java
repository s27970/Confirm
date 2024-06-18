package com.confirm.confirm.controller;

import com.confirm.confirm.entity.User;
import com.confirm.confirm.entity.UserLog;
import com.confirm.confirm.service.UserLogService;
import com.confirm.confirm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyPageController {

    private final UserLogService userLogService;
    private final UserService userService;

    @Autowired
    public MyPageController(UserLogService userLogService, UserService userService) {
        this.userLogService = userLogService;
        this.userService = userService;
    }

    @GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        User user = userService.findById(userId);
        List<UserLog> userLogs = userLogService.getUserLogsByUserId(userId);
        model.addAttribute("userLogs", userLogs);
        return "mypage";
    }
}
