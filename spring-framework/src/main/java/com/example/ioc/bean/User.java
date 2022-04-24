package com.example.ioc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class User implements InitializingBean, DisposableBean {

    private static final String className = User.class.getName();

    @Autowired
    private Test test;

    @Value("${test.user.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Test getTest() {
        return test;
    }

    public User() {
        System.out.printf("constructor of %s invoked%n", className);
    }

    @PostConstruct
    public void init() {
        System.out.printf("post construct method of %s invoked%n", className);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean # afterPropertiesSet() invoked");
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean # destroy() invoked");
    }
}
