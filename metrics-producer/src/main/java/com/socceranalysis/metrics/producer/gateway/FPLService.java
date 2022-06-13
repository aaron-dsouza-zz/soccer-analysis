package com.socceranalysis.metrics.producer.gateway;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.socceranalysis.metrics.producer.config.FPLConfig;
import com.socceranalysis.metrics.producer.model.player.Player;
import com.socceranalysis.metrics.producer.model.player.Stat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FPLService {
    @Autowired
    private FPLConfig fplConfig;

    public List<Player> fetchPlayers() throws IOException, URISyntaxException, InterruptedException {
        log.debug("Fetching players");
        List<Player> players = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fplConfig.getUrl()+"/bootstrap-static/"))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();

        HttpClient fplClient = HttpClient.newHttpClient();
        HttpResponse<String> response = fplClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        log.debug("response body: "+responseBody);
        JsonObject jsonObject = new JsonParser().parse(responseBody).getAsJsonObject();
        JsonArray elements = jsonObject.get("elements").getAsJsonArray();
        elements.forEach(jsonElement -> {
            if(!jsonElement.isJsonNull()) {
                String elementString = jsonElement.getAsJsonObject().toString();
                Player player = new Gson().fromJson(elementString, Player.class);
                players.add(player);
            }
        });
        log.debug(players.size()+" players found");
        return players;
    }

    public List<Stat> fetchStats(List<Player> players) throws URISyntaxException {
        log.debug("Fetching stats");
        List<Stat> stats = players.stream().parallel().map(player -> {
            Stat stat = new Stat();
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(fplConfig.getUrl()+"/element-summary/"+player.getId()+"/"))
                        .version(HttpClient.Version.HTTP_2)
                        .GET()
                        .build();
                HttpClient fplClient = HttpClient.newHttpClient();
                HttpResponse<String> response = fplClient.send(request, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
//                log.debug("response body: "+responseBody);
                JsonObject jsonObject = new JsonParser().parse(responseBody).getAsJsonObject();
                JsonArray history = jsonObject.getAsJsonArray("history");
                history.forEach(jsonElement->{
                    if(!jsonElement.isJsonNull()) {
                        String elementString = jsonElement.getAsJsonObject().toString();
//                        System.out.println("elementString: "+elementString);
                        Stat statToAdd = new Gson().fromJson(elementString, Stat.class);
//                        System.out.println("statToAdd:"+statToAdd);
                        stat.setPlayerId(statToAdd.getPlayerId());
                        stat.add(statToAdd);
//                        System.out.println("stat: "+stat);
                    }
                });
            } catch (URISyntaxException | IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return stat;
        }).collect(Collectors.toList());

        return stats;
    }
}
