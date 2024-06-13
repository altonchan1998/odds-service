package com.bookmaker.odds.service.application.service.mapper;


import com.bookmaker.odds.service.application.service.dto.AdjustMarketOddsCommand;
import com.bookmaker.odds.service.application.service.dto.AdjustMarketOddsResponse;
import com.bookmaker.odds.service.domain.entity.BettingOption;
import com.bookmaker.odds.service.domain.entity.Market;
import com.bookmaker.odds.service.domain.entity.Match;
import com.bookmaker.odds.service.domain.entity.OddsAdjustableMarket;
import com.bookmaker.odds.service.domain.enums.MarketType;
import com.bookmaker.odds.service.domain.enums.MatchStatus;
import com.bookmaker.odds.service.domain.enums.OddsStatus;
import com.bookmaker.odds.service.domain.enums.OddsVendor;
import com.bookmaker.odds.service.domain.exception.OddsDomainException;
import com.bookmaker.odds.service.domain.valueobject.Juice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OddsDataMapper {
    public Market toMarket(AdjustMarketOddsCommand command) {
        String marketCode = command.getMarketCode();
        Match match = new Match(MatchStatus.fromValue(command.isInPlay()));
        MarketType marketType = MarketType.getByMarketCode(marketCode);
        List<BettingOption> bettingOptions = command.getBettingOptions();

        return new Market(marketCode, match, marketType, bettingOptions);
    }

    public OddsAdjustableMarket toOddsAdjustableMarket(
            Market market,
            String vendorCode,
            Juice desiredMatchJuice,
            Juice desiredTournamentJuice
    ) {
        OddsVendor oddsVendor = OddsVendor.getByCode(vendorCode);
        return new OddsAdjustableMarket(market, oddsVendor, desiredMatchJuice, desiredTournamentJuice);
    }

    public AdjustMarketOddsResponse toAdjustMarketOddsResponse(OddsAdjustableMarket oddsAdjustableMarket) {
        if (oddsAdjustableMarket.getOddsStatus() != OddsStatus.ADJUSTED) {
            throw new OddsDomainException("Market is not adjusted");
        }
        return new AdjustMarketOddsResponse(oddsAdjustableMarket.getBettingOptions());
    }
}
