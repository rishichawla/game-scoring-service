package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Game;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GameServiceImplTest {
    @Autowired
    private GameService gameService;

    @Test
    public void shouldReturnGameWhenGameExists() {
        Optional<Game> game = gameService.getGame("1");
        assertTrue(game.isPresent());
        assertEquals("1", game.get().getId());
    }

    @Test
    public void shouldNotReturnGameWhenGameDoesNotExists() {
        Optional<Game> game = gameService.getGame("wrong-game-id");
        assertFalse(game.isPresent());
    }
}
