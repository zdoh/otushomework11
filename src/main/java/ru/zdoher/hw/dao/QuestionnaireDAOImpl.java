package ru.zdoher.hw.dao;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import ru.zdoher.hw.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionnaireDAOImpl implements QuestionnaireDAO {
    private List<Question> questions = new ArrayList<>();

    public QuestionnaireDAOImpl(String file) throws IOException {
        CsvToBean csvToBean = new CsvToBean();
        CSVReader csvReader = new CSVReader(new FileReader(file));
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Question.class);
        String[] columns = new String[] {"id","question", "answer"};
        strategy.setColumnMapping(columns);


        List list = csvToBean.parse(strategy, csvReader);
        for(Object object : list) {
            questions.add((Question) object);
        }

        Collections.shuffle(questions);

    }

    @Override
    public List<Question> getQuistionList() {
        return questions;
    }


    public void printList() {
        for (Question question : questions) {
            System.out.println(question);
        }
    }
}
