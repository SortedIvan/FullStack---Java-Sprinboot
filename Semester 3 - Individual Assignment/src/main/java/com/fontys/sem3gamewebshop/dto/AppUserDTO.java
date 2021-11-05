package com.fontys.sem3gamewebshop.dto;

import com.fontys.sem3gamewebshop.model.Game;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Data
public class AppUserDTO {
    private Long id;
    private String email;
    private String username;
    @OneToMany(targetEntity = Game.class, cascade = CascadeType.ALL)
    private Collection<Long> gameIDs = new ArrayList<>();


}
