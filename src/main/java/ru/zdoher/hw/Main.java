package ru.zdoher.hw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.zdoher.hw.view.TestingImpl;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        TestingImpl testingService = context.getBean(TestingImpl.class);
        testingService.doTest();

    }
}
