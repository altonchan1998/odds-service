package com.bookmaker.odds.service.domain.calculator.probability;

import lombok.Getter;
import com.bookmaker.odds.service.domain.valueobject.Odds;
import com.bookmaker.odds.service.domain.valueobject.Probability;

public class TwoWayMarketProbabilityCalculator implements ProbabilityCalculator {

    private TwoWayMarketProbabilityCalculator() {}

    @Getter
    private static final TwoWayMarketProbabilityCalculator instance = new TwoWayMarketProbabilityCalculator();

    @Override
    public Probability calculate(Odds odds) {
        return null;
    }
}
