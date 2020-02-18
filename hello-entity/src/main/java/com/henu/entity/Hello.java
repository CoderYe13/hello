package com.henu.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {
    @Value("${hello.a}")
    private String helloa;
    @Value("${hello.b}")
    private String hellob;

    @Override
    public String toString() {
        return "Hello{" +
                "helloa='" + helloa + '\'' +
                ", hellob='" + hellob + '\'' +
                '}';
    }
}
