package com.bookmaker.odds.service.domain.calculator.probability;

import lombok.Getter;
import com.bookmaker.odds.service.domain.valueobject.Odds;
import com.bookmaker.odds.service.domain.valueobject.Probability;

public class ThreeWayMarketProbabilityCalculator implements ProbabilityCalculator {

    private ThreeWayMarketProbabilityCalculator() {}

    @Getter
    private static final ThreeWayMarketProbabilityCalculator instance = new ThreeWayMarketProbabilityCalculator();

    @Override
    public Probability calculate(Odds odds) {
        return null;
    }
}
