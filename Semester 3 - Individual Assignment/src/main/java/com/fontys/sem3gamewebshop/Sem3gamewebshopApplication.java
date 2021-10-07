package com.fontys.sem3gamewebshop;

import com.fontys.sem3gamewebshop.model.AppUser;
import com.fontys.sem3gamewebshop.model.Game;
import com.fontys.sem3gamewebshop.model.Role;
import com.fontys.sem3gamewebshop.model.TypeGame;
import com.fontys.sem3gamewebshop.service.IGameService;
import com.fontys.sem3gamewebshop.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class Sem3gamewebshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sem3gamewebshopApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner run(IUserService iUserService, IGameService igameService){
        return args -> {

            //User creation
            iUserService.saveRole(new Role(null,"ROLE_USER"));
            iUserService.saveRole(new Role(null,"ROLE_GAMEDEV"));
            iUserService.saveRole(new Role(null,"ROLE_ADMIN"));

            iUserService.saveUser(new AppUser(null, "Ivan Ovcharov", "ivan2e","ivan@gmail.com", "12345", new ArrayList<>()));
            iUserService.saveUser(new AppUser(null, "Hamako Yutai", "hamako","tom123@gmail.com", "12345", new ArrayList<>()));
            iUserService.saveUser(new AppUser(null, "Boriz Tunai", "boriz1","boriz@gmail.com", "12345", new ArrayList<>()));


            iUserService.addRoleToUser("ivan2e", "ROLE_USER");
            iUserService.addRoleToUser("hamako", "ROLE_GAMEDEV");
            iUserService.addRoleToUser("boriz1", "ROLE_ADMIN");
            iUserService.addRoleToUser("boriz1", "ROLE_GAMEDEV");
            iUserService.addRoleToUser("boriz1", "ROLE_USER");

            //Game creation
            igameService.saveTypeGame(new TypeGame(null,"ARCADE"));
            igameService.saveTypeGame(new TypeGame(null,"HORROR"));
            igameService.saveTypeGame(new TypeGame(null,"SCI_FI"));
            igameService.saveTypeGame(new TypeGame(null,"ADVENTURE"));
            igameService.saveTypeGame(new TypeGame(null,"SURVIVAL"));

            igameService.saveGame(new Game(null,"Zelda", new ArrayList<>(), 5,500,19.99));
            igameService.saveGame(new Game(null,"Halo", new ArrayList<>(), 4.5,5010,29.99));
            igameService.saveGame(new Game(null,"Rust", new ArrayList<>(), 3.4,2300,29.99));
            igameService.saveGame(new Game(null,"Amnesia", new ArrayList<>(), 5,300,24.99));

            igameService.addTypeGameToGame("Zelda","ADVENTURE");
            igameService.addTypeGameToGame("Halo","SCI_FI");
            igameService.addTypeGameToGame("Rust","SURVIVAL");
            igameService.addTypeGameToGame("Amnesia","HORROR");
            igameService.addTypeGameToGame("Amnesia","ADVENTURE");

        };
    }

}