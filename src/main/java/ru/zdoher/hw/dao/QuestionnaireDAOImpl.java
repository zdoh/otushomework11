package ru.zdoher.hw.dao;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.zdoher.hw.domain.Answer;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


@PropertySource("classpath:application.properties")
@Service
public class QuestionnaireDAOImpl implements QuestionnaireDAO {
    private Map<String, List<Answer>> questions = new HashMap<>();

    @Value("${file.test}")
    private String csvFile;

    @PostConstruct
    public void init() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(csvFile));
        CSVReader csvReader = new CSVReader(reader);
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


    @Override
    public Map<String, List<Answer>> getQuistionList() {
        return questions;
    }

}
