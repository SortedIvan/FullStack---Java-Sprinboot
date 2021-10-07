package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.model.Game;
import com.fontys.sem3gamewebshop.model.TypeGame;
import com.fontys.sem3gamewebshop.repo.GameRepo;
import com.fontys.sem3gamewebshop.repo.TypeGameRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class GameService implements IGameService{

    private final GameRepo gameRepo;
    private final TypeGameRepo typeGameRepo;


    @Override
    public Game saveGame(Game game) {
        log.info("Saving new game {} to db", game.getGameName());
        return gameRepo.save(game);
    }

    @Override
    public TypeGame saveTypeGame(TypeGame typeGame) {
        log.info("Saving new type of game {} to db", typeGame.getName());
        return typeGameRepo.save(typeGame);
    }

    @Override
    public void addTypeGameToGame(String gameName, String typeGame) {
        log.info("Adding type {} to game {}", typeGame,gameName);
        Game game = gameRepo.findByGameName(gameName);
        TypeGame typeOfGame = typeGameRepo.findByName(typeGame);
        game.getGameTypes().add(typeOfGame);

    }

    @Override
    public Game getGame(String gameName) {
        log.info("Retrieving game {}",gameName );
        return gameRepo.findByGameName(gameName);
    }

    @Override
    public List<Game> getGames() {
        log.info("Getting all games");
        return gameRepo.findAll();
    }
}
