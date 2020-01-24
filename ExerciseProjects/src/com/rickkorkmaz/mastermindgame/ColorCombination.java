package com.rickkorkmaz.mastermindgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorCombination {
    private Peg[] pegs;

    public ColorCombination(String colorCombination) {
        String[] rawColors = colorCombination.split("");
        pegs = new Peg[rawColors.length];
        for (int i = 0; i < pegs.length; i++) {
            pegs[i] = new Peg(rawColors[i]);
        }
    }

    public Hint compareWith(ColorCombination guess) {
        int correct = determineRightColorRightPosition(guess);
        int semiCorrect = determineRightColorWrongPosition(guess, correct);
        return new Hint(correct, semiCorrect);
    }

    private int determineRightColorRightPosition(ColorCombination guess) {
        int totalCorrect = 0;
        for (int i = 0; i < pegs.length; i++) if (pegs[i].equals(guess.pegs[i])) totalCorrect++;
        return totalCorrect;
    }

    private int determineRightColorWrongPosition(ColorCombination guess, int correct) {
        List<Peg> pegList = new ArrayList<>(Arrays.asList(pegs));
        for (Peg i : guess.pegs) pegList.remove(i);
        return pegs.length - pegList.size() - correct;
    }

    @Override
    public String toString() {
        return "ColorCombination{" +
                "pegs=" + Arrays.toString(pegs) +
                '}';
    }
}
