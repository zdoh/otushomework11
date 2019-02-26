package ru.zdoher.hw.service;

import ru.zdoher.hw.domain.Profile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class TestingServiceImpl implements TestingService {
    private final QuestionnaireService questionnaireService;
    private Profile profile;


    public TestingServiceImpl(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
        profile = new Profile();
    }

    @Override
    public void doTest() throws IOException  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в тест, представьтесь пожалуйста.");
        System.out.print("Ваше имя: ");
        profile.setName(scanner.next());
        System.out.print("Ваша фамилия: ");
        profile.setSurname(scanner.next());

        System.out.println(profile);



    }
}
