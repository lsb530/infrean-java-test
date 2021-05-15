package com.example.infreanjavatest;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimeoutTest {
    @Test
    @DisplayName("시간 안에 테스트") // 300 ms 이상
    void duration() {
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test // 단점 => Transactional 테스트로 사용할 때에는 고민해봐야된다.
    @DisplayName("시간이 지나면 바로 테스트가 종료되게하고싶을 때") // 100 ms 이상
    void overTime() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
        // TODO ThreadLocal
    }
}