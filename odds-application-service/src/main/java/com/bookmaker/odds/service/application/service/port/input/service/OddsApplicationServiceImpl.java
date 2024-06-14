package com.bookmaker.odds.service.application.service.port.input.service;

import com.bookmaker.odds.service.application.service.dto.command.AdjustMarketOddsCommand;
import com.bookmaker.odds.service.application.service.dto.query.MarketConfigQuery;
import com.bookmaker.odds.service.application.service.dto.response.AdjustMarketOddsResponse;
import com.bookmaker.odds.service.application.service.dto.response.MarketConfigResponse;
import com.bookmaker.odds.service.application.service.handler.AdjustMarketOddsCommandHandler;
import com.bookmaker.odds.service.application.service.handler.MarketConfigQueryHandler;
import com.bookmaker.odds.service.domain.OddsDomainService;
import com.bookmaker.odds.service.domain.entity.ProbabilityOddsReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.bookmaker.odds.service.application.service.port.output.ProbabilityOddsReferenceRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OddsApplicationServiceImpl implements OddsApplicationService {

    private final ProbabilityOddsReferenceRepository probabilityOddsReferenceRepository;
    private final OddsDomainService oddsDomainService;
    private final AdjustMarketOddsCommandHandler adjustMarketOddsCommandHandler;
    private final MarketConfigQueryHandler marketConfigQueryHandler;

    @Override
    public void initializeTwoWayMarketOddsCalculator() {
        List<ProbabilityOddsReference> references = probabilityOddsReferenceRepository.findAllOrderByJuiceAndUpperProbability();
        oddsDomainService.initializeTwoWayMarketOddsCalculator(references);
    }

    @Override
    public AdjustMarketOddsResponse adjustOdds(AdjustMarketOddsCommand command) {
        return adjustMarketOddsCommandHandler.handle(command);
    }

    public MarketConfigResponse getMarketConfig(MarketConfigQuery query) {
        return marketConfigQueryHandler.handle(query);
    }
}
