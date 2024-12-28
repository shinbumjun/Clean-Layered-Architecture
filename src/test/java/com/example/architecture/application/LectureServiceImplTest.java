package com.example.architecture.application;

import com.example.architecture.api.dto.LectureDto;
import com.example.architecture.domain.Lecture;
import com.example.architecture.domain.LectureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LectureServiceImplTest {

    @Mock
    private LectureRepository lectureRepository; // Mock 객체 -> 미리 설정된 가짜 데이터를 반환

    @InjectMocks
    private LectureServiceImpl lectureService; // 서비스 객체

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
    }

    // 1. 신청 가능한 특강 목록 조회 -> 특강 목록을 올바르게 반환하는지 테스트
    @Test
    void testGetAvailableLectures() {
        // 1-1) Mock 데이터 생성
        Lecture lecture1 = new Lecture();
        lecture1.setLectureId(1L); // pk
        lecture1.setTitle("클린 아키텍처"); // 제목
        lecture1.setLectureDate(LocalDateTime.now()); // 현재 시간

        Lecture lecture2 = new Lecture(); // pk
        lecture2.setLectureId(2L); // 제목
        lecture2.setTitle("소프트웨어 디자인 원칙"); // 현재 시간
        lecture2.setLectureDate(LocalDateTime.now());

        // Mock된 repository에서 findAll() 호출 시 미리 정의된 가짜 데이터 (즉, lecture1과 lecture2를 반환)
        when(lectureRepository.findAll()).thenReturn(Arrays.asList(lecture1, lecture2));

        // 서비스 메서드 호출 ->
        List<LectureDto> lectureDtos = lectureService.getAvailableLectures();

        // 결과 검증
        assertNotNull(lectureDtos);
        assertEquals(2, lectureDtos.size());
        assertEquals("클린 아키텍처", lectureDtos.get(0).getTitle());
        assertEquals("소프트웨어 디자인 원칙", lectureDtos.get(1).getTitle());

        // repository의 findAll() 메서드가 한 번 호출되었는지 확인
        verify(lectureRepository, times(1)).findAll();
    }
}
