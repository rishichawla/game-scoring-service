package com.intuit.gamescoringservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table(value = "scores")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    @PrimaryKeyColumn(name = "game_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @JsonProperty(value = "game_id")
    private String gameId;

    @PrimaryKeyColumn(name = "player_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    @JsonProperty(value = "player_id")
    @Column(value = "player_id")
    private String playerId;

    @PrimaryKeyColumn(name = "score", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    @JsonProperty(value = "score")
    private Integer score;

    @Column(value = "created_on")
    private LocalDateTime created_on = LocalDateTime.now();
}
