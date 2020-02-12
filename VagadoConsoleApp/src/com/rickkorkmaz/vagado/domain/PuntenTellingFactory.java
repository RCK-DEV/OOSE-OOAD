package com.rickkorkmaz.vagado.domain;

public class PuntenTellingFactory {
    public PuntenTelling getPuntenTelling(String puntenTellingKeuze) {
        String upperCased = puntenTellingKeuze.toUpperCase();
        switch (upperCased) {
            case "S": return new StandaardPuntenTelling();
            case "M": return new MoeilijkPuntenTelling();
            default: return new StandaardPuntenTelling();
        }
    }
}
