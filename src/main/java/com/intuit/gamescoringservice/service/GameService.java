package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Game;

import java.util.Optional;

public interface GameService {
    public Optional<Game> getGame(String gameId);
}
