package com.maa.test.tennis_scorer.services;

import com.maa.test.tennis_scorer.model.Player;

public interface GameState {

    void handleBallWon(Player winner, Player opponent, GameContext context);
    String formatScore(Player playerA, Player playerB);
}
