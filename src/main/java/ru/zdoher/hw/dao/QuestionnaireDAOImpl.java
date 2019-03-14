package ru.zdoher.hw.dao;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zdoher.hw.domain.Answer;
import ru.zdoher.hw.service.LocalizationService;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


@Service
public class QuestionnaireDAOImpl implements QuestionnaireDAO {
    private Map<String, List<Answer>> questions = new HashMap<>();

    private LocalizationService localizationService;

    @PostConstruct
    public void init() throws IOException {

        File file = new File(Objects.requireNonNull(
                getClass().getClassLoader().getResource(localizationService.getQuizFilename())).getFile()
        );

        CSVReader csvReader = new CSVReader(new FileReader(file));
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            if(nextRecord.length >= 3) {
                List<Answer> answerList = new ArrayList<>();
                answerList.add(new Answer(nextRecord[1], true));

                for (int i = 2; i < nextRecord.length; i++) {
                    answerList.add(new Answer(nextRecord[i], false));
                }

                Collections.shuffle(answerList);

                questions.put(nextRecord[0], answerList);
            }
        }
    }

    public QuestionnaireDAOImpl(LocalizationService localizationService) {
        this.localizationService = localizationService;

    }


    @Override
    public Map<String, List<Answer>> getQuestionList() {
        return questions;
    }

}
