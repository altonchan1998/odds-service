package com.bookmaker.odds.service.domain.entity.interfaces;


import com.bookmaker.odds.service.domain.valueobject.Juice;

public interface OddsAdjustable {

    void adjustOdds(Juice desiredMatchJuice, Juice desiredTournamentJuice);
}
