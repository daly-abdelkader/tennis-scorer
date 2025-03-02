package com.maa.test.tennis_scorer.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoreCalculatorTest {

    @Test
    void testPlayerAWinsGameForValidInputWithoutDeuceAndAdvantageScenario() {
        String input = "ABABAA";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ScoreCalculator.calculateScore(input);
        StringBuilder expectedOuptutBuilder = new StringBuilder();
        expectedOuptutBuilder.append("Player A : 15 / Player B : 0").append(System.lineSeparator());
        expectedOuptutBuilder.append("Player A : 15 / Player B : 15").append(System.lineSeparator());
        expectedOuptutBuilder.append("Player A : 30 / Player B : 15").append(System.lineSeparator());
        expectedOuptutBuilder.append("Player A : 30 / Player B : 30").append(System.lineSeparator());
        expectedOuptutBuilder.append("Player A : 40 / Player B : 30").append(System.lineSeparator());
        expectedOuptutBuilder.append("Player A wins the game");

        String expectedOutput = expectedOuptutBuilder.toString();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }

    @Test
    void testPlayerBWinsGameForValidInputWithDeuceAndAdvantageScenario() {
        String input = "ABABABABBB";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ScoreCalculator.calculateScore(input);
        StringBuilder expectedOutputBuilder = new StringBuilder();
        expectedOutputBuilder.append("Player A : 15 / Player B : 0").append(System.lineSeparator());
        expectedOutputBuilder.append("Player A : 15 / Player B : 15").append(System.lineSeparator());
        expectedOutputBuilder.append("Player A : 30 / Player B : 15").append(System.lineSeparator());
        expectedOutputBuilder.append("Player A : 30 / Player B : 30").append(System.lineSeparator());
        expectedOutputBuilder.append("Player A : 40 / Player B : 30").append(System.lineSeparator());
        expectedOutputBuilder.append("Player A : 40 / Player B : 40").append(System.lineSeparator());
        expectedOutputBuilder.append("Player A : Advantage / Player B : 40").append(System.lineSeparator());
        expectedOutputBuilder.append("Player A : 40 / Player B : 40").append(System.lineSeparator());
        expectedOutputBuilder.append("Player A : 40 / Player B : Advantage").append(System.lineSeparator());
        expectedOutputBuilder.append("Player B wins the game");
        String expectedOutput = expectedOutputBuilder.toString();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }

    @Test
    void shouldThrowExceptionWhenInvalidInputNullValue() {
        String input = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ScoreCalculator.calculateScore(input);
        });
        assertEquals("Input cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenInvalidInputEmptyString() {
        String input = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ScoreCalculator.calculateScore(input);
        });
        assertEquals("Input cannot be null or empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenInvalidInputWithInvalidCharacter() {
        String input = "ABAC";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ScoreCalculator.calculateScore(input);
        });
        assertEquals("Invalid character in input: C", exception.getMessage());
    }
}
