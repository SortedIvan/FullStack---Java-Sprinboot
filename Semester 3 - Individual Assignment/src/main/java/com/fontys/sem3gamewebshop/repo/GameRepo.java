package com.fontys.sem3gamewebshop.repo;

import com.fontys.sem3gamewebshop.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepo extends JpaRepository<Game, Long> {
    Game findByGameName(String gameName);

    @Query(value = "SELECT * FROM games u WHERE app_user_id = ?1",
            nativeQuery = true)
    List<Game> FindGamesByUserID(Long id);


}
