package com.bookmaker.odds.service.application.service;

import com.bookmaker.odds.service.application.service.port.input.OddsApplicationService;
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

    @Override
    public void initializeTwoWayMarketOddsCalculator() {
        List<ProbabilityOddsReference> references = probabilityOddsReferenceRepository.findAllOrderByJuiceAndUpperProbability();
        oddsDomainService.initializeTwoWayMarketOddsCalculator(references);
    }
}
