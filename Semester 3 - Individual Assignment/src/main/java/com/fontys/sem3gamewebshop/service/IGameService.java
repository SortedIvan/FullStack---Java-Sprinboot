package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.dto.GameDTO;
import com.fontys.sem3gamewebshop.model.*;

import java.util.List;

public interface IGameService {
//    Game saveGame(Game game);
    TypeGame saveTypeGame(TypeGame typeGame);
    void addTypeGameToGame(String gameName,String typeGame);
    List<Game> getGamesByPlayType(GamePlayType gamePlayType);
    Game getGame(String gameName);
    List<Game> getGames();
    void deleteGameById(Long id);
    Game saveGame(GameDTO gameDTO);
    List<GamePlayType> GetAllPlayTypes();
    List<Game> GetGamesByUser(Long id);
    List<Game> GetGamesByName(String name);

}
