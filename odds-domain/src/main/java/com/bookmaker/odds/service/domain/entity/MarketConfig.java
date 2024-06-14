package com.bookmaker.odds.service.domain.entity;


import com.bookmaker.odds.service.domain.enums.MarketType;
import com.bookmaker.odds.service.domain.valueobject.id.MarketConfigId;
import com.bookmaker.odds.service.domain.valueobject.id.SportId;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter
public class MarketConfig extends BaseEntity<MarketConfigId> {
    private final SportId sid;
    private final MarketType marketType;
    private final boolean isOutcomeInList;
    private final String marketCode;
    private final Set<String> bettingOptionCodes;


    public MarketConfig(MarketConfigId marketConfigId, SportId sid, MarketType marketType, boolean isOutcomeInList, String marketCode, Set<String> bettingOptionCodes) {
        super.setId(marketConfigId);
        this.sid = sid;
        this.marketType = marketType;
        this.isOutcomeInList = isOutcomeInList;
        this.marketCode = marketCode;
        this.bettingOptionCodes = bettingOptionCodes;
    }
}
