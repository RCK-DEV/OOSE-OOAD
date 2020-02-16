package com.rickkorkmaz.vagado.domain;

import java.util.List;

public class Vragenlijst {
    private String onderwerp;
    private String thema;
    private String land;

    private List<Vraag> vragen;

    public Vragenlijst(String onderwerp, String thema, List<Vraag> vragen, String land) {
        this.onderwerp = onderwerp;
        this.thema = thema;
        this.vragen = vragen;
        this.land = land;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public String getThema() {
        return thema;
    }

    public List<Vraag> getVragen() {
        return vragen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vragenlijst that = (Vragenlijst) o;
        return getOnderwerp().equals(that.getOnderwerp()) &&
                getThema().equals(that.getThema());
    }
}
