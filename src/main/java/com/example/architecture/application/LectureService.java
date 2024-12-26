package com.example.architecture.application;

import com.example.architecture.api.dto.LectureDto;
import java.util.List;

public interface LectureService {
    // 신청 가능한 특강 목록을 반환하는 메서드
    List<LectureDto> getAvailableLectures();
}
