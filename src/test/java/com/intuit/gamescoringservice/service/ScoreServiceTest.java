package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.models.Game;
import com.intuit.gamescoringservice.models.Player;
import com.intuit.gamescoringservice.models.Score;
import com.intuit.gamescoringservice.repository.ScoreRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class ScoreServiceTest {
    @Mock
    private GameService gameService;

    @Mock
    private PlayerService playerService;

    @Mock
    private ScoreRepository scoreRepository;

    @InjectMocks
    private ScoreService scoreService;

    @Test
    public void shouldAddScoreWhenValidScore() {
        Score score = Score.builder()
                .gameId("1")
                .playerId("1")
                .score(1)
                .build();

        when(gameService.getGame(score.getGameId())).thenReturn(Optional.of(new Game("1", "Game 1")));
        when(playerService.getPlayer(score.getPlayerId())).thenReturn(Optional.of(new Player("1", "Player 1")));

        scoreService.addScore(score);
        verify(gameService, times(1)).getGame(score.getGameId());
        verify(playerService, times(1)).getPlayer(score.getPlayerId());
        verify(scoreRepository, times(1)).save(any());
    }

    @Test
    public void shouldNotAddScoreWhenInvalidScore() {
        Score score = Score.builder()
                .gameId("1")
                .playerId("1")
                .score(-1)
                .build();

        when(gameService.getGame(score.getGameId())).thenReturn(Optional.of(new Game("1", "Game 1")));
        when(playerService.getPlayer(score.getPlayerId())).thenReturn(Optional.of(new Player("1", "Player 1")));

        scoreService.addScore(score);
        verify(gameService, never()).getGame(score.getGameId());
        verify(playerService, never()).getPlayer(score.getPlayerId());
        verify(scoreRepository, never()).save(any());
    }

    @Test
    public void shouldNotAddScoreWhenInvalidGame() {
        Score score = Score.builder()
                .gameId("1")
                .playerId("1")
                .score(1)
                .build();

        when(gameService.getGame(score.getGameId())).thenReturn(Optional.empty());
        when(playerService.getPlayer(score.getPlayerId())).thenReturn(Optional.of(new Player("1", "Player 1")));

        scoreService.addScore(score);
        verify(gameService, times(1)).getGame(score.getGameId());
        verify(playerService, never()).getPlayer(score.getPlayerId());
        verify(scoreRepository, never()).save(any());
    }

    @Test
    public void shouldNotAddScoreWhenInvalidPlayer() {
        Score score = Score.builder()
                .gameId("1")
                .playerId("1")
                .score(1)
                .build();

        when(gameService.getGame(score.getGameId())).thenReturn(Optional.of(new Game("1", "Game 1")));
        when(playerService.getPlayer(score.getPlayerId())).thenReturn(Optional.empty());

        scoreService.addScore(score);
        verify(gameService, times(1)).getGame(score.getGameId());
        verify(playerService, times(1)).getPlayer(score.getPlayerId());
        verify(scoreRepository, never()).save(any());
    }
}
