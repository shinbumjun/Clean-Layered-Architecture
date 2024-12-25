package com.example.architecture.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId; // 특강 ID

    @Column(nullable = false)
    private String title; // 특강 이름

    @Column(nullable = false)
    private LocalDateTime lectureDate; // 특강 날짜와 시간

    @Column(nullable = false)
    private int maxStudent; // 최대 신청 인원수

    // 연관 관계 (LECTURER -> Users)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speaker_id", nullable = false) // 강연자 ID
    private User speaker;

    // 연관 관계 (Lecture -> LectureApplication)
    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureApplication> applications = new ArrayList<>();

    // 기본 생성자
    protected Lecture() {}

    // 생성자
    public Lecture(String title, LocalDateTime lectureDate, int maxStudent, User speaker) {
        this.title = title;
        this.lectureDate = lectureDate;
        this.maxStudent = maxStudent;
        this.speaker = speaker;
    }

    // Getter, Setter...
}

