package com.rickkorkmaz.vagado.domain;

import java.util.List;

public abstract class Vraag<T extends Antwoord> {
    protected String vraag;
    protected List<T> antwoorden;

    protected Vraag(String vraag) {
        this.vraag = vraag;
    }

    public abstract boolean controleerAntwoord(String antwoord);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(vraag);

        for (int i = 0; i < antwoorden.size(); i++) {
            sb.append(String.format("\n%s. %s", i, antwoorden.get(i)));
        }
        return sb.toString();
    }
}
