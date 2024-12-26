package com.example.architecture.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter // getter 메서드를 자동으로 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자를 자동으로 생성
public class LectureDto {

    private int lectureId; // 특강 ID
    private String title;  // 특강 제목
    private LocalDateTime lectureDate; // 특강 날짜 및 시간
}
