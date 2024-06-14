package com.bookmaker.odds.service.application.service.handler;

import com.bookmaker.odds.service.application.service.dto.query.MarketConfigQuery;
import com.bookmaker.odds.service.application.service.dto.response.MarketConfigResponse;
import com.bookmaker.odds.service.application.service.mapper.OddsDataMapper;
import com.bookmaker.odds.service.application.service.port.output.MarketConfigRepository;
import com.bookmaker.odds.service.domain.enums.OddsVendor;
import com.bookmaker.odds.service.domain.exception.MarketConfigNotFoundException;
import com.bookmaker.odds.service.domain.valueobject.id.SportId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MarketConfigQueryHandler implements QueryHandler<MarketConfigQuery, MarketConfigResponse> {
    private final MarketConfigRepository marketConfigRepository;
    private final OddsDataMapper oddsDataMapper;

    @Override
    public MarketConfigResponse handle(MarketConfigQuery query) {
        SportId sid = new SportId(query.getSid());
        OddsVendor oddsVendor = OddsVendor.getByCode(query.getVendorCode());
        String marketCode = query.getMarketCode();

        return marketConfigRepository.findBySportIdAndOddsVendorAndMarketCode(sid, oddsVendor, marketCode)
                .map(oddsDataMapper::toMarketConfigResponse)
                .orElseThrow(() -> new MarketConfigNotFoundException("Market config not found for sid: " + query.getSid() + ", vendor: " + query.getVendorCode() + ", marketCode: " + query.getMarketCode()));
    }
}
