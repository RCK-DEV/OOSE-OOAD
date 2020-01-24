package com.rickkorkmaz.mastermindgame;

public class MastermindGame {
    private ColorCombination secretCode;
    private ColorCombination guess;
    private Hint hint;
    private int turn;
    private int maxTurn;
    private boolean won;

    public MastermindGame() {
        startNewGame();
    }

    public void checkCombination(String guessAsString) {

        guess = new ColorCombination(guessAsString);
        hint = secretCode.compareWith(guess);

        System.out.println("right colour right position = " + hint.getCorrect());
        System.out.println("right colour wrong position = " + hint.getSemiCorrect());

        if (hint.getCorrect() == 4) {
            System.out.println("You’ve found the secret code. Congrats!");
            won = true;
        }

    }

    public void startNewGame() {
        secretCode = new ColorCombination("BRBY");
        turn = 0;
        won = false;
        maxTurn = 8;
        System.out.println("Welcome to mastermind. Try to find the secret code.");
    }

    public boolean currentlyPlaying() {
        return !won || turn != maxTurn;
    }
}
