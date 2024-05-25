package com.confirm.confirm.repository;

import com.confirm.confirm.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}