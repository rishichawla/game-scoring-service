package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Score;
import com.intuit.gamescoringservice.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public void addScore(Score score) {
        scoreRepository.save(score);
    }

    public List<Score> getTopScores() {
        return scoreRepository.findAllByOrderByScoreDesc(Limit.of(5));
    }
}
