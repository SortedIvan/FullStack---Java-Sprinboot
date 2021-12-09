package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.converters.GameConverter;
import com.fontys.sem3gamewebshop.dal.IAppUserDAL;
import com.fontys.sem3gamewebshop.dal.IGameDAL;
import com.fontys.sem3gamewebshop.dto.GameDTO;
import com.fontys.sem3gamewebshop.model.AppUser;
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
    IAppUserDAL userDal;
    GameConverter gameConverter;
    @Autowired
    public GameService(IGameDAL gameDal, IAppUserDAL userDal, GameConverter gameConverter){
        this.gameDal = gameDal;
        this.userDal = userDal;
        this.gameConverter = gameConverter;
    }




    @Override
    public Game saveGame(GameDTO gameDTO) {
//        log.info("Saving new game {} to db", gameDTO.getGameName());
//        return gameDal.saveGame(gameDTO);
        AppUser appUser = this.userDal.getUser(gameDTO.getAppUser());
        if(appUser != null)
        {
            Game entity = gameConverter.dtoToEntity(gameDTO);
            entity.setAppUser(appUser);
//            appUser.getGameIDs(entity.getId())
            gameDal.saveGame(entity);
        }
        return null;
    }

    @Override
    public List<GamePlayType> GetAllPlayTypes() {
        return gameDal.GetAllPlayTypes();
    }

    @Override
    public List<Game> GetGamesByUser(Long id) {
        return gameDal.GetGamesByUser(id);
    }

    @Override
    public List<Game> GetGamesByName(String name) {
        return gameDal.GetGamesByName(name);
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

    @Override
    public void deleteGameById(Long id) {
        gameDal.deleteGameById(id);
    }
}
