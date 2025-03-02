package com.maa.test.tennis_scorer.utils;

import com.maa.test.tennis_scorer.enums.GameState;
import com.maa.test.tennis_scorer.enums.Score;
import com.maa.test.tennis_scorer.model.Player;

public class ScoreCalculator {

    public static void calculateScore(String input) {
        validateInput(input);

        Player playerA = new Player();
        Player playerB = new Player();
        GameState gameState = GameState.IN_PROGRESS;

        for (char c : input.toCharArray()) {

            if (c == 'A') {
                gameState = updateGameState(playerA, playerB, gameState, "A");
            } else if (c == 'B') {
                gameState = updateGameState(playerB, playerA, gameState, "B");
            }

            if (gameState != GameState.GAME_OVER) {
                System.out.println(formatScore(playerA, playerB, gameState));
            }

            if (gameState == GameState.GAME_OVER) {
                System.out.println("Player " + (c == 'A' ? "A" : "B") + " wins the game");
                break;
            }
        }
    }

    private static GameState updateGameState(Player winner, Player opponent, GameState currentState, String winnerName) {
        if (currentState == GameState.DEUCE) {
            // If deuce, give advantage to the winner
            return winnerName.equals("A") ? GameState.ADVANTAGE_A : GameState.ADVANTAGE_B;
        } else if (currentState == GameState.ADVANTAGE_A || currentState == GameState.ADVANTAGE_B) {
            if ((currentState == GameState.ADVANTAGE_A && winnerName.equals("A")) ||
                    (currentState == GameState.ADVANTAGE_B && winnerName.equals("B"))) {
                // Winner already has advantage, so he wins the game
                return GameState.GAME_OVER;
            } else {
                // Opponent won the ball, go back to deuce
                return GameState.DEUCE;
            }
        } else {
            if (winner.getScore() == Score.FORTY && opponent.getScore() != Score.FORTY) {
                // Rule 1: Winner wins the game if his score is 40 and opponent's score is not 40
                return GameState.GAME_OVER;
            }
            winner.winBall();
            if (winner.getScore() == Score.FORTY && opponent.getScore() == Score.FORTY) {
                // Both players are at 40, enter deuce state
                return GameState.DEUCE;
            }
        }

        return GameState.IN_PROGRESS;
    }

    private static String formatScore(Player playerA, Player playerB, GameState gameState) {
        if (gameState == GameState.ADVANTAGE_A) {
            return "Player A : Advantage / Player B : " + playerB;
        } else if (gameState == GameState.ADVANTAGE_B) {
            return "Player A : " + playerA + " / Player B : Advantage";
        } else {
            return "Player A : " + playerA + " / Player B : " + playerB;
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
