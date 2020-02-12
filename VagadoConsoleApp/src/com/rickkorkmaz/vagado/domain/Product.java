package com.rickkorkmaz.vagado.domain;

public class Product {
    private int aankoopbedrag;
    private Vragenlijst vragenlijst;

    public Product(int aankoopbedrag, Vragenlijst vragenlijst) {
        this.aankoopbedrag = aankoopbedrag;
        this.vragenlijst = vragenlijst;
    }

    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }
}
