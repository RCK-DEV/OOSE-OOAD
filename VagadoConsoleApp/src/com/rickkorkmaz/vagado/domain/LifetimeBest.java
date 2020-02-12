package com.rickkorkmaz.vagado.domain;

public class LifetimeBest{
    private Vragenlijst vragenlijst;
    private float totaleTijd;
    private int verdiendePunten;

    public LifetimeBest(Vragenlijst vragenlijst, float totaleTijd, int verdiendePunten) {
        this.vragenlijst = vragenlijst;
        this.totaleTijd = totaleTijd;
        this.verdiendePunten = verdiendePunten;
    }

    public void updateLifetimeBest(float totaleTijd, int verdiendePunten) {
        if (this.totaleTijd > totaleTijd && this.verdiendePunten < verdiendePunten) {
            this.totaleTijd = totaleTijd;
            this.verdiendePunten = verdiendePunten;
        }
    }

    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }

    @Override
    public String toString() {
        return "" + totaleTijd +"s, "+ verdiendePunten + " punten";
    }
}
