package com.intuit.gamescoringservice.repository;

import com.intuit.gamescoringservice.models.Score;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.domain.Limit;

import java.util.List;

@EnableCassandraRepositories
public interface ScoreRepository extends CassandraRepository<Score, String> {
    public List<Score> findByGameId(String gameId);
}
