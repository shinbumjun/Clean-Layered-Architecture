package com.example.architecture.application;

import com.example.architecture.api.dto.LectureApplicationDto;
import java.util.List;

public interface LectureApplicationService {

    // 특강 신청을 처리하는 메서드
    void applyForLecture(LectureApplicationDto applicationDto);

    // 신청 완료된 특강 목록을 반환하는 메서드
    List<LectureApplicationDto> getCompletedApplications();
}
