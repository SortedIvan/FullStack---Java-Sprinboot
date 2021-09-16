package com.fontys.semester3individualprojectplayvera;


import com.fontys.semester3individualprojectplayvera.Service.GameService;
import com.fontys.semester3individualprojectplayvera.model.Game;
import com.fontys.semester3individualprojectplayvera.repository.FakeDataStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameDataTest {

    @Test
    public void GetAllGames_returnAllGamesTest(){
    GameService game = new GameService(new FakeDataStore());
    List<Game> expectedGames = game.GetAllGames();

    Assertions.assertNotNull(expectedGames);


}

    @Test
    public void GetGameByName_getGameByNameTest(){
        GameService game = new GameService(new FakeDataStore());
        Game testGame = game.GetGameByName("CSGO");

        Assertions.assertNotNull(testGame);
    }















}
