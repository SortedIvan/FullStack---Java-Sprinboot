package com.fontys.sem3gamewebshop.api;

import com.fontys.sem3gamewebshop.dto.GameDTO;
import com.fontys.sem3gamewebshop.model.*;
import com.fontys.sem3gamewebshop.service.IGameService;
import com.fontys.sem3gamewebshop.service.IUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    private final IGameService iGameService;
    private final IUserService iUserService;
    @Autowired
    public GameController(IGameService iGameService, IUserService iUserService){
        this.iGameService = iGameService;
        this.iUserService = iUserService;
    }

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getGames(){
        return ResponseEntity.ok().body(iGameService.getGames());
    }

//    @PostMapping("/game/save")
//    public ResponseEntity<GameDTO> saveGames(@RequestBody GameDTO game){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/game/save").toUriString());
//        return ResponseEntity.created(uri).body(iGameService.saveGame(game));
//    }
    @PostMapping("/savegame")
    public ResponseEntity<GameDTO> saveGame(@RequestBody GameDTO game){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser loggedInUser = this.iUserService.getUser(authentication.getName());
        game.setAppUser(loggedInUser.getUsername());
        if(game == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }else{
            iGameService.saveGame(game);
            return ResponseEntity.ok().build();
        }
    }

    @PostMapping("/typeOfGame/save")
    public ResponseEntity<TypeGame> saveTypeOfGame(@RequestBody TypeGame typeOfGame){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(iGameService.saveTypeGame(typeOfGame));
    }

    @PostMapping("/typeOfGame/addtogame")
    public ResponseEntity<?> addTypeGameToGame(@RequestBody TypeToGameForm form){
        iGameService.addTypeGameToGame(form.getGameName(),form.getTypeOfGame());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/game/deletegame/{id}")
    public ResponseEntity<?> deleteGameByID(@PathVariable("id") Long id){
        iGameService.deleteGameById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/game/gametypes")
    public ResponseEntity<List<GamePlayType>> GetAllPlayTypes(){
        return ResponseEntity.ok().body(iGameService.GetAllPlayTypes());
    }

    @GetMapping("/game/mygames/{id}")
    public ResponseEntity<List<Game>> GetGamesByUserID(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(iGameService.GetGamesByUser(id));
    }

    @GetMapping("/games/find/{name}")
    public ResponseEntity<List<Game>> GetGamesByName(@PathVariable("name") String name){
        return ResponseEntity.ok().body(iGameService.GetGamesByName(name));
    }


}


@Data
class TypeToGameForm{
    private String gameName;
    private String typeOfGame;
}
