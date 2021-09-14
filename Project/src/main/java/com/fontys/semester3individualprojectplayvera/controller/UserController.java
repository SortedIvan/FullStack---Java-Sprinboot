package com.fontys.semester3individualprojectplayvera.controller;
import com.fontys.semester3individualprojectplayvera.repository.FakeDataStore;
import com.fontys.semester3individualprojectplayvera.repository.MainHubController;
import com.fontys.semester3individualprojectplayvera.model.User;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final MainHubController mainHubController = new MainHubController();
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GetMapping("/allUsers")
    ResponseEntity<List<User>> getAllUsers() {
        List<User> users = mainHubController.GetUserManager().GetAllUsers();

        if(users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{username}")
    public ResponseEntity<User> getGamePath(@PathVariable(value = "username") String username){
        User user = mainHubController.GetUserManager().GetUserByUsername(username);

        if(user != null){
            return  ResponseEntity.ok().body(user);

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

//      @GetMapping("allUsers")
//      ResponseEntity<List<User>> getAllUsers() {
//          List<User> users = fakeDataStore.GetAllUsers();
//
//        if(users != null) {
//            return ResponseEntity.ok().body(users);
//       } else {
//           return ResponseEntity.notFound().build();
//       }
//    }
//
//
//
//    @GetMapping("{username}")
//    public ResponseEntity<User> getUserPath(@PathVariable(value = "username") String username){
//        User user = fakeDataStore.GetUserByUsername(username);
//
//        if(user != null){
//            return  ResponseEntity.ok().body(user);
//
//        }
//        else{
//            return ResponseEntity.notFound().build();
//        }
//    }




}
