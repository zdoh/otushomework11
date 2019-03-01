package ru.zdoher.hw.service;

import ru.zdoher.hw.domain.Answer;

import java.util.List;
import java.util.Map;

public interface QuestionnaireService {

    Map<String, List<Answer>> getQuestionList();
}
