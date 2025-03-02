package com.maa.test.tennis_scorer.services;

import com.maa.test.tennis_scorer.model.Player;

public class AdvantageAState implements GameState{

    @Override
    public void handleBallWon(Player winner, Player opponent, GameContext context) {
        if (winner == context.getPlayerA()) {
            // Player A already has advantage, so they win the game
            context.setGameState(new GameOverState(context.getPlayerA()));
        } else {
            // Opponent won the ball, go back to deuce
            context.setGameState(new DeuceState());
        }
    }

    @Override
    public String formatScore(Player playerA, Player playerB) {
        return "Player A : Advantage / Player B : " + playerB;
    }
}
