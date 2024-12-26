package com.example.architecture.api.controller;

import com.example.architecture.api.dto.LectureDto;
import com.example.architecture.application.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    /**
     * 2. 특강 신청 가능 목록 조회 API
     * 클라이언트가 신청 가능한 특강 목록을 요청하면, 이를 반환
     * @return List<LectureDto> : 신청 가능한 특강 목록 (lectureId, title, lectureDate)
     */
    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK) // 요청이 성공적으로 처리되었음을 나타내는 200 OK 응답
    public List<LectureDto> getAvailableLectures() {
        return lectureService.getAvailableLectures();
    }
}
