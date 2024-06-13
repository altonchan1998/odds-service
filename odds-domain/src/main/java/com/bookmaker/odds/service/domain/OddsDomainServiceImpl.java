package com.bookmaker.odds.service.domain;

import com.bookmaker.odds.service.domain.calculator.odds.TwoWayMarketOddsCalculator;
import com.bookmaker.odds.service.domain.entity.ProbabilityOddsReference;

import java.util.List;

public class OddsDomainServiceImpl implements OddsDomainService {
    @Override
    public void initializeTwoWayMarketOddsCalculator(List<ProbabilityOddsReference> references) {
        TwoWayMarketOddsCalculator.initializeReferenceMap(references);
    }
}
