package com.rickkorkmaz.vagado.domain;

public abstract class Antwoord {
    protected String antwoord;

    public Antwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    public abstract boolean controleerAntwoord(String antwoord);

    @Override
    public String toString() {
        return antwoord;
    }
}
