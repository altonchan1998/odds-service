package com.bookmaker.odds.service.domain.entity;

import com.bookmaker.odds.service.domain.valueobject.Juice;
import com.bookmaker.odds.service.domain.valueobject.Odds;
import com.bookmaker.odds.service.domain.valueobject.Probability;
import com.bookmaker.odds.service.domain.valueobject.id.ProbabilityOddsReferenceId;
import lombok.Getter;


@Getter
public class ProbabilityOddsReference extends BaseEntity<ProbabilityOddsReferenceId> {
    private final Juice juice;
    private final Odds upperOdds;
    private final Odds lowerOdds;
    private final Probability upperProbability;
    private final Probability lowerProbability;

    public ProbabilityOddsReference(Juice juice, Odds upperOdds, Odds lowerOdds, Probability upperProbability, Probability lowerProbability) {
        this.juice = juice;
        this.upperOdds = upperOdds;
        this.lowerOdds = lowerOdds;
        this.upperProbability = upperProbability;
        this.lowerProbability = lowerProbability;
    }
}
