package com.bookmaker.odds.service.domain.calculator.odds;

import lombok.Getter;
import com.bookmaker.odds.service.domain.valueobject.Juice;
import com.bookmaker.odds.service.domain.valueobject.Odds;

import java.util.List;

public class ThreeWayMarketOddsCalculator implements OddsCalculator {

    private ThreeWayMarketOddsCalculator() {}

    @Getter
    private static final ThreeWayMarketOddsCalculator instance = new ThreeWayMarketOddsCalculator();

    @Override
    public List<Odds> calculate(List<Odds> oddsList, Juice desiredJuice) {
        return null;
    }
}
