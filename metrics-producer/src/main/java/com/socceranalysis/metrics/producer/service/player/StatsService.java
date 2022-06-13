package com.socceranalysis.metrics.producer.service.player;

import com.socceranalysis.metrics.producer.exception.InvalidPlayerException;
import com.socceranalysis.metrics.producer.gateway.FPLService;
import com.socceranalysis.metrics.producer.model.player.Player;
import com.socceranalysis.metrics.producer.model.player.PlayerRepository;
import com.socceranalysis.metrics.producer.model.player.Stat;
import com.socceranalysis.metrics.producer.model.player.StatRepository;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StatsService {
    private StatRepository statRepository;
    private PlayerRepository playerRepository;
    private FPLService fplService;

    public StatsService(StatRepository statRepository, PlayerRepository playerRepository, FPLService fplService) {
        this.statRepository = statRepository;
        this.playerRepository = playerRepository;
        this.fplService = fplService;
    }

    public void updateStats() throws URISyntaxException {
        List<Stat> stats = fplService.fetchStats(playerRepository.findAll());
        stats.forEach(statRepository::save);
    }

    public Stat getStatsFor(int playerId) throws InvalidPlayerException {
        Optional<Stat> stat = statRepository.findById(playerId);
        if(stat.isPresent())
            return stat.get();

        throw new InvalidPlayerException();
    }
}
