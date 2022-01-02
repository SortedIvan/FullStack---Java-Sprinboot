package com.fontys.sem3gamewebshop.repo;

import com.fontys.sem3gamewebshop.dal.IAppUserDAL;
import com.fontys.sem3gamewebshop.dto.AppUserDTO;
import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AppUserDALjpa implements IAppUserDAL {

    UserRepo repository;
    RoleRepo roleRepo;
    @Autowired
    public AppUserDALjpa(UserRepo repository, RoleRepo roleRepo){
        this.repository = repository;
        this.roleRepo = roleRepo;

    }


    @Override
    public AppUser saveUser(AppUser user) {
        return repository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = this.repository.findByUsername(username);
        Role role = this.roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        return this.repository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return this.repository.findAll();
    }

    @Override
    public AppUser findUserById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public void changeUserPassword(String username, String oldPassword, String newPassword) {
        AppUser user = this.repository.findByUsername(username);
        user.SetPassword(newPassword,oldPassword);
    }

    @Override
    public AppUserDTO GetUserDTO(String username) {
        return ConvertUserToDTO(this.repository.findByUsername(username));
    }

    @Override
    public List<AppUserDTO> GetAllUserInformation() {
        return repository.findAll()
                .stream()
                .map(this::ConvertUserToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDTO ConvertUserToDTO(AppUser appUser) {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setUsername(appUser.getUsername());
        appUserDTO.setEmail(appUser.getEmail());
        appUserDTO.setGameIDs(appUser.getGameIDs());
        return appUserDTO;
    }

    @Override
    public Collection<Role> GetRoles(String username) {
        AppUser appUser = repository.findByUsername(username);
        return appUser.getRoles();
    }

    @Override
    public void deleteUser(Long id) {
        for(AppUser appUser : this.repository.findAll()){
            if(appUser.getId().equals(id)){
                this.repository.delete(appUser);
            }
        }
    }

    @Override
    public boolean editUser(AppUser appUser) {
        AppUser updatedUser = this.findUserById(appUser.getId());
        updatedUser.setUsername(appUser.getUsername());
        updatedUser.setEmail(appUser.getEmail());
        updatedUser.setName(appUser.getName());
        updatedUser.setGameIDs(appUser.getGameIDs());
        updatedUser.setPassword(appUser.getPassword());
        updatedUser.setRoles(appUser.getRoles());
        updatedUser.setId(appUser.getId());
        updatedUser.setGameIDs(appUser.getGameIDs());
        this.repository.save(updatedUser);
        return true;
    }
}
