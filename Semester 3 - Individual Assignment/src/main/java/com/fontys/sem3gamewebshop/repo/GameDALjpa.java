package com.fontys.sem3gamewebshop.repo;

import com.fontys.sem3gamewebshop.dal.IGameDAL;
import com.fontys.sem3gamewebshop.model.Game;
import com.fontys.sem3gamewebshop.model.GamePlayType;
import com.fontys.sem3gamewebshop.model.TypeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameDALjpa implements IGameDAL {


    GameRepo gameRepo;
    TypeGameRepo typeGameRepo;

    @Autowired
    public GameDALjpa(GameRepo gameRepo, TypeGameRepo typeGameRepo){
        this.gameRepo = gameRepo;
        this.typeGameRepo = typeGameRepo;
    }

    @Override
    public Game saveGame(Game game) {
        return gameRepo.save(game);
    }

    @Override
    public TypeGame saveTypeGame(TypeGame typeGame) {
        return typeGameRepo.save(typeGame);
    }

    @Override
    public void addTypeGameToGame(String gameName, String typeGame) {
    }



    @Override
    public List<Game> getGamesByPlayType(GamePlayType gamePlayType) {
        List<Game> games = gameRepo.findAll();
        List<Game> returnableList = new ArrayList<>();
        for(Game game : games){
            if(game.getGamePlayType().equals(gamePlayType)){
                returnableList.add(game);
            }
        }
        return returnableList;

    }

    @Override
    public Game getGame(String gameName) {
        return gameRepo.findByGameName(gameName);
    }

    @Override
    public List<Game> getGames() {
        return gameRepo.findAll();
    }

    @Override
    public void deleteGameById(Long id) {
        gameRepo.deleteById(id);
    }

    @Override
    public List<GamePlayType> GetAllPlayTypes() {
        List<GamePlayType> playTypes = new ArrayList<>();
        playTypes.add(GamePlayType.SinglePlayer);
        playTypes.add(GamePlayType.Multiplayer);
        return playTypes;
    }

    @Override
    public List<Game> GetGamesByUser(Long id) {
        return gameRepo.FindGamesByUserID(id);
    }

    @Override
    public List<Game> GetGamesByName(String name) {
        return gameRepo.GetGamesByName(name);
    }
}
