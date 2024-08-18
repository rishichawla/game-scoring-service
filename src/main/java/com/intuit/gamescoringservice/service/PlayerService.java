package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Player;

import java.util.Optional;

public interface PlayerService {
    public Optional<Player> getPlayer(String playerId);
}
