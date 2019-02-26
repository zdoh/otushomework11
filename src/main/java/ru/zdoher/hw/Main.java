package ru.zdoher.hw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.zdoher.hw.dao.QuestionnaireDAOImpl;
import ru.zdoher.hw.service.TestingServiceImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        // QuestionnaireDAOImpl questionDAO = context.getBean(QuestionnaireDAOImpl.class);
        // questionDAO.printList();

        TestingServiceImpl testingService = context.getBean(TestingServiceImpl.class);
        testingService.doTest();

    }
}
