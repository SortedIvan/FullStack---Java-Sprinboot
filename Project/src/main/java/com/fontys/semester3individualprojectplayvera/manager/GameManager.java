package com.fontys.semester3individualprojectplayvera.manager;

import com.fontys.semester3individualprojectplayvera.factory.GameFactory;
import com.fontys.semester3individualprojectplayvera.model.Game;
import com.fontys.semester3individualprojectplayvera.model.GameType;

import java.util.ArrayList;
import java.util.List;



public class GameManager {

    private List<Game> games;
    private GameFactory gameFactory;

    public GameManager(){
        this.games = new ArrayList<>();
        this.gameFactory = new GameFactory();
    }

    public void AddGame(String gameName, double gameSize, double gamePrice){
        this.games.add(this.gameFactory.CreateGame(gameName, gameSize,gamePrice));
    }

    public void RemoveGame(int index){
        this.games.remove(index);
    }

    public void EditGameProperties(String gameName, double gameSize, double gamePrice, int index){
        this.games.get(index).SetGameName(gameName);
        this.games.get(index).SetGameSize(gameSize);
        this.games.get(index).SetGamePrice(gamePrice);
    }

    public void AddGameType(GameType gameType, int index){
        this.games.get(index).SetGameTypes(gameType);
    }

    public void RemoveGameType(int index, int index2){
        this.games.get(index).GetGameTypes().remove(index2);
    }

    public Game GetGameFromList(int index){
        return this.games.get(index);
    }

    public List<Game> GetAllGames(){
        return this.games;
    }

    public Game GetGameByName(String gameName){
        for(Game game : games){
            if(game.GetGameName().equals(gameName)){
                return game;
            }
        }
        return null;
    }

    public List<Game> GetGamesByRating(double gameRating){
        List<Game> games = new ArrayList<>();

        for(Game game : games){
            if(game.GetGameRating() <= gameRating || game.GetGameRating() == gameRating || game.GetGameRating() >= gameRating){
                games.add(game);
            }
        }
        return games;
    }

    public List<Game> GetGamesUnder10(){
        List<Game> games = new ArrayList<>();
        for(Game game : games){
            if(game.GetGamePrice() <= 10){
                this.games.add(game);
            }
        }
        return games;
    }

    public List<Game> GetGamesUnder20(){
        List<Game> games = new ArrayList<>();
        for(Game game : games){
            if(game.GetGamePrice() >=10 && game.GetGamePrice() <= 20){
                games.add(game);
            }
        }
        return games;
    }

}
