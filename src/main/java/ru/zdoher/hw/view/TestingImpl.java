package ru.zdoher.hw.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.zdoher.hw.domain.Answer;
import ru.zdoher.hw.domain.Profile;
import ru.zdoher.hw.service.AcquaintanceService;
import ru.zdoher.hw.service.ConsoleService;
import ru.zdoher.hw.service.QuestionnaireService;

import java.util.List;
import java.util.Map;

@PropertySource("classpath:application.properties")
@Service
public class TestingImpl implements Testing {
    private final QuestionnaireService questionnaireService;
    private final AcquaintanceService acquaintanceService;
    private final ConsoleService consoleService;
    private Profile profile = new Profile();



    public TestingImpl(QuestionnaireService questionnaireService, AcquaintanceService acquaintanceService, ConsoleService consoleService) {
        this.questionnaireService = questionnaireService;
        this.acquaintanceService = acquaintanceService;
        this.consoleService = consoleService;
    }

    @Override
    public void doTest()  {
        acquaintanceService.makeAcquantance(profile);
        consoleService.printString("Начинаем тестирование. За каждый правильный ответ получаете два балла");
        testing();
        consoleService.printString("Тестироварие закончено. Ваши результаты");
        testingResult();
    }

    private void testing() {
        for(Map.Entry<String, List<Answer>> tempMap : questionnaireService.getQuestionList().entrySet()) {

            printQuestion(tempMap.getKey(), tempMap.getValue());

            int answerId = getAnswerId(tempMap.getValue());

            checkAnswerResult(answerId, tempMap.getValue());

            consoleService.printString("");

        }
    }

    private void printQuestion(String question, List<Answer> answerList) {
        consoleService.printString(question);

        consoleService.printString("Варианты ответа: ");

        for(int i = 0; i < answerList.size(); i++) {
            consoleService.printString((i + 1) + ": " + answerList.get(i).getAnswer());
        }
    }

    private int getAnswerId(List<Answer> answerList) {
        int answerId = 0;
        while (answerId < 1 || answerId > answerList.size()) {
            consoleService.printString("Выберите номер ответа (от 1 до " + (answerList.size() ) + "):");
            try {
                answerId = Integer.parseInt(consoleService.getString());
            } catch (NumberFormatException e) {

            }
        }

        return answerId;
    }

    private void checkAnswerResult(int answerId, List<Answer> answerList) {
        if (answerList.get(answerId - 1).getRight()) {
            profile.setRightAnswer(profile.getRightAnswer() + 1);
            profile.setPoints(profile.getPoints() + 2);
        }
    }

    private void testingResult() {
        consoleService.printString("Имя: " + profile.getName());
        consoleService.printString("Фамилия: " + profile.getSurname());
        consoleService.printString("Кол-во правильных ответов: " + profile.getRightAnswer() + "/" + questionnaireService.getQuestionList().size());
        consoleService.printString("Кол-во очков: " + profile.getPoints());

    }

    private MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("application");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
