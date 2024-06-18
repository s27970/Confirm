package com.confirm.confirm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;
    private String action; // 클릭 또는 좋아요 등의 동작
    private String details; // 공고 ID 또는 기타 세부 정보

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Custom constructor for required fields
    public UserLog(String action, String details, User user) {
        this.timestamp = LocalDateTime.now();
        this.action = action;
        this.details = details;
        this.user = user;
    }
}

