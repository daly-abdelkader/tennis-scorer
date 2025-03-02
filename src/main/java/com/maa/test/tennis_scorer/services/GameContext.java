package com.maa.test.tennis_scorer.services;

import com.maa.test.tennis_scorer.model.Player;

public class GameContext {

    private GameState gameState;
    private final Player playerA;
    private final Player playerB;

    public GameContext() {
        this.playerA = new Player();
        this.playerB = new Player();
        this.gameState = new InProgressState();
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void handleBallWon(char c) {
        Player winner = (c == 'A') ? playerA : playerB;
        Player opponent = (c == 'A') ? playerB : playerA;
        gameState.handleBallWon(winner, opponent, this);
    }

    public String getFormattedScore() {
        return gameState.formatScore(playerA, playerB);
    }

    public GameState getGameState() {
        return gameState;
    }
}
