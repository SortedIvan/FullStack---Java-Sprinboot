package com.fontys.semester3individualprojectplayvera.factory;
import com.fontys.semester3individualprojectplayvera.model.User;


public class UserFactory {

    public UserFactory(){

    }

    public User CreateUser(String username, String email, String password, String firstName, String lastName){
        User user = new User(username,email,password,firstName,lastName);
        return user;
    }

}
