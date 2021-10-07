package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Game;
import com.fontys.sem3gamewebshop.model.Role;
import com.fontys.sem3gamewebshop.model.TypeGame;

import java.util.List;

public interface IGameService {
    Game saveGame(Game game);
    TypeGame saveTypeGame(TypeGame typeGame);
    void addTypeGameToGame(String gameName,String typeGame);
    Game getGame(String gameName);
    List<Game> getGames();


}
