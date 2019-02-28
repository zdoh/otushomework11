package ru.zdoher.hw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.zdoher.hw.view.TestingImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        TestingImpl testingService = context.getBean(TestingImpl.class);
        testingService.doTest();

    }
}
