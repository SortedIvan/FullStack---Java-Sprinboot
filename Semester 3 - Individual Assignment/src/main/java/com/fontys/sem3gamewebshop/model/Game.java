package com.fontys.sem3gamewebshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String gameName;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<TypeGame> gameTypes = new ArrayList<>();
    private double gameRating;
    private double gameSize;
    private double gamePrice;



    @Override
    public String toString(){
        return  "Game:" + gameName + " - " + gameSize + "mb";
    }

}
