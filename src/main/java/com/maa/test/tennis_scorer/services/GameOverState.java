package com.maa.test.tennis_scorer.services;

import com.maa.test.tennis_scorer.model.Player;

public class GameOverState implements GameState{

    private final Player winner;

    public GameOverState(Player winner) {
        this.winner = winner;
    }

    @Override
    public void handleBallWon(Player winner, Player opponent, GameContext context) {
        // Do nothing; the game is over
    }

    @Override
    public String formatScore(Player playerA, Player playerB) {
        return "Player " + (winner == playerA ? "A" : "B") + " wins the game";
    }
}
