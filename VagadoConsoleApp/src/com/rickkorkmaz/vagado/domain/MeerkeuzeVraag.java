package com.rickkorkmaz.vagado.domain;

import java.util.List;

public class MeerkeuzeVraag extends Vraag<MeerkeuzeAntwoord> {

    public MeerkeuzeVraag(String vraag, List<MeerkeuzeAntwoord> antwoorden) {
        super(vraag);
        this.antwoorden = antwoorden;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        boolean result = false;
        try{
            int antwoordIndex = Integer.parseInt(antwoord);
            if (antwoordIndex >= 0 && antwoordIndex < antwoorden.size()) {
                MeerkeuzeAntwoord gegevenAntwoord = antwoorden.get(antwoordIndex);
                if (gegevenAntwoord.isCorrect()) {
                    result = true;
                }
            }
        } catch (NumberFormatException ignored) { }

        return result;
    }
}
