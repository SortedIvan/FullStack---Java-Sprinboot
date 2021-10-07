package com.fontys.sem3gamewebshop.service;

import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Role;
import com.fontys.sem3gamewebshop.repo.RoleRepo;
import com.fontys.sem3gamewebshop.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService implements IUserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUsername(username);
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
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} to db", user.getUsername());
        user.setPassword(passwordEncoder.encode((user.getPassword() )));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to db", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        log.info("Adding new role {} to user {}", roleName, username);
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);


    }

    @Override
    public AppUser getUser(String username) {
        log.info("Getting user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Getting all users");
        return userRepo.findAll();
    }


}
