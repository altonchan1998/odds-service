package com.bookmaker.odds.service.domain.entity;

import com.bookmaker.odds.service.domain.calculator.odds.OddsCalculator;
import com.bookmaker.odds.service.domain.calculator.probability.ProbabilityCalculator;
import com.bookmaker.odds.service.domain.entity.interfaces.OddsAdjustable;
import com.bookmaker.odds.service.domain.enums.MarketType;
import com.bookmaker.odds.service.domain.enums.OddsStatus;
import com.bookmaker.odds.service.domain.enums.OddsVendor;
import com.bookmaker.odds.service.domain.factory.OddsCalculatorFactory;
import com.bookmaker.odds.service.domain.factory.ProbabilityCalculatorFactory;
import com.bookmaker.odds.service.domain.valueobject.Juice;
import com.bookmaker.odds.service.domain.valueobject.Odds;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class OddsAdjustableMarket extends Market implements OddsAdjustable {
    private final OddsVendor oddsVendor;
    private final Juice desiredMatchJuice;
    private final Juice desiredTournamentJuice;
    private OddsStatus oddsStatus;

    public OddsAdjustableMarket(Market market, OddsVendor oddsVendor, Juice desiredMatchJuice, Juice desiredTournamentJuice) {
        this(market.getCode(), market.getMatch(),  market.getMarketType(), market.getBettingOptions(), oddsVendor, desiredMatchJuice, desiredTournamentJuice);
    }

    public OddsAdjustableMarket(String code, Match match, MarketType marketType, List<BettingOption> bettingOptions, OddsVendor oddsVendor, Juice desiredMatchJuice, Juice desiredTournamentJuice) {
        super(code, match, marketType, bettingOptions);
        this.oddsVendor = oddsVendor;
        this.desiredMatchJuice = desiredMatchJuice;
        this.desiredTournamentJuice = desiredTournamentJuice;
        this.oddsStatus = OddsStatus.RAW;
    }

    @Override
    public void adjustOdds() {
        if (getOddsStatus() == OddsStatus.ADJUSTED) return;

        OddsCalculator calculator = OddsCalculatorFactory.getCalculator(getMarketType());

        Juice desiredJuice = getDesiredJuice();

        // Sort betting options by odds in ascending order
        getBettingOptions().sort(Comparator.comparing(o -> o.getOdds().getValue()));

        List<Odds> originalOdds = getBettingOptions()
                .stream()
                .map(BettingOption::getOdds)
                .toList();

        List<Odds> adjustedOdds = calculator
                .calculate(originalOdds, desiredJuice);

        applyOdds(adjustedOdds);

        setOddsStatus(OddsStatus.ADJUSTED);
    }

    private Juice getDesiredJuice() {
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
