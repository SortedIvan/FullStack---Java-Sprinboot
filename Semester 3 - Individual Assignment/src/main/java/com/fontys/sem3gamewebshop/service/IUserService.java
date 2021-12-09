package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.dto.AppUserDTO;
import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Role;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    void saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
    Optional<AppUser> findUserById(Long id);
    AppUser findUserByEmail(String email);
    void changeUserPassword(String username,String oldPassword, String newPassword);
    AppUserDTO GetUserDTO(String username);
    List<AppUserDTO> GetAllUserInformation();
    AppUserDTO ConvertUserToDTO(AppUser appUser);
    Collection<Role> GetRoles(String username);
    void deleteUser(Long id);
    boolean editUser(AppUser appUser);

}

