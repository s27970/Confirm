package com.confirm.confirm.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.confirm.confirm.entity.EventJPA;

public interface EventRepository extends JpaRepository<EventJPA, Long> {
}
