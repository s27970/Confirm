package com.confirm.confirm.service;

import com.confirm.confirm.entity.User;
import com.confirm.confirm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 저장
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // 사용자 조회
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // 모든 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 사용자 업데이트
    public void updateUser(String id, User user) {
        userRepository.save(user);
    }

    // 사용자 삭제
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    // 기타 비즈니스 로직 메서드 추가 가능
}
