package com.fontys.semester3individualprojectplayvera.model;
import com.fontys.semester3individualprojectplayvera.model.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class User {

public String username;
public String email;
public String password;
public String firstName;
public String lastName;
public List<Game> favouriteGames;


public User(String username, String email, String password, String firstName, String lastName){
    this.username = username;
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.favouriteGames = new ArrayList<>();

}

public List<String> getAllUserAttributes(){
    List<String> userAttributes = new ArrayList<>();
    userAttributes.add(email);
    userAttributes.add(firstName);
    userAttributes.add(lastName);

    return userAttributes;
}

public String GetUsername(){
    return this.username;
}
public void SetUsername(String username){
    this.username = username;
}

public String GetEmail(){
    return this.email;
}
public void SetEmail(String email){
        this.email = email;
    }

public String GetPassword() {return this.password;}
public void SetPassword(String password){this.password = password;}

public String GetFirstName(){return this.firstName;}
public void SetFirstName(String firstName){this.firstName = firstName;}

public String GetLastName(){return this.lastName;}
public void SetLastName(String firstName){this.firstName = firstName;}

public List<Game> GetFavouriteGames(){
    return this.favouriteGames;
}

public void AddGameToFavouriteList(int index, Game game){
    this.favouriteGames.add(index, game);
}

public void RemoveGameFromFavouriteList(int index){
    this.favouriteGames.remove(index);
}

public Game GetFavouriteGameFromList(int index){
    return this.favouriteGames.get(index);
}


public Game GetFavouriteGameByName(String favouriteGameName){
    for(Game game : favouriteGames){
        if(game.GetGameName().equals(favouriteGameName)){
            return game;
        }
    }
    return null;
}


    public String toString() {
        return "User{" +
                "userName=" + this.username +
                ", name='" + this.email + '\'' +
                '}';
    }


}
