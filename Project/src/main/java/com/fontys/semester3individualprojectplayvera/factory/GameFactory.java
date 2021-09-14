package com.fontys.semester3individualprojectplayvera.factory;

import com.fontys.semester3individualprojectplayvera.model.GameType;
import com.fontys.semester3individualprojectplayvera.model.Game;

public class GameFactory {

    public GameFactory(){

    }

    public Game CreateGame(String gameName, double gameSize, double gamePrice){
        Game game = new Game(gameName, gameSize,gamePrice);
        return game;
    }

}
