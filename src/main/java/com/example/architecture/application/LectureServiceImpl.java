package com.example.architecture.application;

import com.example.architecture.api.dto.LectureDto;
import com.example.architecture.domain.Lecture;
import com.example.architecture.domain.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    /**
     * 신청 가능한 특강 목록 조회
     * 모든 신청 가능한 특강 목록을 조회하여 반환합니다.
     *
     * @return List<LectureDto> : 신청 가능한 특강 목록
     */
    @Override
    public List<LectureDto> getAvailableLectures() {
        // 모든 특강 목록 조회
        List<Lecture> lectures = lectureRepository.findAll();

        // 특강 정보를 DTO로 변환하여 반환
        return lectures.stream()
                .map(lecture -> new LectureDto(Math.toIntExact(lecture.getLectureId()), lecture.getTitle(), lecture.getLectureDate()))
                .collect(Collectors.toList());
    }
}
