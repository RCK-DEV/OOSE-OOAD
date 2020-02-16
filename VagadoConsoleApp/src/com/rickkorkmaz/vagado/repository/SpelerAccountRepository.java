package com.rickkorkmaz.vagado.repository;

import com.rickkorkmaz.vagado.domain.Aanschaffing;
import com.rickkorkmaz.vagado.domain.LifetimeBest;
import com.rickkorkmaz.vagado.domain.SpelerAccount;

import java.util.List;

public interface SpelerAccountRepository {
    public List<Aanschaffing> getAanschaffingen(SpelerAccount speler);
    public List<LifetimeBest> getLifetimeBest(SpelerAccount speler);
    public int getMuntenSaldo(SpelerAccount speler);
    public void updateSpeler(SpelerAccount speler);
}
