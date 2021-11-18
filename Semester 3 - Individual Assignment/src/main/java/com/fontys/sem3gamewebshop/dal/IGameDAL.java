package com.fontys.sem3gamewebshop.dal;

import com.fontys.sem3gamewebshop.model.Game;
import com.fontys.sem3gamewebshop.model.GamePlayType;
import com.fontys.sem3gamewebshop.model.TypeGame;

import java.util.List;

public interface IGameDAL{
    Game saveGame(Game game);
    TypeGame saveTypeGame(TypeGame typeGame);
    void addTypeGameToGame(String gameName,String typeGame);
    List<Game> getGamesByPlayType(GamePlayType gamePlayType);
    Game getGame(String gameName);
    List<Game> getGames();
    void deleteGameById(Long id);

}
