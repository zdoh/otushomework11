package ru.zdoher.hw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.zdoher.hw.view.Testing;
import ru.zdoher.hw.view.TestingImpl;


@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        Testing testingService = ctx.getBean(TestingImpl.class);
        testingService.doTest();

    }

}
