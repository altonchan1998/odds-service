package com.bookmaker.odds.service.container.config;

import com.bookmaker.odds.service.domain.OddsDomainService;
import com.bookmaker.odds.service.domain.OddsDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OddsDomainService orderDomainService() {
        return new OddsDomainServiceImpl();
    }
}
