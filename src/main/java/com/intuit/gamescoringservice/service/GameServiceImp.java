package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImp implements GameService {
    public Optional<Game> getGame(String gameId) {
        return getAllGames()
                .stream()
                .filter(game -> gameId.equals(game.getId()))
                .findFirst();
    }

    // This can be replaced with a REST call to game service
    // TODO: Implement caching
    private List<Game> getAllGames() {
        return new ArrayList<>(
                Arrays.asList(
                        new Game("1", "Game 1"),
                        new Game("2", "Game 2"),
                        new Game("3", "Game 3"),
                        new Game("4", "Game 4"),
                        new Game("5", "Game 5"),
                        new Game("6", "Game 6"),
                        new Game("7", "Game 7")
                )
        );
    }
}
