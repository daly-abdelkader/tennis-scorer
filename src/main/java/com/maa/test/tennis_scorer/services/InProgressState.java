package com.maa.test.tennis_scorer.services;

import com.maa.test.tennis_scorer.enums.Score;
import com.maa.test.tennis_scorer.model.Player;

public class InProgressState implements GameState{

    @Override
    public void handleBallWon(Player winner, Player opponent, GameContext context) {

        if (winner.getScore() == Score.FORTY && opponent.getScore() != Score.FORTY) {
            // Rule 1: Winner wins the game if their score is 40 and opponent's score is not 40
            context.setGameState(new GameOverState(winner));
            return;
        }

        winner.winBall();
        if (winner.getScore() == Score.FORTY && opponent.getScore() == Score.FORTY) {
            // Both players are at 40, enter deuce state
            context.setGameState(new DeuceState());
        }
    }

    @Override
    public String formatScore(Player playerA, Player playerB) {
        return "Player A : " + playerA + " / Player B : " + playerB;
    }
}
