package com.confirm.confirm.service;

import com.confirm.confirm.entity.UserLog;
import com.confirm.confirm.repository.UserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLogService {

    private final UserLogRepository userLogRepository;

    @Autowired
    public UserLogService(UserLogRepository userLogRepository) {
        this.userLogRepository = userLogRepository;
    }

    public List<UserLog> getUserLogsByUserId(Long userId) {
        return userLogRepository.findByUserId(userId);
    }
}
