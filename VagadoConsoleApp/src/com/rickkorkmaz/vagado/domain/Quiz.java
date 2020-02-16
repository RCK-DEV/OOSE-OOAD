package com.rickkorkmaz.vagado.domain;

import java.util.List;

public class Quiz {
    private static final String SELECTEER_VRAGENLIJST = "Selecteer een vragenlijst om te spelen:";
    private static final String SELECTEER_VRAGENLIJST_ITEM_FORMAT = "\n%s: %s - %s";
    private static final String SCORE_OVERZICHT_FORMAT =
            "Aantal vragen goed beantwoord: %s\n" +
            "Aantal punten verdiend: %s\n" +
            "Aantal munten verdiend: %s\n" +
            "Totale tijd: %s s\n" +
            "Huidige muntensaldo: %s\n" +
             "Lifetime best: %s\n";

    private int aantalVragen;
    private int aantalVragenBeantwoord;
    private int aantalVragenGoedBeantwoord;
    private long startTijd;
    private float totaleTijd;
    private int verdiendePunten;
    private int verdiendeMunten;

    private Vraag huidigeVraag;
    private Vragenlijst huidigeVragenlijst;
    private List<Vragenlijst> spelerVragenlijsten;
    private PuntenTelling puntenTelling;
    private SpelerAccount speler;

    public Quiz(int aantalVragen, SpelerAccount speler, PuntenTelling puntenTelling) {
        this.aantalVragen = aantalVragen;
        this.speler = speler;
        this.puntenTelling = puntenTelling;
        reset();
    }

    public String initialiseerQuiz() {
        reset();
        String selecteerVragenlijstBericht = SELECTEER_VRAGENLIJST;

        this.spelerVragenlijsten = speler.getActieveVragenlijsten();

        for (int i = 0; i < spelerVragenlijsten.size(); i++) {
            Vragenlijst vragenlijst = spelerVragenlijsten.get(i);
            selecteerVragenlijstBericht = selecteerVragenlijstBericht
                    .concat(String.format(SELECTEER_VRAGENLIJST_ITEM_FORMAT,
                            i,
                            vragenlijst.getThema(),
                            vragenlijst.getOnderwerp()));
        }

        return selecteerVragenlijstBericht;
    }

    public void setHuidigeVragenlijst(int vragenLijstIndex) {
        this.huidigeVragenlijst = this.spelerVragenlijsten.get(vragenLijstIndex);
    }

    public void startQuiz() {
        startTimer();
    }

    public void setEerstvolgendeVraag() {
        huidigeVraag = huidigeVragenlijst.getVragen().get(aantalVragenBeantwoord);
        aantalVragenBeantwoord++;
    }

    public boolean heeftVolgendeVraag() {
        boolean result = aantalVragenBeantwoord < aantalVragen;
        if (!result) {
            stopTimer();
        }
        return result;
    }

    public Vraag getHuidigeVraag() {
        return huidigeVraag;
    }

    public void beantwoordVraag(String antwoord) {
        boolean correctAntwoord = huidigeVraag.controleerAntwoord(antwoord);
        if (correctAntwoord) {
            registreerGoedBeantwoordVraag();
        }
    }

    public String getScore() {
        verdiendePunten = puntenTelling.bereken(aantalVragenGoedBeantwoord, aantalVragen, totaleTijd);
        verdiendeMunten = getMuntenTelling();
        speler.voegMuntenToe(verdiendeMunten);
        speler.addLifetimeBest(huidigeVragenlijst, totaleTijd, verdiendePunten);
        LifetimeBest currentLifetimeBest = speler.getLifetimeBest(huidigeVragenlijst);

        speler.updateSpeler();

        return String.format(
                SCORE_OVERZICHT_FORMAT,
                aantalVragenGoedBeantwoord,
                verdiendePunten,
                verdiendeMunten,
                totaleTijd,
                speler.getMuntenSaldo(),
                currentLifetimeBest);
    }

    public List<Vragenlijst> getSpelerVragenlijsten() {
        return speler.getActieveVragenlijsten();
    }

    public String getHuidigePuntenTelling() {
        return puntenTelling.toString();
    }

    public void setPuntenTelling(String puntenTellingKeuze) {
        PuntenTellingFactory factory = new PuntenTellingFactory();
        puntenTelling = factory.getPuntenTelling(puntenTellingKeuze);
    }

    private void registreerGoedBeantwoordVraag(){
        aantalVragenGoedBeantwoord++;
    }

    private int getMuntenTelling() {
        int aantalVerdiendeMunten = 0;

        if (aantalVragen == aantalVragenGoedBeantwoord) {
            aantalVerdiendeMunten = 2;
        }

        return aantalVerdiendeMunten;
    }

    private void reset() {
        this.aantalVragenBeantwoord = 0;
        this.aantalVragenGoedBeantwoord = 0;
        this.totaleTijd = 0;
        this.verdiendePunten = 0;
        this.verdiendeMunten = 0;
    }

    private void startTimer() {
        startTijd = System.currentTimeMillis();
    }

    private void stopTimer() {
        long finishedTime = System.currentTimeMillis();
        totaleTijd = ((finishedTime - startTijd) / 1000f);
    }
}
