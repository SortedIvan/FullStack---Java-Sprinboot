package com.fontys.semester3individualprojectplayvera.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public String gameName;
    public List<GameType> gameTypes;
    public double gameRating;
    public double gameSize;
    public double gamePrice;


    public Game(String gameName, double gameSize, double gamePrice){
        this.gameName = gameName;
        this.gameTypes = new ArrayList<>();
        this.gameSize = gameSize;
        this.gameRating = 0;
        this.gamePrice = gamePrice;
    }


    public String GetGameName(){
        return this.gameName;
    }
    public void SetGameName(String gameName){this.gameName = gameName;}

    public double GetGameRating(){return this.gameRating;}
    public void SetGameRating(double gameRating){this.gameRating = gameRating;}

    public double GetGamePrice(){return this.gamePrice;}
    public void SetGamePrice(double gamePrice){this.gamePrice = gamePrice;}

    public double GetGameSize(){return this.gameSize;}
    public void SetGameSize(double gameSize){this.gameSize = gameSize;}

    public List<GameType> GetGameTypes(){return this.gameTypes;}
    public void SetGameTypes(GameType gameType){this.gameTypes.add(gameType);}


    @Override
    public String toString(){
        return  "Game:" + gameName + " - " + gameSize + "mb";
    }




}


