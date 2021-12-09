package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.dal.IAppUserDAL;
import com.fontys.sem3gamewebshop.dto.AppUserDTO;
import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Role;
import com.fontys.sem3gamewebshop.repo.RoleRepo;
import com.fontys.sem3gamewebshop.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service @Transactional @Slf4j
public class UserService implements IUserService, UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private IAppUserDAL dal;

    @Autowired
    public UserService(IAppUserDAL dal, PasswordEncoder passwordEncoder){

        this.dal = dal;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public AppUserDTO ConvertUserToDTO(AppUser appUser){
        return dal.ConvertUserToDTO(appUser);
    }

    @Override
    public Collection<Role> GetRoles(String username) {
        return dal.GetRoles(username);
    }

    @Override
    public void deleteUser(Long id) {
        this.dal.deleteUser(id);
    }

    @Override
    public boolean editUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        this.dal.editUser(appUser);
        return true;
    }

    @Override
    public List<AppUserDTO> GetAllUserInformation(){
        return dal.GetAllUserInformation();
    }
    @Override
    public AppUserDTO GetUserDTO(String username){
        return dal.GetUserDTO(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = dal.getUser(username);
        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        else{
            log.info("User found in the database: {}", username);

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public void saveUser(AppUser user) {

        log.info("Saving new user {} to db", user.getUsername());
        user.setPassword(passwordEncoder.encode((user.getPassword() )));
        dal.saveUser(user);
        dal.addRoleToUser(user.getUsername(),"ROLE_USER");
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to db", role.getName());
        return dal.saveRole(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        log.info("Adding new role {} to user {}", roleName, username);
        dal.addRoleToUser(username,roleName);


    }

    @Override
    public AppUser getUser(String username) {
        log.info("Getting user {}", username);
        return dal.getUser(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Getting all users");
        return dal.getUsers();
    }

    @Override
    public Optional<AppUser> findUserById(Long id) {
        return findUserById(id);
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return dal.findUserByEmail(email);
    }

    @Override
    public void changeUserPassword(String username, String oldPassword, String newPassword) {
        dal.changeUserPassword(username,oldPassword,newPassword);
    }


}
