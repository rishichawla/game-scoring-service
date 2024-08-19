package com.intuit.gamescoringservice.controller;

import com.intuit.gamescoringservice.dto.ScoreDto.ScoreDTO;
import com.intuit.gamescoringservice.models.Score;
import com.intuit.gamescoringservice.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/{gameId}/top-scores")
    public List<ScoreDTO> getTop5Scores(@PathVariable String gameId) {
        try {
            return scoreService.getTopScoresForGame(gameId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // TODO: Replace with global exception handlers
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
