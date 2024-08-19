package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PlayerServiceImplTest {
    @Autowired
    private PlayerService playerService;

    @Test
    public void shouldReturnPlayerWhenGameExists() {
        Optional<Player> player = playerService.getPlayer("1");
        assertTrue(player.isPresent());
        assertEquals("1", player.get().getId());
    }

    @Test
    public void shouldNotReturnPlayerWhenGameDoesNotExists() {
        Optional<Player> player = playerService.getPlayer("wrong-player-id");
        assertFalse(player.isPresent());
    }
}
