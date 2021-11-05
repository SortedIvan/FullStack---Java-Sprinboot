package com.fontys.sem3gamewebshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingID;
    private double rating;
    @JsonIgnore
    @ManyToOne
    private Game game;
}
