package com.example.infreanjavatest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class CriteriaTest {

    @Test
    @DisplayName("환경 변수에 따라 테스트")
    // vim ~/.zshrc 에서 환경변수를 적어준다. TEST_ENV=LOCAL 그리고 인텔리J 재시작
    void criteria() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println("test_env = " + test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            System.out.println("local");
            Study actual = new Study(100);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });

        assumingThat("BOKI".equalsIgnoreCase(test_env), () -> {
            System.out.println("boki");
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });
    }

    @Test
    @DisplayName("환경 변수에 따른 테스트 annotation화1")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void test1() {
        System.out.println("local test");
    }

    @Test
    @DisplayName("환경 변수에 따른 테스트 annotation화2")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "BOKI")
    void test2() {
        System.out.println("boki test");
    }

    @Test
    @DisplayName("OS에 따라 테스트")
    @EnabledOnOs(OS.MAC)
    void testMac() {
        System.out.println("Only Mac Test");
    }

    @Test
    @DisplayName("OS에 따라 테스트")
    @DisabledOnOs(OS.MAC)
    void testNotMac() {
        System.out.println("Not Mac Test");
    }

    @Test
    @DisplayName("여러가지 OS에 따라 테스트")
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void tests() {
        System.out.println("Mac and Linux Test");
    }

    @Test
    @DisplayName("JAVA 버전별 테스트1")
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})
    void versionTest1() {
        System.out.println("Java 8, 9, 10, 11 Test");
    }

    @Test
    @DisplayName("JAVA 버전별 테스트2")
    @EnabledOnJre(JRE.OTHER)
    void versionTest2() {
        System.out.println("Java ??");
    }

}