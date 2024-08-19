package com.intuit.gamescoringservice.service;

import com.intuit.gamescoringservice.dto.ScoreDto.ScoreDTO;
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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScoreService {
    Logger logger = LoggerFactory.getLogger(ScoreService.class);

    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ScoreRepository scoreRepository;

    public void addScore(Score score) {
        if (score.getScore() < 0 || score.getScore() > 100) { // TODO: Replace this with config
            logger.error("Invalid score: {} received, ignoring message", score.getScore());
            return;
        }

        Optional<Game> game = gameService.getGame(score.getGameId());
        if (game.isEmpty()) {
            logger.error("Invalid game: {} received, ignoring message", score.getGameId());
            return;
        }

        Optional<Player> player = playerService.getPlayer(score.getPlayerId());
        if (player.isEmpty()) {
            logger.error("Invalid player: {} received, ignoring message", score.getPlayerId());
            return;
        }

        try {
            scoreRepository.save(score);
        } catch (Exception e) {
            logger.error("Something went wrong! {}", e.getMessage()); // This can be handled more gracefully
        }
    }

    public List<ScoreDTO> getTopScoresForGame(String gameId) throws Exception {

        Optional<Game> game = gameService.getGame(gameId);
        if (game.isEmpty()) {
            logger.error("Invalid game: {} received, ignoring message", gameId);
            throw new NoSuchElementException("Game not found");
        }

        return convertScoreToScoreDTO(scoreRepository.findByGameId(gameId, Limit.of(5)), game.get());
    }

    private List<ScoreDTO> convertScoreToScoreDTO(List<Score> scores, Game game) {
        return scores.stream().map(score -> {
            Optional<Player> player = playerService.getPlayer(score.getPlayerId());
            return ScoreDTO.builder()
                    .game(game)
                    .score(score.getScore())
                    // A player won't be deleted, but just for completion sake.
                    .player(player.orElseGet(() -> new Player(score.getPlayerId(), "NA")))
                    .build();
        }).collect(Collectors.toList());
    }
}
