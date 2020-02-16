package com.rickkorkmaz.vagado.domain;

public class StandaardPuntenTelling implements PuntenTelling {

    @Override
    public int bereken(int aantalVragenGoedBeantwoord, int aantalVragen, float totaleTijd) {
        int verdiendePunten = 0;

        int aantalPuntenPerGoedBeantwoordeVraag = 2;
        int aantalPuntenVoorAlleVragenGoedBeantwoord = 20;
        float bonusTijdslimiet = 120f;
        int bonusPuntenTijdslimiet = 5;

        if (aantalVragenGoedBeantwoord == aantalVragen) {
            verdiendePunten += aantalPuntenVoorAlleVragenGoedBeantwoord;
        }

        if (aantalVragenGoedBeantwoord > 0 && totaleTijd <= bonusTijdslimiet) {
            verdiendePunten += bonusPuntenTijdslimiet;
        }

        verdiendePunten += aantalVragenGoedBeantwoord * aantalPuntenPerGoedBeantwoordeVraag;

        return verdiendePunten;
    }

    @Override
    public String toString() {
        return "Standaard";
    }
}
