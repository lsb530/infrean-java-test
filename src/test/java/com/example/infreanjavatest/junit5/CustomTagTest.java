package com.example.infreanjavatest.junit5;

import com.example.infreanjavatest.junit5.config.FastTest;
import com.example.infreanjavatest.junit5.config.SlowTest;

public class CustomTagTest {

    @FastTest
    void fast() {
        System.out.println("Fast");
    }

    @SlowTest
    void slow() {
        System.out.println("Slow");
    }
}