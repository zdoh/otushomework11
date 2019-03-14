package ru.zdoher.hw.dao;

import ru.zdoher.hw.domain.Answer;

import java.util.List;
import java.util.Map;

public interface QuestionnaireDAO {

    Map<String, List<Answer>> getQuestionList();
}
