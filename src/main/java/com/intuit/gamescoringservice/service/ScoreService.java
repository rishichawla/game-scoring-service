package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Game;
import com.intuit.gamescoringservice.models.Player;
import com.intuit.gamescoringservice.models.Score;
import com.intuit.gamescoringservice.repository.ScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    Logger logger = LoggerFactory.getLogger(ScoreService.class);

    @Autowired
    private ScoreRepository scoreRepository;

    public void addScore(Score score) {
        if (score.getScore() < 0 || score.getScore() > 100) {
            logger.error("Invalid score: {} received, ignoring message", score.getScore());
            return;
        }

        try {
            scoreRepository.save(score);
        } catch (Exception e) {
            logger.error("Something went wrong! {}", e.getMessage()); // This can be handled more gracefully
        }
    }

    public List<Score> getTopScores() {
        return scoreRepository.findAllByOrderByScoreDesc(Limit.of(5));
    }

    public List<Score> getScoresForPlayer(String playerId) {
        return scoreRepository.findByPlayerOrderByScoreDesc(new Player(playerId), Limit.of(5));
    }

    public List<Score> getScoreForGame(String gameId) {
        return scoreRepository.findByGameOrderByScoreDesc(new Game(gameId), Limit.of(5));
    }
}
