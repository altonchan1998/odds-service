package com.bookmaker.odds.service.application.service.dto.query;

import com.bookmaker.odds.service.application.service.dto.Query;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MarketConfigQuery implements Query {
    private final Long sid;
    private final String vendorCode;
    private final String marketCode;
}
