package com.example.infreanjavatest.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class OrderTest {

    int value = 0;

    @Order(3)
    @Test
    void test1() {
        value++;
        System.out.println("test1 val = " + value);
    }

    @Order(1)
    @Test
    void test2() {
        value++;
        System.out.println("test2 val = " + value);
    }

    @Order(2)
    @Test
    void test3() {
        value++;
        System.out.println("test3 val = " + value);
    }

    @Order(4)
    @Test
    void test4() {
        value++;
        System.out.println("test4 val = " + value);
    }

}