package com.maa.test.tennis_scorer.services;

import com.maa.test.tennis_scorer.model.Player;

public class AdvantageBState implements GameState{

    @Override
    public void handleBallWon(Player winner, Player opponent, GameContext context) {
        if (winner == context.getPlayerB()) {
            // Player B already has advantage, so they win the game
            context.setGameState(new GameOverState(context.getPlayerB()));
        } else {
            // Opponent won the ball, go back to deuce
            context.setGameState(new DeuceState());
        }
    }

    @Override
    public String formatScore(Player playerA, Player playerB) {
        return "Player A : " + playerA + " / Player B : Advantage";
    }
}
