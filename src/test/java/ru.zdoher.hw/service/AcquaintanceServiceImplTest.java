package ru.zdoher.hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import ru.zdoher.hw.domain.Profile;

import java.io.BufferedReader;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AcquaintanceServiceImplTest {

    @Mock
    private ConsoleService consoleService;

    private AcquaintanceService acquaintanceService;

    @BeforeEach
    void setUp() {
        acquaintanceService = new AcquaintanceServiceImpl(consoleService);
    }

    @Test
    void makeAcquantance() {
        Profile profile = new Profile();
        when(consoleService.getString()).thenReturn("Name").thenReturn("Surname");
        acquaintanceService.makeAcquantance(profile);

        assertAll(
                () -> assertEquals("Name", profile.getName()),
                () -> assertEquals("Surname", profile.getSurname())
        );

    }
}