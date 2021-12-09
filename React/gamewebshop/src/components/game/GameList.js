import React from "react";
import GameItem from "./GameItem";
import Grid from '@mui/material/Grid';
import Container from '@mui/material/Container';
import SearchBar from "material-ui-search-bar";
function GameList(props){
    const handleDelete = (id) =>{
        props.onDelete(id);
    };


return(
    <Container sx={{ py: 1 }} maxWidth="md">
        <h1 style = {{marginRight: 30}}><b>Available games</b></h1>
        <SearchBar/>
        <br/>
          <Grid container spacing={3}>
            {props.games.map((game)=>(
                <GameItem key = {game.id} game = {game} onDelete = {handleDelete}></GameItem>
            ))}
            </Grid>
    </Container>
    )

}

export default GameList;