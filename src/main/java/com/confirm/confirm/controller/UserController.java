package com.confirm.confirm.controller;

import com.confirm.confirm.entity.User;
import com.confirm.confirm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final String REDIRECT_USERS = "redirect:/users";

    @Autowired
    private UserService userService;

    // Create a new user form
    @GetMapping("/new")
    public String newUserForm() {
        return "new_user";
    }

    // Create a new user
    @PostMapping("/new")
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login"; // 회원가입 후 로그인 페이지로 이동
    }

    // Get all users
    @GetMapping
    public ModelAndView getAllUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("users", users);
        return mav;
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ModelAndView getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        ModelAndView mav = new ModelAndView("user_details");
        mav.addObject("user", user);
        return mav;
    }

    // Update user form
    @GetMapping("/{id}/edit")
    public ModelAndView editUserForm(@PathVariable Long id) {
        User user = userService.getUserById(id);
        ModelAndView mav = new ModelAndView("edit_user");
        mav.addObject("user", user);
        return mav;
    }

    // Update user
    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable Long id, @ModelAttribute User userDetails) {
        userService.updateUser(id, userDetails);
        return REDIRECT_USERS;
    }

    // Delete user
    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return REDIRECT_USERS;
    }
}

