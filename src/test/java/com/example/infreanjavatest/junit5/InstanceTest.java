package com.example.infreanjavatest.junit5;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.infreanjavatest.domain.Study;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS) // 클래스마다 인스턴스를 생성해서 하나의 인스턴스를 공유한다.
public class InstanceTest {

    int value = 1;

    // TestInstance를 만들면 더 이상 @BeforeAll, @AfterAll이 static일 필요가 없다.
    @BeforeAll
    void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    void afterAll() {
        System.out.println("after all");
    }

    @Test
    @DisplayName("스터디 만들기")
    void test1() {
        System.out.println(this);
        System.out.println(value++);
        Study actual = new Study(1);
        assertThat(actual.getLimitCount()).isGreaterThan(0);
    }

    @Test
    @DisplayName("스터디 만들기")
    void test2() {
        System.out.println(this);
        System.out.println("value = " + value++);
    }

    // 테스트끼리 의존성을 없애기 위해 각각의 인스턴스 해시값은 다르게 동작한다.
}