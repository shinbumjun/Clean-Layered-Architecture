package com.example.architecture.api.controller;

import com.example.architecture.api.dto.LectureApplicationDto;
import com.example.architecture.application.LectureApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecture-applications")
public class LectureApplicationController {

    private final LectureApplicationService lectureApplicationService;

    @Autowired
    public LectureApplicationController(LectureApplicationService lectureApplicationService) {
        this.lectureApplicationService = lectureApplicationService;
    }

    /**
     * 1. 특강 신청 API
     * 클라이언트가 특강 신청 정보를 서버로 전달하여 신청을 처리합니다.
     * @RequestBody LectureApplicationDto applicationDto : 특강 신청 정보 (lectureId, usersId, applicationDate)
     * @ResponseStatus(HttpStatus.CREATED) : 신청이 성공적으로 완료되면 201 Created 응답을 반환
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void applyForLecture(@RequestBody LectureApplicationDto applicationDto) {
        lectureApplicationService.applyForLecture(applicationDto);
    }

    /**
     * 3. 특강 신청 완료 목록 조회 API
     * 클라이언트가 신청 완료된 특강 목록을 요청하면, 이를 반환
     * @return List<LectureApplicationDto> : 특강 신청 완료 목록 (lectureId, usersId, applicationDate)
     */
    @GetMapping("/completed")
    public List<LectureApplicationDto> getCompletedApplications() {
        return lectureApplicationService.getCompletedApplications();
    }
}
