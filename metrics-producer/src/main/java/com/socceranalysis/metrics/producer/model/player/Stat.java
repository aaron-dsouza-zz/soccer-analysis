package com.socceranalysis.metrics.producer.model.player;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "fpl_player_stats_current")
public class Stat {
    @Id
    @Column(name = "player_id")
    @SerializedName(value = "element")
    private int playerId;

    @Column(name="average_minutes")
    @SerializedName(value = "minutes")
    private int averageMinutes;

    @Column(name = "goals_scored")
    @SerializedName(value = "goals_scored")
    private int goalsScored;

    @Column(name = "assists")
    private int assists;

    @Column(name = "clean_sheets")
    @SerializedName(value = "clean_sheets")
    private int cleanSheets;

    @Column(name = "goals_conceded")
    @SerializedName(value = "goals_conceded")
    private int goalsConceded;

    @Column(name = "own_goals")
    @SerializedName(value = "own_goals")
    private int ownGoals;

    @Column(name = "penalties_saved")
    @SerializedName(value = "penalties_saved")
    private int penaltiesSaved;

    @Column(name = "penalties_missed")
    @SerializedName(value = "penalties_missed")
    private int penaltiesMissed;

    @Column(name="yellow_cards")
    @SerializedName(value = "yellow_cards")
    private int yellowCards;

    @Column(name = "red_cards")
    @SerializedName(value = "red_cards")
    private int redCards;

    @Column(name = "saves")
    private int saves;

    @Column(name = "bonus")
    private int bonus;

    @Column(name = "bps")
    private int bps;

    @Column(name = "influence")
    private double influence;

    @Column(name = "creativity")
    private double creativity;

    @Column(name = "threat")
    private double threat;

    @Column(name="ict_index")
    private double ictIndex;

    @Column(name = "value")
    private int value;

//    @Column(name = "transfers_balance")
//    @SerializedName(value = "transfers_balance")
//    private int transfersBalance;
//
//    @Column(name = "selected")
//    private int selected;
//
//    @Column(name = "transfers_in")
//    @SerializedName(value = "transfers_in")
//    private int transfersIn;
//
//    @Column(name = "transfers_out")
//    @SerializedName(value = "transfers_out")
//    private int transfersOut;

    public void add(Stat stat) {

        averageMinutes+=stat.averageMinutes;
        goalsScored+=stat.goalsScored;
        assists+=stat.assists;
        cleanSheets+=stat.cleanSheets;
        goalsConceded+=stat.goalsConceded;
        ownGoals+=stat.ownGoals;
        penaltiesSaved+=stat.penaltiesSaved;
        penaltiesMissed+=stat.penaltiesMissed;
        yellowCards+=stat.yellowCards;
        redCards+=stat.redCards;
        saves+=stat.saves;
        bonus+=stat.bonus;
        bps+=stat.bps;
        influence+=stat.influence;
        creativity+=stat.creativity;
        threat+=stat.threat;
    }
}
