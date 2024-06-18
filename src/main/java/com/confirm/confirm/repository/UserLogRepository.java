package com.confirm.confirm.repository;

import com.confirm.confirm.entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {
    List<UserLog> findByUserId(Long userId);
}
