package com.example.infreanjavatest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // _를 빈 공백문자로 치환
public class BasicTest {

    @Test
    @DisplayName("스터디 만들기")
    void create_new_study() {
        Study study = Study.builder()
            .build();
        // expected, actual, message
        // 람다로 만들지 않으면 테스트가 실패하던 말던 문자열 연산을 한다.
        assertAll(
            () -> assertNotNull(study),
            () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 "
                + StudyStatus.DRAFT + " 여야 한다."),
            () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );
    }

    @Test
    void this_is_a_test() {
        System.out.println("hello");
    }

    @Test
    @DisplayName("실행안됨")
    @Disabled
    void notExcute() {
        System.out.println("no");
    }
}