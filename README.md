# tennis-scorer
# Overview
This application simulates a simple tennis scoring system based on the rules of tennis. It takes a string input representing the sequence of points won by two players (A and B) and calculates the scores after each point. The program also determines the winner of the game and handles special cases like "Deuce" and "Advantage."

The application adheres to the following rules:

1) Each player starts with 0 points.
2) Winning a ball increases the player's score as follows:
    -  First ball: 15 points
    -  Second ball: 30 points
    -  Third ball: 40 points
3) If a player has 40 points and wins the next ball, they win the game unless the opponent also has 40 points (Deuce).
4) In the case of Deuce:
    -  The next point grants "Advantage" to the winner.
    -  If the player with Advantage wins the next point, they win the game.
    -  If the opponent wins the next point, the game returns to Deuce.
# Features
  -  Validates input to ensure it contains only valid characters (A or B).
  -  Handles edge cases like invalid input, empty strings, and null values.
  -  Prints the score after each point and declares the winner when the game ends.
  -  Supports scenarios involving "Deuce" and "Advantage."
# Prerequisites
To run this application, you need:
    -  Java 17 or higher installed on your system.
    -  A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a terminal for running the code.
# Usage
## Input Format
Provide a string where:
    -  'A' represents Player A winning a point.
    -  'B' represents Player B winning a point.
    Example input: "ABABAA"

## Running the Application
Run the TennisScorerApplication.main method that run calculateScore method with the input string

## Example Output
For the input "ABABAA", the output will be:
    Player A : 15 / Player B : 0
    Player A : 15 / Player B : 15
    Player A : 30 / Player B : 15
    Player A : 30 / Player B : 30
    Player A : 40 / Player B : 30
    Player A wins the game

# Implementation Details
## Classes and Methods
ScoreCalculator :
Contains the main logic for calculating scores and determining the winner.

Key methods:
  -  calculateScore(String input): Processes the input and prints the scores.
  -  updateGameState(...): Updates the game state based on the current scores.
  -  formatScore(...): Formats the score for display.
  -  validateInput(String input): Validates the input string.

Enums :
  -  Score: Represents the possible scores (0, 15, 30, 40).
  -  GameState: Represents the game states (IN_PROGRESS, DEUCE, ADVANTAGE_A, ADVANTAGE_B, GAME_OVER).

Player Class :
Encapsulates the state of a player, including their score.
