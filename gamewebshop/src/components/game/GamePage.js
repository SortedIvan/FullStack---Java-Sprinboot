import {React, useState, useEffect} from 'react';
import { CardDeck } from 'reactstrap';
import GameService from '../../services/GameService';
import GameList from './GameList';
import SearchBar from "material-ui-search-bar";
function GamePage() {
    const [games, setGames] = useState(null);



    useEffect(() => {
        GameService.getAllGames().then((response) => {
          console.log(response.data);
          setGames(response.data);
        });
      }, []);

      function DeleteGame(id){
          const newGames = [...games];
          const index = newGames.indexOf(id);
          newGames.splice(index, 1);
          GameService.deleteGame(id);
          setGames(newGames);
      }

      function FindGamesByName(gameName){
          if(gameName === ""){
            GameService.getAllGames().then((response) => {
                console.log(response.data);
                setGames(response.data);
              });
            
          }
        GameService.getGamesByname(gameName).then((response) => {
            setGames(response.data);
          });
    }

      if(games === null){
          return null;
      }

    return (
        <div id="allGames">
            
            <CardDeck><GameList games ={games} onDelete = {DeleteGame} onSearch = {FindGamesByName}></GameList></CardDeck>
        </div>   
        

    )
}

export default GamePage



{/* <div>
{games.map((game) => (
    <li key = {game.id}>{game.gameName}</li>
))}

</div> */}

