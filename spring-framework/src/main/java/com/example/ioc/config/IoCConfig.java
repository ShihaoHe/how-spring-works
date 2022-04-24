package com.example.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({"com.example.ioc.bean", "com.example.ioc.processor"})
@PropertySource("classpath:application.properties")
public class IoCConfig {

}
