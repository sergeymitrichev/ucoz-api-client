package ru.minutkann.ucozapiclient;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.minutkann.ucozapiclient.service.UserServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            UserServiceImpl service = appCtx.getBean(UserServiceImpl.class);
            System.out.println(service.get(21));
        }
    }
}
