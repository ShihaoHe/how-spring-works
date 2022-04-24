package com.example.ioc.bean;

import org.springframework.stereotype.Component;

@Component
public class Test {
    private String name = "original test name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
