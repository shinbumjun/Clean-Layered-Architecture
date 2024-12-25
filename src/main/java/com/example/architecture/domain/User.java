package com.example.architecture.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity // 브랜치 추가
@Table(name = "users")
public class User { // ctrl + f6

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usersId; // 사용자 ID

    @Column(nullable = false)
    private String usersName; // 사용자 이름

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // 역할 (STUDENT / LECTURER)

    // Enum 정의
    public enum Role {
        STUDENT, LECTURER
    }

    // 연관 관계 (LECTURER -> Lecture)
    @OneToMany(mappedBy = "speaker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lecture> lectures = new ArrayList<>();

    // 연관 관계 (STUDENT -> LectureApplication)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureApplication> applications = new ArrayList<>();

    // 기본 생성자
    protected User() {}

    // 생성자
    public User(String usersName, Role role) {
        this.usersName = usersName;
        this.role = role;
    }

    // Getter, Setter...
}


