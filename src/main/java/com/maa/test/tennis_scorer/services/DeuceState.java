package com.maa.test.tennis_scorer.services;

import com.maa.test.tennis_scorer.model.Player;

public class DeuceState  implements GameState{

    @Override
    public void handleBallWon(Player winner, Player opponent, GameContext context) {
        // If deuce, give advantage to the winner
        context.setGameState(winner == context.getPlayerA() ? new AdvantageAState() : new AdvantageBState());
    }

    @Override
    public String formatScore(Player playerA, Player playerB) {
        return "Player A : 40 / Player B : 40";
    }
}
