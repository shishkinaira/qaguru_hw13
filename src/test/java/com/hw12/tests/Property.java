package com.hw12.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Property {
    @Test
    @Tag("properties")
    void checkProperties() {
        System.out.println(System.getProperty("selenoid"));
        System.out.println(System.getProperty("baseUrl"));
        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("browserSize"));
    }
}