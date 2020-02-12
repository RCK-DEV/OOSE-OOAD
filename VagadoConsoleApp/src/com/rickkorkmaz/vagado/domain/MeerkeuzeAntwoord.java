package com.rickkorkmaz.vagado.domain;

public class MeerkeuzeAntwoord extends Antwoord {
    private boolean isCorrect;

    public MeerkeuzeAntwoord(String antwoord, boolean isCorrect) {
        super(antwoord);
        this.isCorrect = isCorrect;
    }

    @Override
    public boolean controleerAntwoord(String answer) {
        return antwoord.equalsIgnoreCase(answer) && isCorrect;
    }

    public boolean isCorrect(){
        return isCorrect;
    }
}
