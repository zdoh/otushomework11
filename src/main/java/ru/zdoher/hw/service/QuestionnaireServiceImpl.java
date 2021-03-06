package ru.zdoher.hw.service;

import org.springframework.stereotype.Service;
import ru.zdoher.hw.dao.QuestionnaireDAO;
import ru.zdoher.hw.domain.Answer;

import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireDAO questionnaireDAO;

    public QuestionnaireServiceImpl(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    @Override
    public Map<String, List<Answer>> getQuestionList() {
        return questionnaireDAO.getQuestionList();
    }
}
