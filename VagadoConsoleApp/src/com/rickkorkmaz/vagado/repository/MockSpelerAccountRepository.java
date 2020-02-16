package com.rickkorkmaz.vagado.repository;

import com.rickkorkmaz.vagado.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Not all methods in Design Class Diagram are implemented
 * since it isn't required to play a demo game.
 */
public class MockSpelerAccountRepository implements SpelerAccountRepository {
    @Override
    public List<Aanschaffing> getAanschaffingen(SpelerAccount speler) {

        List<MeerkeuzeAntwoord> antwoordList1 = new ArrayList<>();
        antwoordList1.add(new MeerkeuzeAntwoord("La Pulga", true));
        antwoordList1.add(new MeerkeuzeAntwoord("El Doro", false));
        antwoordList1.add(new MeerkeuzeAntwoord("Paco Bell", false));
        antwoordList1.add(new MeerkeuzeAntwoord("Gino", false));
        Vraag vraag1 = new MeerkeuzeVraag("Wat is de bijnaam van Lionel Messi?", antwoordList1);

        List<OpenVraagAntwoord> antwoordList2 = new ArrayList<>();
        antwoordList2.add(new OpenVraagAntwoord("USSR"));
        Vraag vraag2 = new OpenVraag("Tegen welk land scoorde Marco van Basten met een magistrale volley op het EK van 1988?", antwoordList2);

        List<MeerkeuzeAntwoord> antwoordList3 = new ArrayList<>();
        antwoordList3.add(new MeerkeuzeAntwoord("Ronaldo Esxo", false));
        antwoordList3.add(new MeerkeuzeAntwoord("Michael Boomer", false));
        antwoordList3.add(new MeerkeuzeAntwoord("James Rodriquez", true));
        antwoordList3.add(new MeerkeuzeAntwoord("Hans Avisch", false));
        Vraag vraag3 = new MeerkeuzeVraag("Wie was in 2014 de topscoorder op het WK voetbal in Brazilië?", antwoordList3);

        List<OpenVraagAntwoord> antwoordList4 = new ArrayList<>();
        antwoordList4.add(new OpenVraagAntwoord("Highbury"));
        Vraag vraag4 = new OpenVraag("Hoe heette het voormalige stadion van Arsenal?", antwoordList4);

        List<Vraag> vragen1 = new ArrayList<>();
        List<Vraag> vragen2 = new ArrayList<>();
        vragen1.add(vraag1);
        vragen1.add(vraag2);
        vragen1.add(vraag3);
        vragen1.add(vraag4);

        Vragenlijst vragenlijst1 = new Vragenlijst("Sport", "Voetbal", vragen1, "NL");
        Vragenlijst vragenlijst2 = new Vragenlijst("Sport", "Tennis", vragen2, "NL");

        Product product1 = new Product(10, vragenlijst1);
        Product product2 = new Product(10, vragenlijst2);

        Aanschaffing aanschaffing1 = new Aanschaffing("01/01/2021", product1);
        Aanschaffing aanschaffing2 = new Aanschaffing("01/01/2021", product2);

        List<Aanschaffing> aanschaffingen = new ArrayList<>();

        aanschaffingen.add(aanschaffing1);
        aanschaffingen.add(aanschaffing2);

        return aanschaffingen;
    }

    @Override
    public List<LifetimeBest> getLifetimeBest(SpelerAccount speler) {

        Vragenlijst vragenlijst1 = new Vragenlijst("Sport", "Voetbal", null, "NL");

        List<LifetimeBest> lifetimeBests = new ArrayList<>();

        LifetimeBest lifetimeBest1 = new LifetimeBest(vragenlijst1, 30.3f, 2);
        lifetimeBests.add(lifetimeBest1);

        return lifetimeBests;
    }

    @Override
    public int getMuntenSaldo(SpelerAccount speler) {
        // TODO: Not implemented. Not required for demo.
        return 0;
    }

    @Override
    public void updateSpeler(SpelerAccount speler) {
        // TODO: Not implemented. Not required for demo.
    }
}
