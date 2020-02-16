package com.rickkorkmaz.vagado.domain;

import com.rickkorkmaz.vagado.repository.SpelerAccountRepository;

import java.util.ArrayList;
import java.util.List;

public class SpelerAccount extends Account {
    private int muntenSaldo;
    private List<LifetimeBest> lifetimeBests;
    private List<Aanschaffing> aanschaffingen;
    SpelerAccountRepository repository;

    public SpelerAccount(int muntenSaldo, String gebruikersnaam, String wachtwoord, boolean ingelogd, SpelerAccountRepository repository) {
        super(gebruikersnaam, wachtwoord, ingelogd);
        this.muntenSaldo = muntenSaldo;
        this.lifetimeBests = new ArrayList<>();
        this.repository = repository;
        this.aanschaffingen = repository.getAanschaffingen(this);
        this.lifetimeBests = repository.getLifetimeBest(this);
    }

    public List<Vragenlijst> getActieveVragenlijsten() {
        List<Vragenlijst> vragenlijst = new ArrayList<>();
        for (Aanschaffing aanschaffing : aanschaffingen) {
            boolean actief = aanschaffing.isActief();
            if (actief) {
                vragenlijst.add(aanschaffing.getVragenlijst());
            }
        }
        return vragenlijst;
    }

    public void addLifetimeBest(Vragenlijst vragenlijst, float totaleTijd, int verdiendePunten) {
        LifetimeBest lifetimeBest = getLifetimeBest(vragenlijst);
        if (lifetimeBest == null) {
            lifetimeBests.add(new LifetimeBest(vragenlijst, totaleTijd, verdiendePunten));
        } else {
            lifetimeBest.updateLifetimeBest(totaleTijd, verdiendePunten);
        }
    }

    public LifetimeBest getLifetimeBest(Vragenlijst vragenlijst) {
        for (LifetimeBest lifetimeBest : lifetimeBests) {
            if (lifetimeBest.getVragenlijst().equals(vragenlijst)) {
                return lifetimeBest;
            }
        }
        return null;
    }

    public void voegMuntenToe(int munten) {
        muntenSaldo += munten;
    }

    public void updateSpeler() {
        this.muntenSaldo = repository.getMuntenSaldo(this);
        this.aanschaffingen = repository.getAanschaffingen(this);
        this.lifetimeBests = repository.getLifetimeBest(this);
    }

    public void updateSpelerRepository() {
        repository.updateSpeler(this);
    }

    public int getMuntenSaldo() {
        return muntenSaldo;
    }
}
