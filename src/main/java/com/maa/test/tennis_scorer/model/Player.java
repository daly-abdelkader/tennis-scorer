package com.maa.test.tennis_scorer.model;

import com.maa.test.tennis_scorer.enums.Score;

public class Player {

    private Score score = Score.ZERO;

    public void winBall() {
        if (score != Score.FORTY) {
            score = switch (score) {
                case ZERO -> Score.FIFTEEN;
                case FIFTEEN -> Score.THIRTY;
                case THIRTY -> Score.FORTY;
                default -> throw new IllegalStateException("Unexpected score: " + score);
            };
        }
    }

    @Override
    public String toString() {
        return score.toString();
    }

    public Score getScore() {
        return score;
    }
}
