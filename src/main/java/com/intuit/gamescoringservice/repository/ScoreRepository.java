package com.intuit.gamescoringservice.repository;

import com.intuit.gamescoringservice.models.Score;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, String> {

    public List<Score> findAllByOrderByScoreDesc(Limit limit);
}
