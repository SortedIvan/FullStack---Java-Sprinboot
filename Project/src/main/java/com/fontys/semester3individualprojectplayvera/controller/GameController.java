package com.fontys.semester3individualprojectplayvera.controller;
import com.fontys.semester3individualprojectplayvera.repository.FakeDataStore;
import com.fontys.semester3individualprojectplayvera.repository.MainHubController;

import java.util.List;

import com.fontys.semester3individualprojectplayvera.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/games")
public class GameController {

    private static final MainHubController mainHubController = new MainHubController();
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GetMapping("/allGames")
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = mainHubController.GetGameManager().GetAllGames();

        if(games != null) {
            return ResponseEntity.ok().body(games);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{gameName}")
    public ResponseEntity<Game> GetGameByNamePath(@PathVariable(value = "gameName") String gameName){
        Game game = mainHubController.GetGameManager().GetGameByName(gameName);

        if(game != null){
            return  ResponseEntity.ok().body(game);

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/Under10Bucks")
    public ResponseEntity<List<Game>> getAllGamesUnder10() {
        List<Game> games = mainHubController.GetGameManager().GetGamesUnder10();

        if(games != null) {
            return ResponseEntity.ok().body(games);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/Under20Bucks")
    public ResponseEntity<List<Game>> getAllGamesUnder20() {
        List<Game> games = mainHubController.GetGameManager().GetGamesUnder20();

        if(games != null) {
            return ResponseEntity.ok().body(games);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



//    @GetMapping("/allGames")
//    public ResponseEntity<List<Game>> GetAllGames(){
//        List<Game> games = fakeDataStore.GetAllGames();
//
//        if(games != null){
//            return  ResponseEntity.ok().body(games);
//        }
//        else{
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("{gameName}")
//    public ResponseEntity<Game> GetGameByName(@PathVariable(value = "gameName") String gameName){
//        Game game = fakeDataStore.GetGameByName(gameName);
//
//        if(game != null){
//            return ResponseEntity.ok().body(game);
//        }
//        else{
//            return ResponseEntity.notFound().build();
//        }
//    }






}
