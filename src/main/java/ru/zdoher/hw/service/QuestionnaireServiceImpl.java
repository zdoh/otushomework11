package ru.zdoher.hw.service;

import ru.zdoher.hw.dao.QuestionnaireDAO;
import ru.zdoher.hw.domain.Question;

import java.util.List;

public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireDAO questionnaireDAO;

    public QuestionnaireServiceImpl(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    @Override
    public List<Question> getQuestionList() {
        return questionnaireDAO.getQuistionList();
    }
}
