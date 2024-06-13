package com.bookmaker.odds.service.dataaccess.adapter;

import com.bookmaker.odds.service.application.service.port.output.JuiceRepository;
import com.bookmaker.odds.service.application.service.port.output.ProbabilityOddsReferenceRepository;
import com.bookmaker.odds.service.domain.entity.Match;
import com.bookmaker.odds.service.domain.entity.ProbabilityOddsReference;
import com.bookmaker.odds.service.domain.valueobject.Juice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JuiceRepositoryImpl implements JuiceRepository {
    @Override
    public Juice findDesiredMatchJuiceByMatch(Match match) {
        return null;
    }

    @Override
    public Juice findDesiredTournamentJuiceByMatch(Match match) {
        return null;
    }
}
