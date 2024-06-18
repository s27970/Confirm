package com.confirm.confirm.service;

import com.confirm.confirm.entity.User;
import com.confirm.confirm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailService.class);
    private final UserRepository userRepository;

    // 사용자 이름(email)으로 사용자 정보를 가져오는 메소드
    @Override
    public UserDetails loadUserByUsername(String email) {
        log.info("Attempting to load user by email: {}", email);
        try {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
            log.info("User found: {}", user);
            log.info("Userid: {}", user.getId());
            return user;
        } catch (Exception e) {
            log.error("Error accessing the database", e);
            throw new InternalAuthenticationServiceException("Database access error", e);
        }
    }
}



