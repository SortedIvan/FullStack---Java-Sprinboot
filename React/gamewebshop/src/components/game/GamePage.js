import {React, useState, useEffect} from 'react';
import { CardDeck } from 'reactstrap';
import GameService from '../../services/GameService';
import GameList from './GameList';
import "/React and Backend GIT/semester3-individual-assignment/React - Individual Assignment/gamewebshop/src/components/game/GamePage.module.css";
import styles from "./GamePage.module.css";
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

      if(games === null){
          return null;
      }

    return (
        <div className = {styles.main_container}>
            
            <CardDeck><GameList games ={games} onDelete = {DeleteGame}></GameList></CardDeck>
            
            </div>   
        

    )
}

export default GamePage



{/* <div>
{games.map((game) => (
    <li key = {game.id}>{game.gameName}</li>
))}

</div> */}

