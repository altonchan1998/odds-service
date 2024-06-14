package com.bookmaker.odds.service.application.service.mapper;


import com.bookmaker.odds.service.application.service.dto.command.AdjustMarketOddsCommand;
import com.bookmaker.odds.service.application.service.dto.response.AdjustMarketOddsResponse;
import com.bookmaker.odds.service.application.service.dto.response.MarketConfigResponse;
import com.bookmaker.odds.service.domain.entity.MarketConfig;
import com.bookmaker.odds.service.domain.valueobject.BettingOption;
import com.bookmaker.odds.service.domain.valueobject.Market;
import com.bookmaker.odds.service.domain.enums.MarketType;
import com.bookmaker.odds.service.domain.valueobject.id.InnoMatchId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OddsDataMapper {
    public Market toMarket(AdjustMarketOddsCommand command) {
        String marketCode = command.getMarketCode();
        InnoMatchId innoMatchId = new InnoMatchId(command.getIid());
        MarketType marketType = MarketType.getByMarketCode(marketCode);
        List<BettingOption> bettingOptions = command.getBettingOptions();

        return new Market(marketCode, innoMatchId, marketType, bettingOptions);
    }

    public AdjustMarketOddsResponse toAdjustMarketOddsResponse(Market market) {
        return new AdjustMarketOddsResponse(market.getBettingOptions());
    }

    public MarketConfigResponse toMarketConfigResponse(MarketConfig marketConfig) {
        return new MarketConfigResponse(
                marketConfig.getBettingOptionCodes(),
                marketConfig.isOutcomeInList(),
                marketConfig.getMarketType()
        );
    }
}
