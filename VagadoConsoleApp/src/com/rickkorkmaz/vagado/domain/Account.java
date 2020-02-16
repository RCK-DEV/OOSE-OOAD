package com.rickkorkmaz.vagado.domain;

/**
 * Not all methods in Design Class Diagram are implemented
 * since it isn't required to play a demo game.
 */
public class Account {
    private String gebruikersnaam;
    private String wachtwoord;
    private boolean ingelogd;

    public Account(String gebruikersnaam, String wachtwoord, boolean ingelogd) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.ingelogd = ingelogd;
    }
}
