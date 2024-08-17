package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private ScoreService scoreService;

    @KafkaListener(topics = "${spring.kafka.topic}")
    public void listenGroupFoo(Score score) {
        System.out.println("Received Message in group foo: " + score);
        scoreService.addScore(score);
    }
}
