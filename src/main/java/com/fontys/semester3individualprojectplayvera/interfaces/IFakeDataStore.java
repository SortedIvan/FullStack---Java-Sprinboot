package com.fontys.semester3individualprojectplayvera.interfaces;

import com.fontys.semester3individualprojectplayvera.model.Game;
import com.fontys.semester3individualprojectplayvera.model.User;

import java.util.List;

public interface IFakeDataStore {

    //User methods
    List<User> getAllUsers();
    User GetUserByUsername(String username);
    void ChangeUserPassword(String username, String oldPassword, String newPassword);


    //Game methods
    Game GetGameByName(String gameName);
    List<Game> GetGamesUnder10();
    List<Game> GetGamesUnder20();
    List<Game> getGames();
}
