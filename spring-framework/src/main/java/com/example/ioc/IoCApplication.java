package com.example.ioc;

import com.example.ioc.bean.User;
import com.example.ioc.config.IoCConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(IoCConfig.class);

            context.refresh();

            User user = (User)context.getBean("user");
            System.out.println(user.getName());
            System.out.println(user.getTest().getName());
        }

    }
}
