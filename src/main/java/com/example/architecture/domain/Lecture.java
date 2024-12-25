package com.example.architecture.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecture") // 실제 테이블 이름 매핑
public class Lecture { // 특강
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private Long lectureId; // 특강 ID (고유 식별자)

    private String title; // 특강 제목

    private LocalDateTime lectureDate; // 특강 날짜 및 시간

    @ManyToOne(fetch = FetchType.LAZY) // 강연자와 다대일 관계
    @JoinColumn(name = "speaker_id", nullable = false) // 외래 키 설정 (강연자 ID)
    private Users speaker; // 강연자 (User 엔티티와 연결)

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true) // 특강과 신청의 일대다 관계
    private List<LectureApplication> applications = new ArrayList<>(); // 특강 신청 목록
}
