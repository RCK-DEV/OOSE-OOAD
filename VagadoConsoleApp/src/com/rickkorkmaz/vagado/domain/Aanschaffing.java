package com.rickkorkmaz.vagado.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aanschaffing {
    private String vervaldatum;
    private Product product;

    public Aanschaffing(String vervaldatum, Product product) {
        this.vervaldatum = vervaldatum;
        this.product = product;
    }

    public boolean isActief() {
        boolean result = false;
        try {
            result = new SimpleDateFormat("dd/MM/yyy").parse(vervaldatum).after(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Vragenlijst getVragenlijst() {
        return product.getVragenlijst();
    }
}
