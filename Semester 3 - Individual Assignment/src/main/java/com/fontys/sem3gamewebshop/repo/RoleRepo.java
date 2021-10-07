package com.fontys.sem3gamewebshop.repo;

import com.fontys.sem3gamewebshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);

}