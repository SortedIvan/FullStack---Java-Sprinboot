package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Role;

import java.util.List;

public interface IUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();

}

