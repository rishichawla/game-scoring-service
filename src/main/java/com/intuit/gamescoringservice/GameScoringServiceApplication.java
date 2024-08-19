package com.intuit.gamescoringservice;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class GameScoringServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameScoringServiceApplication.class, args);
    }

    @Bean
    public CqlSession session() { // TODO: Move this to config file
        return CqlSession.builder()
                .withKeyspace("gameservice")
                .build();
    }

}
