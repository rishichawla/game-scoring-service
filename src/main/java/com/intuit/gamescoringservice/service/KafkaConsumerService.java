package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    @Autowired
    private ScoreService scoreService;

    @KafkaListener(topics = "${spring.kafka.topic}")
    public void listenGroupFoo(Score score) {
        logger.info("Received message for score: {}", score);
        scoreService.addScore(score);
    }
}
