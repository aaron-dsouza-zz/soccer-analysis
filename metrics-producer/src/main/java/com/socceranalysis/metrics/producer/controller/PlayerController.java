package com.socceranalysis.metrics.producer.controller;

import com.socceranalysis.metrics.producer.model.player.Player;
import com.socceranalysis.metrics.producer.service.player.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public void reloadPlayers() throws IOException, URISyntaxException, InterruptedException {
        playerService.updatePlayerList();
    }

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers() {
        return ResponseEntity.ok(playerService.getPlayers());
    }
}
