import axios from "axios";
import authHeader from "./auth-header";


    class GameService{

    getAllGames(){
        return axios.get("http://localhost:8080/api/games", {headers:authHeader()});
    }

    getCurrentUser(){
        return JSON.parse(localStorage.getItem("user"));
    }

    deleteGame(gameID){
        return axios.delete("http://localhost:8080/api/game/deletegame/" + gameID, {headers:authHeader()});
    }

    saveGame(game){
        return axios.post("http://localhost:8080/api/savegame", game, {headers:authHeader()});
    }

    getAllGameTypes(){
        return axios.get("http://localhost:8080/api/game/gametypes", {headers:authHeader()});
    }

    getGamesByUserId(id){
        return axios.get("http://localhost:8080/api/game/mygames/" + id, {headers: authHeader()});
    }

    getGamesByname(name){
        return axios.get("http://localhost:8080/api/games/find/"+ name, {headers:authHeader()});
    }

    getRandomNumber(){
        return Math.floor((Math.random() * 10) + 1);
    }
}
    export default new GameService;