package ru.zdoher.hw.view;

import org.springframework.stereotype.Service;
import ru.zdoher.hw.domain.Answer;
import ru.zdoher.hw.domain.Profile;
import ru.zdoher.hw.service.AcquaintanceService;
import ru.zdoher.hw.service.ConsoleService;
import ru.zdoher.hw.service.LocalizationService;
import ru.zdoher.hw.service.QuestionnaireService;

import java.util.List;
import java.util.Map;

@Service
public class TestingImpl implements Testing {
    private final QuestionnaireService questionnaireService;
    private final AcquaintanceService acquaintanceService;
    private final ConsoleService consoleService;
    private final LocalizationService localizationService;

    private Profile profile = new Profile();

    public TestingImpl(QuestionnaireService questionnaireService,
                       AcquaintanceService acquaintanceService,
                       ConsoleService consoleService,
                       LocalizationService localizationService) {
        this.questionnaireService = questionnaireService;
        this.acquaintanceService = acquaintanceService;
        this.consoleService = consoleService;
        this.localizationService = localizationService;
    }

    @Override
    public void doTest()  {
        acquaintanceService.makeAcquantance(profile);
        consoleService.printString(localizationService.getMessage("message.beginTesting"));
        testing();
        consoleService.printString(localizationService.getMessage("message.endTesting"));
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

        consoleService.printString(localizationService.getMessage("message.answerVariant"));

        for(int i = 0; i < answerList.size(); i++) {
            consoleService.printString((i + 1) + ": " + answerList.get(i).getAnswer());
        }
    }

    private int getAnswerId(List<Answer> answerList) {
        int answerId = 0;
        while (answerId < 1 || answerId > answerList.size()) {
            consoleService.printString(localizationService.getMessage("message.answerChoose") + " " + (answerList.size() ) + "):");
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
        consoleService.printString(localizationService.getMessage("message.resultName") + profile.getName());
        consoleService.printString(localizationService.getMessage("message.resultSurname") + profile.getSurname());
        consoleService.printString(localizationService.getMessage("message.resultCorrectAnswerNumber") + profile.getRightAnswer() + "/" + questionnaireService.getQuestionList().size());
        consoleService.printString(localizationService.getMessage("message.resultPointCount") + profile.getPoints());

    }


}
