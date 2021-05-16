package com.example.infreanjavatest.junit5;

import com.example.infreanjavatest.junit5.config.SlowTest;
import com.example.infreanjavatest.junit5.extension.FindSlowTestExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

//@ExtendWith(FindSlowTestExtension.class)
public class ExtensionTest {
    // Junit4의 확장 모델은 @RunWith(Runner), TestRule, MethodRule.
    // Junit5의 확장 모델은 단 하나, Extension
    // 1. 선언적인 등록 @ExtendWith
    // 2. 프로그래밍적인 등록 @RegisterExtension
    // 3. 자동 등록 자바 ServiceLoader 이용

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension =
        new FindSlowTestExtension(1000L);

    @Test
    void test1() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println("test1");
    }

    @Test
    @SlowTest
    void test2() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println("test2");
    }
}