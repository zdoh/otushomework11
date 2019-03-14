package ru.zdoher.hw.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс Profile")
class ProfileTest {

    @Test
    @DisplayName("корректно создается")
    void profileCreateAndGet() {
        Profile profile = new Profile("Name", "Surname", 6, 3);

        assertAll(
                () -> assertEquals("Name", profile.getName()),
                () -> assertEquals("Surname", profile.getSurname()),
                () -> assertEquals(6, profile.getPoints()),
                () -> assertEquals(3, profile.getRightAnswer())
        );
    }

}
