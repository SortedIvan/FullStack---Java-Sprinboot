import React from "react";
import styled from "styled-components";
import {
  Navbar,
  Nav,
  Form,
  FormControl,
  Button,
  Container,
} from "react-bootstrap";
import { Fragment } from "react";


var isLoggedIn = false;
var isUser = false;

const user = JSON.parse(localStorage.getItem("user"));
const Logo = styled.a`
padding: 1rem 0;
color: #7b7fda;
text-decoration: none;
font-weight: 700;
font-size: 1.7rem;

span{
    font-weight: 300;
    font-size: 1.3rem;
}


`;

if (user && user.accessToken) {
  console.log(user.roles)
  isLoggedIn = true;
}

if (user && user.roles.includes("[ROLE_USER]")) {
  isUser = true;
}

const NavigationBar = () => {

function LogOut(){
    localStorage.clear();
}

  let menu = "";

  if (isLoggedIn === false) {
    menu = (
      <Fragment>
        <Nav>
          <Button style={{ float: "right" }} href="/login" id = "loginButton">
            Sign in
          </Button>
          &nbsp;&nbsp;
          <br />
          <Button style={{ float: "right" }} href="/register" id = "registerButton">
            Register
          </Button>
          &nbsp;&nbsp;
          <br />
        </Nav>
      </Fragment>
    );
  } else if (isLoggedIn === true && isUser === false) {
    //is admin
    menu = (
      <Fragment>
         <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: "200px"}}
              navbarScroll
              
            >
              <Nav.Link href = "/mygames"> My Games</Nav.Link>
              &nbsp;&nbsp;
              <Nav.Link href="/users">All users</Nav.Link>
         </Nav>
        <Nav>
          <Button href="/profile">Your account</Button>
          &nbsp;&nbsp;
          <br />
          </Nav>
          <Nav>
          <Button href="/sign-out" onClick = {LogOut} id = "SignOutButton">Sign out</Button>
          &nbsp;&nbsp;
          <br />
        </Nav>
      </Fragment>
    );
  } else if (isLoggedIn === true && isUser === true) {
    //is user
    menu = (
      <Fragment>
           <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: "200px"}}
              navbarScroll>
            <Nav.Link href = "/mygames" id = "myGames"> My Games</Nav.Link>
            &nbsp;&nbsp;
            <Nav.Link href="/complaints"id = "sendComplaint">Send a complaint</Nav.Link>
         </Nav>
        <Nav>
          <Button href="/profile" id = "yourAccount">Your account</Button>
          &nbsp;&nbsp;
          <br />
          </Nav>
          <Nav>
          <Button href="/sign-out"  onClick = {LogOut} id = "signOut" >Sign out</Button>
          &nbsp;&nbsp;
          <br />
        </Nav>
      </Fragment>
    );
  }

  return (
    <div className="playvera">
      <Navbar bg="light" expand="lg" variant="light">
        <Container fluid>
          <Logo href="/AboutUs">Play<span>vera</span></Logo>
          
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
          <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: "200px"}}
              navbarScroll
              
            >
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <Nav.Link href="/AboutUs">About us</Nav.Link>
              <Nav.Link href="/games">All Games</Nav.Link>
              <Nav.Link href="/creategame" id = "createGame">Add your own game</Nav.Link>
              <Nav.Link href = "/chat">Chat</Nav.Link>
           
            </Nav>

            <Nav>{menu}</Nav>

          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
};

export default NavigationBar;
