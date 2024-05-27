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
        return "new_user.html";
    }

    // Create a new user
    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.saveUser(user);
        return REDIRECT_USERS;
    }

    // Get all users
    @GetMapping
    public ModelAndView getAllUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView mav = new ModelAndView("users.html");
        mav.addObject("users", users);
        return mav;
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ModelAndView getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        ModelAndView mav = new ModelAndView("user_details.html");
        mav.addObject("user", user);
        return mav;
    }

    // Update user form
    @GetMapping("/{id}/edit")
    public ModelAndView editUserForm(@PathVariable String id) {
        User user = userService.getUserById(id);
        ModelAndView mav = new ModelAndView("edit_user.html");
        mav.addObject("user", user);
        return mav;
    }

    // Update user
    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable String id, @RequestBody User userDetails) {
        userService.updateUser(id, userDetails);
        return REDIRECT_USERS;
    }

    // Delete user
    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return REDIRECT_USERS;
    }
}
