package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.dal.IGameDAL;
import com.fontys.sem3gamewebshop.model.Game;
import com.fontys.sem3gamewebshop.model.GamePlayType;
import com.fontys.sem3gamewebshop.model.TypeGame;
import com.fontys.sem3gamewebshop.repo.GameRepo;
import com.fontys.sem3gamewebshop.repo.TypeGameRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@Slf4j
public class GameService implements IGameService{

    IGameDAL gameDal;

    @Autowired
    public GameService(IGameDAL gameDal){
        this.gameDal = gameDal;
    }


    @Override
    public Game saveGame(Game game) {
        log.info("Saving new game {} to db", game.getGameName());
        return gameDal.saveGame(game);
    }

    @Override
    public TypeGame saveTypeGame(TypeGame typeGame) {
        log.info("Saving new type of game {} to db", typeGame.getName());
        return gameDal.saveTypeGame(typeGame);
    }

    @Override
    public void addTypeGameToGame(String gameName, String typeGame) {
        log.info("Adding type {} to game {}", typeGame,gameName);
        gameDal.addTypeGameToGame(gameName,typeGame);

    }

    @Override
    public List<Game> getGamesByPlayType(GamePlayType gamePlayType) {
        return gameDal.getGamesByPlayType(gamePlayType);
    }

    @Override
    public Game getGame(String gameName) {
        return gameDal.getGame(gameName);
    }

    @Override
    public List<Game> getGames() {
        log.info("Getting all games");
        return gameDal.getGames();
    }
}
