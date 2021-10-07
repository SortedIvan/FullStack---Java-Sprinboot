package com.fontys.sem3gamewebshop.repo;

import com.fontys.sem3gamewebshop.model.TypeGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeGameRepo extends JpaRepository<TypeGame, Long> {

    TypeGame findByName(String name);


}
