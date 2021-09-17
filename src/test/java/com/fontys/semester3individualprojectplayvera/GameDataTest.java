package com.fontys.semester3individualprojectplayvera;


import com.fontys.semester3individualprojectplayvera.Service.GameService;
import com.fontys.semester3individualprojectplayvera.model.Game;
import com.fontys.semester3individualprojectplayvera.repository.FakeDataStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameDataTest {

    @Test
    public void GetAllGames_returnAllGamesTest(){ //Checks if getting all games works
    GameService game = new GameService(new FakeDataStore());
    List<Game> expectedGames = game.GetAllGames();

    Assertions.assertNotNull(expectedGames);


}

    @Test
    public void GetGameByName_getGameByNameTest(){ //Checks if game can be retrieved by name
        GameService game = new GameService(new FakeDataStore());
        Game testGame = game.GetGameByName("CSGO");

        Assertions.assertNotNull(testGame);
    }

    @Test
    public void GetGamesUnder10_getGamesUnder10Test(){ //Checks if you can retrieve games under 10 dollars
        GameService game = new GameService(new FakeDataStore());
        List<Game> expectedGames = game.GetGamesUnder10();

        Assertions.assertNotNull(expectedGames);
    }


    @Test
    public void GetGamesUnder20_getGamesUnder20Test(){ //Checks if you can retrieve games under 20 dollars
        GameService game = new GameService(new FakeDataStore());
        List<Game> expectedGames = game.GetGamesUnder20();

        Assertions.assertNotNull(expectedGames);
    }










}
