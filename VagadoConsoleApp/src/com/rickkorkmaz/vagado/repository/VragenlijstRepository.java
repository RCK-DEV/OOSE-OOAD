package com.rickkorkmaz.vagado.repository;

import com.rickkorkmaz.vagado.domain.Aanschaffing;
import com.rickkorkmaz.vagado.domain.LifetimeBest;
import com.rickkorkmaz.vagado.domain.Speler;

import java.util.List;

public interface VragenlijstRepository {
    public List<Aanschaffing> getAanschaffingen(Speler speler);
    public List<LifetimeBest> getLifetimeBest(Speler speler);
}
