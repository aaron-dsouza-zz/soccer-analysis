package com.socceranalysis.metrics.producer.model.player;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fpl_player")
public class Player {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @SerializedName(value = "first_name")
    private String firstName;

    @Column(name = "second_name")
    @SerializedName(value = "second_name")
    private String secondName;
}
