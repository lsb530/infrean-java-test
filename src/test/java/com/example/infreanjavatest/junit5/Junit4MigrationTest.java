package com.example.infreanjavatest.junit5;

import org.junit.Before;
import org.junit.Test;

// 패키지 기준으로 실행을 하면 Junit4엔진(vintage)과 5엔진(jupiter)으로 실행한 클래스를 나누어서 보여준다
public class Junit4MigrationTest {

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void createTest() {
        System.out.println("test");
    }

    @Test
    public void createTest2() {
        System.out.println("test2");
    }
}