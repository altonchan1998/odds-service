package com.bookmaker.odds.service.dataaccess.adapter;

import com.bookmaker.odds.service.application.service.port.output.ProbabilityOddsReferenceRepository;
import com.bookmaker.odds.service.domain.entity.ProbabilityOddsReference;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProbabilityOddsReferenceRepositoryImpl implements ProbabilityOddsReferenceRepository {
    @Override
    public List<ProbabilityOddsReference> findAllOrderByJuiceAndUpperProbability() {
        return null;
    }
}
