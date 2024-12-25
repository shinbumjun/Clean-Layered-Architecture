package com.example.architecture.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lecture_application")
public class LectureApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId; // 신청 ID

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; // 신청 상태 (대기, 승인, 취소)

    @Column(nullable = false)
    private LocalDateTime applicationDate; // 신청 날짜와 시간

    // 연관 관계 (LectureApplication -> Users)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false) // 사용자 ID
    private User user;

    // 연관 관계 (LectureApplication -> Lecture)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false) // 특강 ID
    private Lecture lecture;

    // Enum 정의
    public enum Status {
        WAITING, APPROVED, CANCELLED
    }

    // 기본 생성자
    protected LectureApplication() {}

    // 생성자
    public LectureApplication(Status status, LocalDateTime applicationDate, User user, Lecture lecture) {
        this.status = status;
        this.applicationDate = applicationDate;
        this.user = user;
        this.lecture = lecture;
    }

    // Getter, Setter...
}


