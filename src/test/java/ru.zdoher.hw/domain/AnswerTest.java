package ru.zdoher.hw.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс AnswerTest")
class AnswerTest {
    @Test
    @DisplayName("корректно создается")
    void profileCreateAndGet() {
        Answer answer = new Answer("Answer", true);

        assertAll(
                () -> assertEquals("Answer", answer.getAnswer()),
                () -> assertEquals(true, answer.getRight())
        );
    }

}