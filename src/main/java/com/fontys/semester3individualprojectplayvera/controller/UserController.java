package com.fontys.semester3individualprojectplayvera.controller;
import com.fontys.semester3individualprojectplayvera.Service.IUserService;
import com.fontys.semester3individualprojectplayvera.repository.FakeDataStore;
import com.fontys.semester3individualprojectplayvera.repository.MainHubController;
import com.fontys.semester3individualprojectplayvera.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService){this.iUserService = iUserService;}

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> GetAllUsers(){
        List<User> users = this.iUserService.GetAllUsers();

        if(users != null){
            return ResponseEntity.ok(users);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username")String username){
        User user = this.iUserService.GetUserByUsername(username);
        if(user != null){
            return ResponseEntity.ok().body(user);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


}
