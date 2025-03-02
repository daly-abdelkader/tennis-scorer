package com.maa.test.tennis_scorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.maa.test.tennis_scorer.utils.ScoreCalculator.calculateScore;

public class TennisScorerApplication {

	public static void main(String[] args) {
		String input = "ABABABABBAAA";
		calculateScore(input);
	}

}
