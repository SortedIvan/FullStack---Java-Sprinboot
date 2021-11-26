package com.fontys.sem3gamewebshop;


import com.fontys.sem3gamewebshop.converters.GameConverter;
import com.fontys.sem3gamewebshop.dal.IAppUserDAL;
import com.fontys.sem3gamewebshop.dal.IGameDAL;
import com.fontys.sem3gamewebshop.dto.GameDTO;
import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Game;
import com.fontys.sem3gamewebshop.model.GamePlayType;
import com.fontys.sem3gamewebshop.model.TypeGame;
import com.fontys.sem3gamewebshop.service.GameService;
import com.fontys.sem3gamewebshop.service.IGameService;
import com.fontys.sem3gamewebshop.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class GameServiceMockTest {
    @Mock
    IGameDAL gameDAL;
    @Mock
    IAppUserDAL iAppUserDAL;

    @Mock
    GameConverter gameConverter;
    @BeforeEach
    public void setUp(){
        AppUser ivanTest = new AppUser(null, "Ivan Test", "ivantest", "ivan@gmail.com", "12345", new ArrayList<>(), new ArrayList<>());
        List<Game> games = List.of(
                new Game(null, "Mario", "Adventure", 500, 19.99, GamePlayType.SinglePlayer, ivanTest, new ArrayList<>()),
                new Game(null, "Zelda", "Adventure", 400, 29.99, GamePlayType.Multiplayer, ivanTest, new ArrayList<>()),
                new Game(null, "AdventureGame", "Action", 900, 39.99, GamePlayType.SinglePlayer, ivanTest, new ArrayList<>()),
                new Game(null, "Rust", "Survival", 1000, 59.99, GamePlayType.Multiplayer, ivanTest, new ArrayList<>())



        );

        Game game = new Game(null, "Mario", "Adventure", 500, 19.99, GamePlayType.SinglePlayer, ivanTest, new ArrayList<>());
        Game game2 =  new Game(null, "AdventureGame", "Action", 900, 39.99, GamePlayType.SinglePlayer, ivanTest, new ArrayList<>());
        List<Game> testGames = new ArrayList<>();
        testGames.add(game);
        List<Game> testGames2 = new ArrayList<>();
        testGames2.add(game2);
        when(gameDAL.getGames()).thenReturn(games);
        when(gameDAL.getGamesByPlayType(GamePlayType.SinglePlayer)).thenReturn(testGames);
        when(gameDAL.getGamesByPlayType(GamePlayType.Multiplayer)).thenReturn(testGames2);
    }

    @Test
    public void getAllGamesTest(){
        GameService gameService = new GameService(gameDAL, iAppUserDAL, gameConverter);
        List<Game> games = gameService.getGames();
        Assertions.assertEquals(games.get(0).getGameName(), "Mario");
        Assertions.assertEquals(games.get(1).getGameName(), "Zelda");
        Assertions.assertEquals(games.get(2).getGameName(), "AdventureGame");
        Assertions.assertEquals(games.get(3).getGameName(), "Rust");
    }


    @Test
    public void changeGamePlayType(){
        GameService gameService = new GameService(gameDAL, iAppUserDAL, gameConverter);
        List<Game> games = gameService.getGames();
        Game game = games.get(0);
        game.setGamePlayType(GamePlayType.Multiplayer);
        Assertions.assertEquals(game.getGamePlayType(), GamePlayType.Multiplayer);

    }
//
//
    @Test
    public void saveGame(){
        GameService gameService = new GameService(gameDAL, iAppUserDAL, gameConverter);
        AppUser ivanTest = new AppUser(null, "Ivan Test", "ivantest", "ivan@gmail.com", "12345", new ArrayList<>(), new ArrayList<>());
        GameDTO game = new GameDTO("Mario", 300, 25, "Adventure", ivanTest.getUsername(), GamePlayType.Multiplayer,new ArrayList<>());
        gameService.saveGame(game);
        ArgumentCaptor<Game> gameArgumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDAL).saveGame(gameArgumentCaptor.capture());
        Game captureGame = gameArgumentCaptor.getValue();
        Assertions.assertEquals(game.getGameName(), captureGame.getGameName());
    }
//
//    @Test
//    public void getGameByGameType(){
//        GameService gameService = new GameService(gameDAL, iAppUserDAL, gameConverter);
//        AppUser ivanTest = new AppUser(null, "Ivan Test", "ivantest", "ivan@gmail.com", "12345", new ArrayList<>(), new ArrayList<>());
//        Game game = new Game(null, "Mario", new ArrayList<>(), 500, 19.99, GamePlayType.SinglePlayer, ivanTest, new ArrayList<>());
//        gameService.saveGame(game);
//        List<Game> games = new ArrayList<>();
//        games.add(game);
//        Assertions.assertEquals(gameService.getGamesByPlayType(GamePlayType.SinglePlayer).get(0).getGameName(), games.get(0).getGameName());
//    }
//
//    @Test
//    public void changeGameType(){
//        GameService gameService = new GameService(gameDAL, iAppUserDAL, gameConverter);
//        AppUser ivanTest = new AppUser(null, "Ivan Test", "ivantest", "ivan@gmail.com", "12345", new ArrayList<>(), new ArrayList<>());
//        Game game = new Game(null, "Mario", new ArrayList<>(), 500, 19.99, GamePlayType.SinglePlayer, ivanTest, new ArrayList<>());
//        gameService.saveGame(game);
//        List<Game> games = List.of(
//                new Game(null, "Mario", new ArrayList<>(), 500, 19.99, GamePlayType.Multiplayer, ivanTest, new ArrayList<>())
//        );
//
//        gameService.getGamesByPlayType(GamePlayType.SinglePlayer).get(0).setGamePlayType(GamePlayType.Multiplayer);
//        Assertions.assertEquals(gameService.getGamesByPlayType(GamePlayType.Multiplayer), games);
//    }

}
