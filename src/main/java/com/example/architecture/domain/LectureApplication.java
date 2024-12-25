package com.example.architecture.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lecture_application") // 실제 테이블 이름 매핑
public class LectureApplication { // 특강 신청
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private Long applicationId; // 신청 ID (고유 식별자)

    @ManyToOne(fetch = FetchType.LAZY) // 신청된 특강과 다대일 관계
    @JoinColumn(name = "lecture_id", nullable = false) // 외래 키 설정 (특강 ID)
    private Lecture lecture; // 신청한 특강 (Lecture 엔티티와 연결)

    @ManyToOne(fetch = FetchType.LAZY) // 신청한 사용자와 다대일 관계
    @JoinColumn(name = "users_id", nullable = false) // 외래 키 설정 (사용자 ID)
    private Users user; // 신청한 사용자 (User 엔티티와 연결)

    private LocalDateTime applicationDate; // 신청 날짜 및 시간
}
