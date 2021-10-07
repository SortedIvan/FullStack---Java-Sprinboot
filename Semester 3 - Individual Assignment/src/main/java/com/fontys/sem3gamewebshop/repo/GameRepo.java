package com.fontys.sem3gamewebshop.repo;

import com.fontys.sem3gamewebshop.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Long> {
    Game findByGameName(String gameName);



}
