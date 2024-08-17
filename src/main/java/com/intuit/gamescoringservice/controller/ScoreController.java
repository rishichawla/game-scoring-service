package com.intuit.gamescoringservice.controller;

import com.intuit.gamescoringservice.models.Score;
import com.intuit.gamescoringservice.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getTop5Scores() {
        return scoreService.getTopScores();
    }
}
