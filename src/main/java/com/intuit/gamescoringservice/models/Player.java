package com.intuit.gamescoringservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @JsonProperty(value = "player_id")
    private String id;

    @JsonProperty(value = "name")
    private String name;
}
