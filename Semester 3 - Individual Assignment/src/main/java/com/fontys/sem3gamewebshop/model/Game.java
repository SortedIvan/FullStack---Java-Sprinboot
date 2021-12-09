package com.fontys.sem3gamewebshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Data @AllArgsConstructor @NoArgsConstructor @Entity @Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;
    @Column(name = "gamename")
    private String gameName;

    @Column(name = "gameType")
    private String gameType;
    @Column(name = "gamesize")
    private double gameSize;
    @Column(name = "gameprice")
    private double gamePrice;
    @Column(name = "gameplaytype")
    private GamePlayType gamePlayType;
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToOne
    private AppUser appUser;


    @ElementCollection
    private Collection<String> systemRequirements = new ArrayList<>();



    @Override
    public String toString(){
        return  "Game:" + gameName + " - " + gameSize + "mb";
    }

}
