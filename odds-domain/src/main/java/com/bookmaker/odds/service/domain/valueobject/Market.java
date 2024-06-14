package com.bookmaker.odds.service.domain.valueobject;

import com.bookmaker.odds.service.domain.calculator.odds.OddsCalculator;
import com.bookmaker.odds.service.domain.calculator.probability.ProbabilityCalculator;
import com.bookmaker.odds.service.domain.entity.interfaces.OddsAdjustable;
import com.bookmaker.odds.service.domain.factory.OddsCalculatorFactory;
import com.bookmaker.odds.service.domain.factory.ProbabilityCalculatorFactory;
import com.bookmaker.odds.service.domain.valueobject.id.InnoMatchId;
import lombok.Getter;
import com.bookmaker.odds.service.domain.enums.MarketType;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Getter
public class Market implements OddsAdjustable {
    private final String code;
    private final InnoMatchId innoMatchId;
    private final MarketType marketType;
    private final List<BettingOption> bettingOptions;

    public Market(String code, InnoMatchId innoMatchId, MarketType marketType, List<BettingOption> bettingOptions) {
        this.code = code;
        this.innoMatchId = innoMatchId;
        this.marketType = marketType;
        this.bettingOptions = bettingOptions;
    }

    public boolean isMarketLocked() {
        for (BettingOption option : getBettingOptions()) {
            if (!option.getOdds().isLocked()) return false;
        }

        return true;
    }

    @Override
    public void adjustOdds(Juice desiredMatchJuice, Juice desiredTournamentJuice) {
        if (isMarketLocked()) {
            return;
        }

        OddsCalculator calculator = OddsCalculatorFactory.getCalculator(getMarketType());

        Juice desiredJuice = getDesiredJuice(desiredMatchJuice, desiredTournamentJuice);

        // Sort betting options by odds in ascending order
        getBettingOptions().sort(Comparator.comparing(o -> o.getOdds().getValue()));

        List<Odds> originalOdds = getBettingOptions()
                .stream()
                .map(BettingOption::getOdds)
                .toList();

        List<Odds> adjustedOdds = calculator
                .calculate(originalOdds, desiredJuice);

        applyOdds(adjustedOdds);
    }


    private Juice getDesiredJuice(Juice desiredMatchJuice, Juice desiredTournamentJuice) {
        return Objects.nonNull(desiredMatchJuice)
                ? desiredMatchJuice
                : desiredTournamentJuice;
    }

    private void applyOdds(List<Odds> odds) {
        for (int i = 0; i < getBettingOptions().size(); i++) {
            getBettingOptions().get(i).setOdds(odds.get(i));
        }

        updateProbability();
    }

    private void updateProbability() {
        ProbabilityCalculator calculator = ProbabilityCalculatorFactory.getBettingOddsModifier(getMarketType());
        getBettingOptions().forEach(bettingOption -> bettingOption.setProbability(calculator.calculate(bettingOption.getOdds())));
    }
}
