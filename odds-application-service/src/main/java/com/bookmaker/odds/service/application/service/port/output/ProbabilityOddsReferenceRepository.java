package com.bookmaker.odds.service.application.service.port.output;

import com.bookmaker.odds.service.domain.entity.ProbabilityOddsReference;

import java.util.List;

public interface ProbabilityOddsReferenceRepository {
    List<ProbabilityOddsReference> findAllOrderByJuiceAndUpperProbability();
}
