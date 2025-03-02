package com.maa.test.tennis_scorer.utils;

import com.maa.test.tennis_scorer.services.GameContext;
import com.maa.test.tennis_scorer.services.GameOverState;

public class ScoreCalculator {

    public static void calculateScore(String input) {
        validateInput(input);

        GameContext game = new GameContext();

        for (char c : input.toCharArray()) {
            game.handleBallWon(c);
            System.out.println(game.getFormattedScore());

            if (game.getGameState() instanceof GameOverState) {
                break;
            }
        }
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        for (char c : input.toCharArray()) {
            if (c != 'A' && c != 'B') {
                throw new IllegalArgumentException("Invalid character in input: " + c);
            }
        }
    }

    private ScoreCalculator() {
    }
}
