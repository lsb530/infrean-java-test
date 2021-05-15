package com.example.infreanjavatest;

import com.example.infreanjavatest.config.FastTest;
import com.example.infreanjavatest.config.SlowTest;

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