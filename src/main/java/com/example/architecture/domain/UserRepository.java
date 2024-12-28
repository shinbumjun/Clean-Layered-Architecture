package com.example.architecture.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    // 기본 CRUD 메서드 (save, findById, findAll 등) 제공
    // Optional<Users> findById(Integer id) : 사용자 ID로 사용자를 조회합니다. (없는 경우 Optional.empty() 반환)
}
