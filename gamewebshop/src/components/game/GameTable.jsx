import * as React from 'react';
import { DataGrid,GridToolbar } from '@mui/x-data-grid';
import { useEffect, useState, useRef } from "react";
import { IconButton } from '@mui/material';
import Edit from '@material-ui/icons/Edit';
import Delete from '@material-ui/icons/Delete';
import userService from '../../services/user.service';
import authService from '../../services/auth.service';
import GameService from '../../services/GameService';
import { Button } from 'react-bootstrap';
import NotFound from '../notfound/NotFound';

function GameTable() {
  const getAllGames = (profileID) => {
    GameService.getGamesByUserId(profileID).then((response) => {
      setGames(response.data);
      console.log(response.data);
      });
  }  

  const [games,setGames] = useState([]);
  const [hidden, setHidden] = useState(false);
  const [isOpen, setIsOpen] = useState(false);
  const [profile,setProfile] = useState("");
  
 
  useEffect(() => {
      userService.getUserByUsername(authService.getCurrentUser().user).then((response) => {
       setProfile(response.data);
       getAllGames(response.data.id)
     });
     
   }, [authService.getCurrentUser().user]);
  

const columns = [
  { field: 'gameName', headerName: 'Game name', flex:1 },
  { field: 'gameSize', headerName: 'Game size', flex:1 },
  { field: 'gamePrice', headerName: 'Game price', flex:1 },
  {
    field: "Actions",
    flex:1,
    renderCell: (cellValues) => {
      return (
        <div>
        <IconButton aria-label="edit" onClick={()=>{handleClick(0,cellValues)}}>
          <Edit/>
        </IconButton>
        <IconButton aria-label="delete" onClick={()=>{handleClick(1,cellValues)}}>
          <Delete/>
        </IconButton>
        </div>
      );
    }
  },
  ];

//   function deleteMovie(id) {
//     const newMovies = [...movies];
//     const index = newMovies.indexOf(id);
//     newMovies.splice(index, 1);
//     MovieService.deleteMovie(id);
//     setMovies(newMovies);
//   }
  
  function handleClick(mode, selected){
    switch(mode){
      case 0:
        window.history.pushState({}, '', "/movie/"+selected.row.id);
        break;
      default:
        window.history.pushState((selected.row.id));
        break;
    }
  }


  
   
 
    const togglePopup = () => {
      setIsOpen(!isOpen);
      setHidden(!hidden);
    }




 

    games.map((game) => {
      game['id'] = game.id;
    })

  if(profile.id === null){
    return <NotFound/>
  }
  if(!games){
    return <NotFound/>
  }
/////
  return (
    <div style={{ height: 700, width: 'flex' }}>

 
          <DataGrid
          getRowId={row => row.id}
          density="comfortable"
          rows={games}
          columns={columns}
          pageSize={5}
          rowsPerPageOptions={[5]}
          disableColumnSelector
          disableMultipleSelection={true}
          disableSelectionOnClick={true} />
              
   
    </div>
  );
}
export default GameTable;