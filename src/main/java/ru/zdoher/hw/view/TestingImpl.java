package ru.zdoher.hw.view;

import ru.zdoher.hw.domain.Answer;
import ru.zdoher.hw.domain.Profile;
import ru.zdoher.hw.service.QuestionnaireService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestingImpl implements Testing {
    private final QuestionnaireService questionnaireService;
    private Profile profile = new Profile();


    public TestingImpl(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @Override
    public void doTest()  {
        acquaintance();
        System.out.println("Начинаем тестирование. За каждый правильный ответ получаете два балла");
        testing();
        System.out.println("Тестироварие закончено. Ваши результаты");
        testingResult();
    }

    private void acquaintance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в тест, представьтесь пожалуйста.");
        System.out.print("Ваше имя: ");
        profile.setName(scanner.next());
        System.out.print("Ваша фамилия: ");
        profile.setSurname(scanner.next());

    }

    private void testing() {
        for(Map.Entry<String, List<Answer>> tempMap : questionnaireService.getQuestionList().entrySet()) {
            System.out.println(tempMap.getKey());

            System.out.println("Варианты ответа: ");

            for(int i = 0; i < tempMap.getValue().size(); i++) {
                System.out.println((i + 1) + ": " + tempMap.getValue().get(i).getAnswer());
            }

            int answerId = 0;
            while (answerId < 1 || answerId > tempMap.getValue().size()) {
                System.out.println("Выберите номер ответа (от 1 до " + (tempMap.getValue().size() ) + "):");
                Scanner scanner = new Scanner(System.in);

                try {
                    answerId = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {

                }
            }

            if (tempMap.getValue().get(answerId - 1).getRight()) {
                profile.setRightAnswer(profile.getRightAnswer() + 1);
                profile.setPoints(profile.getPoints() + 2);
            }

            System.out.println();

        }

    }

    private void testingResult() {
        System.out.println("Имя: " + profile.getName());
        System.out.println("Фамилия: " + profile.getSurname());
        System.out.println("Кол-во правильных ответов: " + profile.getRightAnswer() + "/" + questionnaireService.getQuestionList().size());
        System.out.println("Кол-во очков: " + profile.getPoints());

    }
}
