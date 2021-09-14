package com.fontys.semester3individualprojectplayvera.manager;

import com.fontys.semester3individualprojectplayvera.factory.UserFactory;
import com.fontys.semester3individualprojectplayvera.model.User;
import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users;
    private UserFactory userFactory;

    public UserManager(){
        this.users = new ArrayList<>();
        this.userFactory = new UserFactory();

    }


    public User GetUserByUsername(String username){
        for(User u : users){
            if(u.GetUsername().equals(username)){
                return u;
            }
        }
        return null;
    }

    public List<User> GetAllUsers(){
        return this.users;
    }

    public User GetUserByEmail(String email){
        for(User u : users){
            if(u.GetEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    public void RemoveUser(int index){
        this.users.remove(index);
    }

    public void AddUser(String username, String email, String password, String firstName, String lastName){
        this.users.add(this.userFactory.CreateUser(username,email,password,firstName,lastName));
    }

    public void EditUser(String email, String firstName, String lastName, int index){
        this.users.get(index).SetEmail(email);
        this.users.get(index).SetFirstName(firstName);
        this.users.get(index).SetLastName(lastName);

    }


}
