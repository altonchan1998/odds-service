package com.bookmaker.odds.service.container.initializer;

import com.bookmaker.odds.service.application.service.port.input.service.OddsApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class TwoWayMarketOddsCalculatorInitializer implements CommandLineRunner {

    private final OddsApplicationService oddsApplicationService;

    @Override
    public void run(String... args) throws Exception {
        log.debug("Initializing TwoWayMarketOddsCalculator");
        oddsApplicationService.initializeTwoWayMarketOddsCalculator();
        log.debug("TwoWayMarketOddsCalculator initialized");
    }
}
