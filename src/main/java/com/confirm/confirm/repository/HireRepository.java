package com.confirm.confirm.repository;

import com.confirm.confirm.entity.HIRE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HireRepository extends JpaRepository<HIRE, Long> {  // Integer에서 Long으로 변경

}
