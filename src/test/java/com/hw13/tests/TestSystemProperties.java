package com.hw13.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestSystemProperties {

    @Test
    void testSystemProperties() {
        System.out.println(System.getProperty("selenoid"));
        System.out.println(System.getProperty("baseUrl"));
        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("browserSize"));
        System.out.println(System.getProperty("browserVersion"));
    }
}