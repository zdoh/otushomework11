package ru.zdoher.hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@PropertySource("classpath:application.properties")
@Service
public class LocalizationServiceImpl implements LocalizationService {

    @Value("${locale}")
    private Locale locale;

    @Autowired
    private MessageSource ms;

    public LocalizationServiceImpl() {
    }


    public String getMessage(String field) {
        return ms.getMessage(field, null, locale);
    }
}
