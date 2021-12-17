import React from 'react';
import { useState } from 'react';
import Popup from '../popup/Popup';
// import Card from '../UI/Card';
import { Link } from 'react-router-dom';
// import {Card, Button, CardGroup} from 'react-bootstrap';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
// import Link from '@mui/material/Link';
// import unnamed from '.../public/unnamed.png'
import PositionedSnackbar from '../alerts/PositionedSnackbar';
import Snackbar from '@mui/material/Snackbar';
import BasicRating from '../rating/BasicRating';

function GameItem(props){
  const [isOpen, setIsOpen] = useState(false);
 
  const togglePopup = () => {
    setIsOpen(!isOpen);
  }
  const [state, setState] = React.useState({
    open: false,
    vertical: 'top',
    horizontal: 'center',
  });

  const { vertical, horizontal, open } = state;

  const handleClick = (newState) => () => {
    setState({ open: true, ...newState });
  };

  const handleClose = () => {
    setState({ ...state, open: false });
  };
 
    return (    
              <Grid item key={props.game.gameName} xs={10} sm={3} md={4}>
                <Card
                  sx={{ height: '100%', display: 'flex', flexDirection: 'column' }} id = "gamecontainer"
                >
                  <CardMedia
                    component="img"
                    height="194"
                    image="https://source.unsplash.com/random"
                    alt="random"
                  />
                  <CardContent sx={{ flexGrow: 1 }}>
                    <Typography gutterBottom variant="h5" component="h2">
                     {props.game.gameName}
                    </Typography>
                    <Typography>
                      {props.game.description}
                      <br/>
                      <br/>
                      <b>{props.game.gameType}</b>
                    </Typography>
                    <BasicRating/>
                  </CardContent>
                  <CardActions>
                    <Button size="small" onClick = {togglePopup} id = "systemRequirements">Does <br/> it run?</Button>
                    {isOpen && <Popup id = "systemrequirements"
                      content={<>
                       <b>System requirements</b>
                       <br/>
                        {props.game.systemRequirements}
                      </>}
                      />}
                    <Button id = "getGame" size="small" onClick={handleClick({
                       vertical: 'top',
                        horizontal: 'center',
                        })}>Get game!</Button>
                        <Snackbar
                         anchorOrigin={{ vertical, horizontal }}
                        open={open}
                        onClose={handleClose}
                         message="Game added successfuly"
                        key={vertical + horizontal}
                      />
                  </CardActions>
                </Card>
              </Grid>
          
        // <Card style={{display: 'block', justifyContent: 'center', width: '18rem', flex:'1', margin: '3rem'}}>
        //     <Card.Img variant="top" src={window.location.origin + '/unnamed.png'}/>
        //          <Card.Body>
        //         <Card.Title>{props.game.gameName}</Card.Title>
        //         <Card.Subtitle>{props.game.gamePlayType}</Card.Subtitle>
        //         <Card.Text>
        //         Some quick example text to build on the card title and make up the bulk of
        //         the card's content.
        //         </Card.Text>
        //     <Button variant="primary">View characteristics{props.game.gamePrice}$</Button>
        //     <Button variant="secondary">Purchase now!{props.game.gamePrice}$</Button>
        //     </Card.Body>
        // </Card>



    )

}
export default GameItem;
