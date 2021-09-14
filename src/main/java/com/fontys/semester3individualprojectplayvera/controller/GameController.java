package com.fontys.semester3individualprojectplayvera.controller;
import com.fontys.semester3individualprojectplayvera.Service.IGameService;
import com.fontys.semester3individualprojectplayvera.repository.FakeDataStore;
import com.fontys.semester3individualprojectplayvera.repository.MainHubController;

import java.util.List;

import com.fontys.semester3individualprojectplayvera.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    IGameService iGameService;

    @Autowired
    public GameController(IGameService iGameService) {this.iGameService = iGameService;}

    @GetMapping("/allGames")
    public ResponseEntity<List<Game>> GetAllGames(){
        List<Game> games = iGameService.GetAllGames();

        if(games != null){
            return ResponseEntity.ok().body(games);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }







}
