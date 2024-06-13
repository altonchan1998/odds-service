package com.bookmaker.odds.service.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bookmaker.odds.service")
public class OddsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OddsServiceApplication.class, args);
    }
}
