package ru.zdoher.hw.service;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import ru.zdoher.hw.domain.Profile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AcquaintanceServiceImplTest {

    @Mock
    private ConsoleService consoleService;

    @Mock
    private LocalizationService localizationService;

    private AcquaintanceService acquaintanceService;

    @BeforeEach
    void setUp() {
        acquaintanceService = new AcquaintanceServiceImpl(consoleService, localizationService);
    }

    @Test
    void makeAcquantance() {
        Profile profile = new Profile();
        when(consoleService.getString()).thenReturn("Name").thenReturn("Surname");
        when(localizationService.getMessage(any())).thenReturn("a").thenReturn("b").thenReturn("c");
        acquaintanceService.makeAcquantance(profile);

        assertAll(
                () -> assertEquals("Name", profile.getName()),
                () -> assertEquals("Surname", profile.getSurname())
        );

    }
}