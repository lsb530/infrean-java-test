package com.example.infreanjavatest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThirdPartyTest {

    @Test
    @DisplayName("Third-party Test") // assertj 사용
    void third_party_test() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

}