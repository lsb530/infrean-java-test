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
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createNewStudy() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = Member.builder()
            .id(1L)
            .email("boki@email.com")
            .build();

        // Stubbing 리턴 값
//        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(memberService.findById(any())).thenReturn(Optional.of(member));

        Study study = Study.builder()
            .limitCount(10)
            .name("java")
            .build();

        Optional<Member> findById = memberService.findById(1L);
        assertEquals("boki@email.com",memberService.findById(1L).get().getEmail());
//        assertEquals("boki@email.com",memberService.findById(2L).get().getEmail());

        // Stubbing 예외 던지기
//        when(memberService.findById(1L)).thenThrow(new RuntimeException());

        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

        assertThrows(IllegalArgumentException.class, () -> {
            memberService.validate(1L);
        });

        memberService.validate(2L);

//        Study newStudy = studyService.createNewStudy(1L, study);
    }

    @Test
    void makeStubbing() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = Member.builder()
            .id(1L)
            .email("boki@email.com")
            .build();

        // 첫번째꺼는 멤버를 호출하고 그 다음은 예외를 던지고 세번째는 빈 값을 리턴하도록
        when(memberService.findById(any()))
            .thenReturn(Optional.of(member))
            .thenThrow(new RuntimeException())
            .thenReturn(Optional.empty());

        Optional<Member> byId = memberService.findById(1L);
        assertEquals("boki@email.com",byId.get().getEmail());

        assertThrows(RuntimeException.class,() -> {
            memberService.findById(2L);
        });

        assertEquals(Optional.empty(),memberService.findById(3L));
    }
}