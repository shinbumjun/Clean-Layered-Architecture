package com.example.architecture.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    // 기본 CRUD 메서드 (save, findById, findAll 등) 제공
    // 필요에 따라 커스텀 쿼리 메서드를 추가할 수 있습니다.
}
