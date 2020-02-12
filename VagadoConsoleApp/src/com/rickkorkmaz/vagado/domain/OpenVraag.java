package com.rickkorkmaz.vagado.domain;

import java.util.List;

public class OpenVraag extends Vraag<OpenVraagAntwoord> {

    public OpenVraag(String vraag, List<OpenVraagAntwoord> antwoorden) {
        super(vraag);
        this.antwoorden = antwoorden;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        for (OpenVraagAntwoord a : antwoorden) {
            if (a.controleerAntwoord(antwoord)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return vraag;
    }
}
