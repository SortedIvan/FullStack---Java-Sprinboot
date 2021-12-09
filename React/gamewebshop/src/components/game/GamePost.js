import { useEffect, useState, Fragment, useRef } from "react";
import React from 'react';
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import authService from "../../services/auth.service";
// import Card from '../UI/Card';
// import {Card, Button, CardGroup} from 'react-bootstrap';
// import Link from '@mui/material/Link';
// import unnamed from '.../public/unnamed.png'
import PositionedSnackbar from '../alerts/PositionedSnackbar';
import Snackbar from '@mui/material/Snackbar';
import { useHistory } from "react-router-dom";
import GameService from "../../services/GameService";
import Container from '@mui/material/Container';


  var isLoggedIn = false;

  if(authService.getCurrentUser() !== null){
      isLoggedIn = true;
  }
  const CreateGame = () => { 
    const [user,setUser] = useState(null);
    useEffect(() => {                                               
      const username = JSON.parse(localStorage.getItem("user"));
      
      if(username && username.user){
      setUser(username.user);
      }
    }, []);
    useEffect(() => {
      GameService.getAllGameTypes().then((response) => {
        console.log(response.data);
        setType(response.data);
      });
    }, []);
    const [gameTypes, setType] = useState([]);
    const [selectedType, setSelectedType] = useState([]);

    const history = useHistory();

     const handleChangeGenre = (e) => {
      let obj = e.target.value; //genre object
      console.log(obj);
      setSelectedType(obj);
    };

    const gameName = useRef();
    const gameSize = useRef();
    const gamePrice = useRef();
    const gamePlayType = useRef();
    const description = useRef();
    const gamePlayVariant = useRef();
    // const sentDate = useRef();

    const handleSubmit = (e) => {
      e.preventDefault();
     
    const gameNameRef = gameName.current.value;
    const gameSizeRef = gameSize.current.value;
    const gamePriceRef = gamePrice.current.value;
    const gamePlayTypeRef = gamePlayType.current.value;
    const appUserRef = localStorage.getItem("user");
    const descriptionRef = description.current.value;
    const gamePlayVariantRef = selectedType;
    
    const game = 
    {
      gameName : gameNameRef,
      gameSize : gameSizeRef,
      gamePrice : gamePriceRef,
      gamePlayType : gamePlayTypeRef,
      appUser : appUserRef,
      description : descriptionRef,
      gamePlayVariant : gamePlayVariantRef
    }
    console.log(game);
    GameService.saveGame(game);
    history.push("/games");
    }
  
    let menu = '';

  // if(isLoggedIn === false){
  //     menu = (
  //       <Fragment>
  //       <Form.Group>
  //       <Form.Label>Email </Form.Label>
  //       <Form.Control type="email" placeholder="Write your email..." />
  //       </Form.Group>
  //       </Fragment>
  //     )
  // } 
  if(isLoggedIn === true) {
      menu = (
        <Fragment>
        <Form.Label><b>Please input the details of your game:</b> </Form.Label> <br/>
        </Fragment>
      )
  }
  if(!user){
    return <h1>Error 404, page not found</h1>
  }
  else
  {
  return (
     
    <Container sx={{ py: 1 }} maxWidth="md">
      <Form onSubmit = {handleSubmit}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          {menu}
        </Form.Group>
        <Form.Group>
        <Form.Label>Game name</Form.Label>
        <Form.Control type="text" ref={gameName} placeholder="Write a game name..." required/>
        </Form.Group>
        <br/>
        <Form.Group>
        <Form.Label>Game size</Form.Label>
        <Form.Control type="text" ref={gameSize} placeholder="Game size: " required/>
        </Form.Group>
        <br/>
        <Form.Group>
        <Form.Label>Game price</Form.Label>
        <Form.Control type="text" ref={gamePrice} placeholder="Game price: " required/>
        </Form.Group>
        <br/>
        <Form.Group>
        <Form.Label>Game play type: </Form.Label>
        <Form.Control type="text" ref={gamePlayType} placeholder="Game play type: " required/>
        </Form.Group>
        <br/>
        <Form.Group>
        <Form.Label>Game description: </Form.Label>
        <Form.Control type="text" ref={description} placeholder="Game description: " required/>
        </Form.Group>
        <br/>
        <Form.Label>Genre: </Form.Label>
          <br />
          <Form.Group>
          <Form.Control as="select" onChange={handleChangeGenre} required>
            <option value=""> -- Select a play type -- </option>
            {gameTypes.map((option, index) => (
              <option key={index} value={option} ref={gamePlayVariant}>
                {option}
              </option>
            ))}
          </Form.Control>
        </Form.Group>
        <br/>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </Container>
  );
};
  }

export default CreateGame;