package com.intuit.gamescoringservice.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nonnull
    private Integer score;

    @ManyToOne(targetEntity = Player.class)
    @JoinColumn(name = "player_id", referencedColumnName = "id", nullable = false)
    private Player player_id;

    @Column(updatable = false, insertable = false)
    @CreationTimestamp(source = SourceType.DB)
    private Instant created_on;
}
