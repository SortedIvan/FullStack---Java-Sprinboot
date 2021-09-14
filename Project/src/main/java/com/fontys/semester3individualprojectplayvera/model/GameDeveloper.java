package com.fontys.semester3individualprojectplayvera.model;

import java.util.ArrayList;
import java.util.List;

public class GameDeveloper extends User{

    public List<Game> publishedGames;

    public GameDeveloper(String username, String email, String password, String firstName, String lastName){
        super(username,email,password, firstName, lastName);
        this.publishedGames = new ArrayList<>();


    }

}
