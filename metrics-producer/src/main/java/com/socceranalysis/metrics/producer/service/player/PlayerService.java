package com.socceranalysis.metrics.producer.service.player;

import com.socceranalysis.metrics.producer.gateway.FPLService;
import com.socceranalysis.metrics.producer.model.player.Player;
import com.socceranalysis.metrics.producer.model.player.PlayerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private FPLService fplService;

    public PlayerService(PlayerRepository playerRepository, FPLService fplService) {
        this.playerRepository = playerRepository;
        this.fplService = fplService;
    }

    public void updatePlayerList() throws IOException, URISyntaxException, InterruptedException {
        playerRepository.deleteAll();
        List<Player> players = fplService.getPlayers();
        playerRepository.saveAll(players);
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }
}
