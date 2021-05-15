package com.example.infreanjavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TaggingAndFilteringTest {

    // 로컬일때, 빠르게 테스트를 할 수 있을 때
    @Test
    @DisplayName("스터디 만들기 fast")
    @Tag("fast")
    void test1() {
        System.out.println("테스트1");
    }

    // CI 환경일때(원격에서 빌드해서 실행하는 경우), 로컬에서 하기 부담스러운 경우
    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void test2() {
        System.out.println("테스트2");
    }
}