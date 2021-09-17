package com.fontys.semester3individualprojectplayvera.repository;

import com.fontys.semester3individualprojectplayvera.factory.GameFactory;
import com.fontys.semester3individualprojectplayvera.factory.UserFactory;
import com.fontys.semester3individualprojectplayvera.interfaces.IFakeDataStore;
import com.fontys.semester3individualprojectplayvera.model.Game;
import com.fontys.semester3individualprojectplayvera.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class FakeDataStore implements IFakeDataStore {
    private final UserFactory userFactory = new UserFactory();
    private final GameFactory gameFactory = new GameFactory();
    private final List<Game> games = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public FakeDataStore(){

        this.games.add(this.gameFactory.CreateGame("CSGO", 500, 9));
        this.games.add(this.gameFactory.CreateGame("Amnesia", 400, 7));
        this.games.add(this.gameFactory.CreateGame("Halo", 1300, 40));
        this.games.add(this.gameFactory.CreateGame("Legend of Zelda", 200, 35));

        this.users.add(this.userFactory.CreateUser("vionev", "vionev@gmail.com", "123456", "Victor",
                "Ionev"));
        this.users.add(this.userFactory.CreateUser("hamako", "hamako@gmail.com", "787878", "Hamako",
                "Uchiha"));
        this.users.add(this.userFactory.CreateUser("Andrei2", "andrei2@gmail.com", "ooo123", "Andrei",
                "Petrov"));
    }

    @Override
    public List<Game> getGames(){return this.games;}
    @Override
    public List<User> getAllUsers(){return this.users;}

    @Override
    public User GetUserByUsername(String username) {
        for(User user : users){
            if(user.GetUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void ChangeUserPassword(String username, String oldPassword, String newPassword) {
        User user = GetUserByUsername(username);
        if(user.GetPassword().equals(oldPassword)){
            user.SetPassword(newPassword);
        }
    }

    @Override
    public Game GetGameByName(String gameName) {
        for(Game game : games){
            if(game.GetGameName().equals(gameName)){
                return game;
            }
        }
        return null;
    }

    @Override
    public List<Game> GetGamesUnder10() {
        List<Game> games = new ArrayList<>();
        for(Game game : games){
            if(game.GetGamePrice() < 10){
                games.add(game);
            }
        }
        return games;

    }

    @Override
    public List<Game> GetGamesUnder20() {
        List<Game> games = new ArrayList<>();
        for(Game game : games){
            if(game.GetGamePrice() < 20 && game.GetGamePrice() > 10){
                games.add(game);
            }
        }
        return  games;
    }


//    public void AddGame(String gameName, double gameSize, double gamePrice){
//        this.games.add(this.gameFactory.CreateGame(gameName, gameSize,gamePrice));
//    }
//
//    public void RemoveGame(int index){
//        this.games.remove(index);
//    }
//
//    public void EditGameProperties(String gameName, double gameSize, double gamePrice, int index){
//        this.games.get(index).SetGameName(gameName);
//        this.games.get(index).SetGameSize(gameSize);
//        this.games.get(index).SetGamePrice(gamePrice);
//    }
//
//    public void AddGameType(GameType gameType, int index){
//        this.games.get(index).SetGameTypes(gameType);
//    }
//
//    public void RemoveGameType(int index, int index2){
//        this.games.get(index).GetGameTypes().remove(index2);
//    }
//
//    public Game GetGameFromList(int index){
//        return this.games.get(index);
//    }
//
//    public List<Game> GetAllGames(){
//        return this.games;
//    }
//
//    public Game GetGameByName(String gameName){
//        for(Game game : games){
//            if(game.GetGameName().equals(gameName)){
//                return game;
//            }
//        }
//        return null;
//    }
//
//    public List<Game> GetGamesByRating(double gameRating){
//        List<Game> gamez = new ArrayList<>();
//
//        for(Game game : games){
//            if(game.GetGameRating() <= gameRating || game.GetGameRating() == gameRating || game.GetGameRating() >= gameRating){
//                gamez.add(game);
//            }
//        }
//        return gamez;
//    }
//
//    public List<Game> GetGamesUnder10(){
//        List<Game> games = new ArrayList<>();
//        for(Game game : games){
//            if(game.GetGamePrice() <= 10){
//                this.games.add(game);
//            }
//        }
//        return games;
//    }
//
//    public List<Game> GetGamesUnder20(){
//        List<Game> games = new ArrayList<>();
//        for(Game game : games){
//            if(game.GetGamePrice() >=10 && game.GetGamePrice() <= 20){
//                games.add(game);
//            }
//        }
//        return games;
//    }
//
//    public User GetUserByUsername(String username){
//        for(User u : users){
//            if(u.GetUsername().equals(username)){
//                return u;
//            }
//        }
//        return null;
//    }
//
//    public List<User> GetAllUsers(){
//        return this.users;
//    }
//
//    public User GetUserByEmail(String email){
//        for(User u : users){
//            if(u.GetEmail().equals(email)){
//                return u;
//            }
//        }
//        return null;
//    }
//
//    public void RemoveUser(int index){
//        this.users.remove(index);
//    }
//
//    public void AddUser(String username, String email, String password, String firstName, String lastName){
//        this.users.add(this.userFactory.CreateUser(username,email,password,firstName,lastName));
//    }
//
//    public void EditUser(String email, String firstName, String lastName, int index){
//        this.users.get(index).SetEmail(email);
//        this.users.get(index).SetFirstName(firstName);
//        this.users.get(index).SetLastName(lastName);
//
//    }

}