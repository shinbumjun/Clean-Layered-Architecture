package com.example.architecture.application;

import com.example.architecture.api.dto.LectureApplicationDto;
import com.example.architecture.domain.LectureApplication;
import com.example.architecture.domain.Lecture;
import com.example.architecture.domain.LectureApplicationRepository;
import com.example.architecture.domain.Users;
import com.example.architecture.domain.UserRepository;
import com.example.architecture.domain.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureApplicationServiceImpl implements LectureApplicationService {

    private final LectureApplicationRepository lectureApplicationRepository;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    @Autowired
    public LectureApplicationServiceImpl(LectureApplicationRepository lectureApplicationRepository,
                                         UserRepository userRepository,
                                         LectureRepository lectureRepository) {
        this.lectureApplicationRepository = lectureApplicationRepository;
        this.userRepository = userRepository;
        this.lectureRepository = lectureRepository;
    }

    /**
     * 특강 신청 처리
     * 클라이언트가 전송한 특강 신청 정보를 기반으로 특강 신청을 처리하고 저장합니다.
     *
     * @param applicationDto : 신청 정보 (특강 ID, 사용자 ID, 신청 날짜)
     */
    @Override
    public void applyForLecture(LectureApplicationDto applicationDto) {
        // 사용자 ID로 사용자 정보 조회, 없으면 예외 발생
        Users user = userRepository.findById(applicationDto.getUsersId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user"));

        // 특강 ID로 특강 정보 조회, 없으면 예외 발생
        Lecture lecture = lectureRepository.findById(applicationDto.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid lecture"));

        // 신청 정보로 LectureApplication 객체 생성
        LectureApplication application = new LectureApplication(
                lecture,
                user,
                applicationDto.getApplicationDate()
        );

        // 신청 데이터를 저장
        lectureApplicationRepository.save(application);
    }

    /**
     * 신청 완료된 특강 목록 조회
     * 모든 신청 완료된 특강 목록을 조회하여 반환합니다.
     *
     * @return List<LectureApplicationDto> : 신청 완료된 특강 목록
     */
    @Override
    public List<LectureApplicationDto> getCompletedApplications() {
        // 모든 신청 완료된 특강 조회
        List<LectureApplication> applications = lectureApplicationRepository.findAll();

        // 신청된 특강 정보를 DTO로 변환하여 반환
        return applications.stream()
                .map(application -> new LectureApplicationDto(
                        Math.toIntExact(application.getLectureId()), // 특강 ID
                        Math.toIntExact(application.getUsersId()), // 사용자 ID
                        application.getApplicationDate())) // 신청 날짜
                .collect(Collectors.toList());
    }
}
