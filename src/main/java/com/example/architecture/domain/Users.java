package com.example.architecture.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // 실제 테이블 이름 매핑
public class Users { // 사용자
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private Long usersId;  // 사용자 ID

    private String usersName; // 사용자 이름

    @Enumerated(EnumType.STRING) // 열거형 매핑
    private Role role; // 사용자 역할 (학생 또는 강연자)

    public enum Role {
        STUDENT, LECTURER // 역할 ENUM (학생, 강연자)
    }

    // 양방향 관계를 통해 사용자의 신청 데이터를 쉽게 접근하려는 경우 / 필요 있음
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureApplication> applications = new ArrayList<>(); // 사용자 신청 목록 (일대다 관계)

    // 강연자와 특강의 양방향 관계를 통해 데이터를 쉽게 접근하려는 경우 / 필요 없음
    @OneToMany(mappedBy = "speaker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lecture> lectures = new ArrayList<>(); // 사용자가 강연자인 특강 목록 (일대다 관계)
}
