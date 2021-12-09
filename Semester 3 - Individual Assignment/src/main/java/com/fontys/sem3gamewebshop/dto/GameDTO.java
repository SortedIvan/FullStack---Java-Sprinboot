package com.fontys.sem3gamewebshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.GamePlayType;
import com.fontys.sem3gamewebshop.model.TypeGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class GameDTO {
    private String gameName;
    private double gameSize;
    private double gamePrice;
    private String gameType;
    private String appUser;
    private GamePlayType gamePlayVariant;
    private Collection<String> systemRequirements = new ArrayList<>();
    private String description;
}
