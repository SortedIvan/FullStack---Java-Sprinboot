package com.fontys.sem3gamewebshop.repo;

import com.fontys.sem3gamewebshop.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
    AppUser findByEmail(String email);
}
