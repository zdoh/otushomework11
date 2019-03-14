package ru.zdoher.hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.zdoher.hw.dao.QuestionnaireDAO;
import ru.zdoher.hw.domain.Answer;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QuestionnaireServiceImplTest {

    @Mock
    private QuestionnaireDAO questionnaireDAO;

    private QuestionnaireService questionnaireService;

    @BeforeEach
    void setUp() {
        questionnaireService = new QuestionnaireServiceImpl(questionnaireDAO);
    }

    @Test
    @DisplayName("Сервис QuestionnaireServiceImplTest")
    void getQuestionList() {
        Map<String, List<Answer>> testQuesDAO = new HashMap<>();
        testQuesDAO.put("Question1", new ArrayList<>(Arrays.asList(
                new Answer("answer1", true),
                new Answer("answer2", false))));

        given(questionnaireDAO.getQuestionList()).willReturn(testQuesDAO);

        assertAll(
                () -> assertThat(questionnaireService.getQuestionList()).containsKeys("Question1"),
                () -> assertEquals(2, questionnaireService.getQuestionList().get("Question1").size())
        );
    }
}