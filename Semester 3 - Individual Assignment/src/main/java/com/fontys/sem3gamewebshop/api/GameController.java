package com.fontys.sem3gamewebshop.api;

import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Game;
import com.fontys.sem3gamewebshop.model.Role;
import com.fontys.sem3gamewebshop.model.TypeGame;
import com.fontys.sem3gamewebshop.service.IGameService;
import com.fontys.sem3gamewebshop.service.IUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GameController {

    private final IGameService iGameService;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getGames(){
        return ResponseEntity.ok().body(iGameService.getGames());
    }

    @PostMapping("/game/save")
    public ResponseEntity<Game> saveGames(@RequestBody Game game){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/game/save").toUriString());
        return ResponseEntity.created(uri).body(iGameService.saveGame(game));
    }

    @PostMapping("/typeOfGame/save")
    public ResponseEntity<TypeGame> saveTypeOfGame(@RequestBody TypeGame typeOfGame){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api//role/save").toUriString());
        return ResponseEntity.created(uri).body(iGameService.saveTypeGame(typeOfGame));
    }

    @PostMapping("/typeOfGame/addtogame")
    public ResponseEntity<?> addRoleToUser(@RequestBody TypeToGameForm form){
        iGameService.addTypeGameToGame(form.getGameName(),form.getTypeOfGame());
        return ResponseEntity.ok().build();
    }




}


@Data
class TypeToGameForm{
    private String gameName;
    private String typeOfGame;
}
