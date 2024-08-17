package com.intuit.gamescoringservice.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Player {
    @Id
    @Column(name = "id")
    private String id;

    @Nonnull
    private String name;

    public Player(String id) {
        this.id = id;
    }
}
