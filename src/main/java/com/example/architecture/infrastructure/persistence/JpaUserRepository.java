package com.example.architecture.infrastructure.persistence;

import com.example.architecture.domain.Users;
import com.example.architecture.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<Users, Integer>, UserRepository {
    // JpaRepository는 이미 CRUD 기본 메소드들을 제공하므로 추가적인 구현은 필요하지 않음
    // UserRepository 인터페이스에서 정의한 커스텀 쿼리 메서드를 사용할 수 있습니다.
    // 예: findById, findByUsersName 등
}
