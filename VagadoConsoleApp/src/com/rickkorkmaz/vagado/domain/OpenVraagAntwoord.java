package com.rickkorkmaz.vagado.domain;

public class OpenVraagAntwoord extends Antwoord {

    public OpenVraagAntwoord(String antwoord) {
        super(antwoord);
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return this.antwoord.equalsIgnoreCase(antwoord);
    }
}
