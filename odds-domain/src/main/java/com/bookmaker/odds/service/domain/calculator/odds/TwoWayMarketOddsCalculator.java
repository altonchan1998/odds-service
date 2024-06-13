package com.bookmaker.odds.service.domain.calculator.odds;

import com.bookmaker.odds.service.domain.entity.ProbabilityOddsReference;
import lombok.Getter;
import com.bookmaker.odds.service.domain.valueobject.Juice;
import com.bookmaker.odds.service.domain.valueobject.Odds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoWayMarketOddsCalculator implements OddsCalculator {
    private static final Map<Juice, List<ProbabilityOddsReference>> referenceMap = new HashMap<>();

    private TwoWayMarketOddsCalculator() {}

    @Getter
    private static final TwoWayMarketOddsCalculator instance = new TwoWayMarketOddsCalculator();

    @Override
    public List<Odds> calculate(List<Odds> oddsList, Juice desiredJuice) {
        return null;
    }

    public static void initializeReferenceMap(List<ProbabilityOddsReference> referenceList) {
        // TODO
    }
}
