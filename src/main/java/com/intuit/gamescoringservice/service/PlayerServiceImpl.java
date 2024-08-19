package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    public Optional<Player> getPlayer(String playerId) {
        return getAllPlayers()
                .stream()
                .filter(player -> playerId.equals(player.getId()))
                .findFirst();
    }

    // This can be replaced with a REST call to game service
    // TODO: Implement caching
    private List<Player> getAllPlayers() {
        return new ArrayList<>(
                Arrays.asList(
                        new Player("1", "Game 1"),
                        new Player("2", "Game 2"),
                        new Player("3", "Game 3"),
                        new Player("4", "Game 4"),
                        new Player("5", "Game 5"),
                        new Player("6", "Game 6"),
                        new Player("7", "Game 7")
                )
        );
    }
}
