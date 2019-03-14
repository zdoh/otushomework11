package ru.zdoher.hw.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@PropertySource("classpath:application.properties")
@Service
public class LocalizationServiceImpl implements LocalizationService {

    private final Locale locale;

    private String fileNameMes;

    private MessageSource ms;

    public LocalizationServiceImpl(MessageSource ms,
                                   @Value("${locale}") Locale locale,
                                   @Value("${file}") String fileNameMes) {
        this.ms = ms;
        this.locale = locale;
        this.fileNameMes = locale + "_" + fileNameMes;
    }


    public String getMessage(String field) {
        return ms.getMessage(field, null, locale);
    }

    public String getQuizFilename() {
        return fileNameMes;
    }
}
