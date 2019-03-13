package ru.zdoher.hw;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.zdoher.hw.view.TestingImpl;


@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        TestingImpl testingService = ctx.getBean(TestingImpl.class);
        testingService.doTest();

    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
