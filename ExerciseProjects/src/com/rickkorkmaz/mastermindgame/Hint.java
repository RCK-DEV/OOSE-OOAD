package com.rickkorkmaz.mastermindgame;

public class Hint {
    private int correct;
    private int semiCorrect;

    public Hint(int correct, int semiCorrect) {
        this.correct = correct;
        this.semiCorrect = semiCorrect;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getSemiCorrect() {
        return semiCorrect;
    }

    public void setSemiCorrect(int semiCorrect) {
        this.semiCorrect = semiCorrect;
    }
}
