package com.example.ioc.processor;

import com.example.ioc.bean.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor # postProcessBeforeInstantiation() invoked");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor # postProcessAfterInstantiation() invoked");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor # postProcessProperties() invoked");

            MutablePropertyValues pv = new MutablePropertyValues(pvs);
            Test test = new Test();
            test.setName("name of test updated from post processor");
            pv.add("test", test);
            pv.add("name", "name of user updated from post processor");

            return pv;
        }
        return null;
    }
}
