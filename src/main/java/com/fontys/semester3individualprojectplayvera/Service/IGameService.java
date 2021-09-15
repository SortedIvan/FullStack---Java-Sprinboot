package com.fontys.semester3individualprojectplayvera.Service;

import com.fontys.semester3individualprojectplayvera.model.Game;

import java.util.List;

public interface IGameService {
    List<Game> GetAllGames();
    Game GetGameByName(String gameName);
    List<Game> GetGamesUnder10();

}
