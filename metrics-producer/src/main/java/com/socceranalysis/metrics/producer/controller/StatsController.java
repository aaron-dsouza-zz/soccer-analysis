package com.socceranalysis.metrics.producer.controller;

import com.socceranalysis.metrics.producer.exception.InvalidPlayerException;
import com.socceranalysis.metrics.producer.model.player.Stat;
import com.socceranalysis.metrics.producer.service.player.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/stats")
public class StatsController {
    private StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @PostMapping
    public void reloadStats() throws IOException, URISyntaxException, InterruptedException {
        statsService.updateStats();
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Stat> getStatsForPlayer(@PathVariable int playerId) throws InvalidPlayerException {
        return ResponseEntity.ok(statsService.getStatsFor(playerId));
    }
}
