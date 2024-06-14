package com.bookmaker.odds.service.domain;

import com.bookmaker.odds.service.domain.valueobject.Market;
import com.bookmaker.odds.service.domain.entity.ProbabilityOddsReference;
import com.bookmaker.odds.service.domain.valueobject.Juice;

import java.util.List;

public interface OddsDomainService {

    void initializeTwoWayMarketOddsCalculator(List<ProbabilityOddsReference> references);

    void adjustOdds(Market market, Juice desiredMatchJuice, Juice desiredTournamentJuice);
}
