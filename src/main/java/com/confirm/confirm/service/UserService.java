package com.confirm.confirm.service;

import com.confirm.confirm.entity.User;
import com.confirm.confirm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (user != null) {
            user.setUserName(userDetails.getUserName());
            user.setUserPassword(userDetails.getUserPassword());
            user.setUserSchool(userDetails.getUserSchool());
            user.setUserCareer(userDetails.getUserCareer());
            user.setUserPreviousJobCategory(userDetails.getUserPreviousJobCategory());
            userRepository.save(user);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}

