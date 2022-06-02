package com.socceranalysis.metrics.producer.model.player;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name = "fpl_player_stats_current")
public class FPLCurrentStat {
    @Id
    @Column(name = "player_id")
    private int playerId;

    @Column(name="average_minutes")
    private int averageMinutes;

    @Column(name = "goals_scored")
    private int goalsScored;

    @Column(name = "assists")
    private int assists;

    @Column(name = "clean_sheets")
    private int cleanSheets;

    @Column(name = "goals_conceded")
    private int goalsConceded;

    @Column(name = "own_goals")
    private int ownGoals;

    @Column(name = "penalties_saved")
    private int penaltiesSaved;

    @Column(name = "penalties_missed")
    private int penaltiesMissed;

    @Column(name="yellow_cards")
    private int yellowCards;

    @Column(name = "red_cards")
    private int redCards;

    @Column(name = "saves")
    private int saves;

    @Column(name = "bonus")
    private int bonus;

    @Column(name = "bps")
    private int bps;

    @Column(name = "influence")
    private int influence;

    @Column(name = "creativity")
    private int creativity;

    @Column(name = "threat")
    private int threat;

    @Column(name="ict_index")
    private int ictIndex;

    @Column(name = "value")
    private int value;

    @Column(name = "transfers_balance")
    private int transfers_balance;

    @Column(name = "selected")
    private int selected;

    @Column(name = "transfers_in")
    private int transfersIn;

    @Column(name = "transfers_out")
    private int transfersOut;
}
