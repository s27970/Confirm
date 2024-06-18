package com.confirm.confirm.service;

import com.confirm.confirm.dto.AddUserRequest;
import com.confirm.confirm.entity.User;
import com.confirm.confirm.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
