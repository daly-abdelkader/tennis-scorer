package com.maa.test.tennis_scorer.enums;

public enum Score {

    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40");

    private final String value;

    Score(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
