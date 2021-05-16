package com.example.infreanjavatest.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PlatformPropertiesTest {

    int value = 3;

    @Test
    void val_test_1() {
        value++;
        System.out.println(value);
    }

    @Test
    void val_test_2() {
        value++;
        System.out.println(value);
    }

    @Disabled
    @Test
    void disabled_test() {
        value++;
        System.out.println(value);
    }

}