package com.bookmaker.odds.service.dataaccess.adapter;

import com.bookmaker.odds.service.application.service.port.output.JuiceRepository;
import com.bookmaker.odds.service.domain.entity.InnoMatch;
import com.bookmaker.odds.service.domain.valueobject.Juice;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JuiceRepositoryImpl implements JuiceRepository {
    @Override
    public Optional<Juice> findDesiredMatchJuiceByInnoMatch(InnoMatch innoMatch) {
        return null;
    }

    @Override
    public Optional<Juice> findDesiredTournamentJuiceByInnoMatch(InnoMatch innoMatch) {
        return null;
    }
}
