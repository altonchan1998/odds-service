package com.bookmaker.odds.service.application.service.port.output;


import com.bookmaker.odds.service.domain.entity.MarketConfig;
import com.bookmaker.odds.service.domain.enums.OddsVendor;
import com.bookmaker.odds.service.domain.valueobject.id.SportId;

import java.util.Optional;

public interface MarketConfigRepository {
    Optional<MarketConfig> findBySportIdAndOddsVendorAndMarketCode(SportId sid, OddsVendor oddsVendor, String marketCode);
}
