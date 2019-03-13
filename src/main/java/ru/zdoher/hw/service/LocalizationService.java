package ru.zdoher.hw.service;

import org.springframework.context.MessageSource;

public interface LocalizationService {

    //MessageSource messageSourse();

    String getMessage(String message);
}
