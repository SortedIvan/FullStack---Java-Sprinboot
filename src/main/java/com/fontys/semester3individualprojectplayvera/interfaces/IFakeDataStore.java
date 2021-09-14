package com.fontys.semester3individualprojectplayvera.interfaces;

import com.fontys.semester3individualprojectplayvera.model.Game;
import com.fontys.semester3individualprojectplayvera.model.User;

import java.util.List;

public interface IFakeDataStore {
    List<Game> getGames();

    List<User> getAllUsers();
    User GetUserByUsername(String username);

}
