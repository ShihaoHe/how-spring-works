package com.example.ioc.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("BeanPostProcessor # postProcessBeforeInitialization() invoked");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("BeanPostProcessor # postProcessAfterInitialization() invoked");
        }
        return bean;
    }
}
