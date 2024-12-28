package com.example.architecture.infrastructure.persistence;

import com.example.architecture.domain.LectureApplication;
import com.example.architecture.domain.LectureApplicationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLectureApplicationRepository extends JpaRepository<LectureApplication, Integer>, LectureApplicationRepository {
    // JpaRepository는 이미 CRUD 기본 메소드들을 제공하므로 추가적인 구현은 필요하지 않음
    // LectureApplicationRepository에서 정의한 커스텀 메서드를 사용할 수 있습니다.
    // 예: findByUserId, findByLectureId 등
}
