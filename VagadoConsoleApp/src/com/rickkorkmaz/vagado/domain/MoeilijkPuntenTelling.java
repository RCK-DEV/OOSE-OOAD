package com.rickkorkmaz.vagado.domain;

public class MoeilijkPuntenTelling implements PuntenTelling {

    @Override
    public int bereken(int aantalVragenGoedBeantwoord, int aantalVragen, float totaleTijd) {
        int verdiendePunten = 0;

        int aantalPuntenPerGoedBeantwoordeVraag = 1;
        int aantalPuntenVoorAlleVragenGoedBeantwoord = 10;
        float bonusTijdslimiet = 30f;
        int bonusPuntenTijdslimiet = 20;

        if (aantalVragenGoedBeantwoord == aantalVragen) {
            verdiendePunten += aantalPuntenVoorAlleVragenGoedBeantwoord;
        }

        if (totaleTijd <= bonusTijdslimiet) {
            verdiendePunten += bonusPuntenTijdslimiet;
        }

        verdiendePunten += aantalVragenGoedBeantwoord * aantalPuntenPerGoedBeantwoordeVraag;

        return verdiendePunten;
    }

    @Override
    public String toString() {
        return "Moeilijk";
    }
}
