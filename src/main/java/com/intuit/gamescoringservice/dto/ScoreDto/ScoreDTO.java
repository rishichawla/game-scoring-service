package com.intuit.gamescoringservice.dto.ScoreDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intuit.gamescoringservice.models.Game;
import com.intuit.gamescoringservice.models.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public class ScoreDTO {
    @JsonProperty(value = "game")
    private Game game;

    @JsonProperty(value = "player")
    private Player player;

    @JsonProperty(value = "score")
    private Integer score;
}
