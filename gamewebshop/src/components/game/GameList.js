import React from "react";
import GameItem from "./GameItem";
import Grid from '@mui/material/Grid';
import Container from '@mui/material/Container';
import SearchBar from "material-ui-search-bar";
import GameService from "../../services/GameService";
import TextField from '@mui/material/TextField';

function GameList(props){
    const handleDelete = (id) =>{
        props.onDelete(id);
    };

    const handleSearch = (gameName) => {
        console.log(gameName);
        props.onSearch(gameName);
    }
    

return(
    <Container sx={{ py: 1 }} maxWidth="md">
        <h1 style = {{marginRight: 50}}><b>Available games</b></h1>
        <TextField  sx={{ m: 1, minWidth: 800, maxWidth: 800}} 
          label="Search for a game"
          id="outlined-size-small" 
          size="small" 
          onChange={(event) => {
             handleSearch(event.target.value)
          }}
      />     
        
        <br/>
          <Grid container spacing={3}>
            {props.games.map((game)=>(
                <GameItem key = {game.id} game = {game} onDelete = {handleDelete} onSearch = {handleSearch}></GameItem>
            ))}
            </Grid>
    </Container>
    )

}

export default GameList;