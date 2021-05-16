package com.example.infreanjavatest.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.infreanjavatest.domain.Member;
import com.example.infreanjavatest.domain.Study;
import com.example.infreanjavatest.member.MemberService;
import com.example.infreanjavatest.study.StudyRepository;
import com.example.infreanjavatest.study.StudyService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)
public class MockCreateTest {

    // 모든 Mock 객체의 행동
    // Null을 리턴한다(Optional 타입은 Optional.Empty), Primitive 타입은 기본 Primitive 값.
    // 콜렉션은 비어잇는 콜렉션. Void 메서드는 예외를 던지지 않고 아무런 일도 발생하지 않는다.

    @Test
    void createStudyService1() {
        MemberService memberService = mock(MemberService.class);
        StudyRepository studyRepository = mock(StudyRepository.class);
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Mock MemberService memberService;
    @Mock StudyRepository studyRepository;

    @Test
    void createStudyService2() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    void createStudyService3(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }
}