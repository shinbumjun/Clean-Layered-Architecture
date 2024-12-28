package com.example.architecture.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    // JpaRepository에서 기본적으로 제공하는 메서드를 상속받습니다.
    // 예: save(), findAll(), findById(), delete() 등
}
