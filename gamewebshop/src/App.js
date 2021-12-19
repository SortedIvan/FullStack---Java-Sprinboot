
import React, { Component, useState, useEffect } from "react";
import { Switch, Route, Link, BrowserRouter } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
//import "./App.css";
import SignIn from "./components/login/Login";
import Header from './components/header/Header';
import Home from "./components/home/Home";
import About from "./components/about/About";
import GamePage from "./components/game/GamePage";
import Register from "./components/register/Register";
import Navbar from "./components/navbar/Navbar";
import NavigationBar from "./components/NavigationBar/NavigationBar";
import UserPage from "./components/users/UserPage";
import AboutUs from "./components/about/AboutUs";
import CreateGame from "./components/game/GamePost";
import ProfilePage from "./components/profile/ProfilePage";
import { AccountProfile } from "./components/profile/AccountProfile";
import { AccountProfileDetails } from "./components/profile/AccountProfileDetails";
import MyGames from "./components/game/MyGames";
// import Chat from "./chat/Chat";
import ChatComponent from "./chat/ChatComponent";
import GameTable from "./components/game/GameTable";
import Chatbot from "react-chatbot-kit";
import ChatBotComponent from "./ChatBot/ChatBotComponent";
export default class App extends Component {
  render() {
    return (
      <div className = "App">
        <NavigationBar/>
        {/* <Header/> */}
        <Switch>
        <Route exact path = "/register" component = {Register}/>
        <Route exact path = "/login" component = {SignIn}/>
        <Route path = "/AboutUs" component = {AboutUs}/>
        <Route path = "/games" component = {GamePage}/>
        <Route path = "/users" component = {UserPage}/>
        <Route path = "/creategame" component = {CreateGame}/>
        <Route path = "/profile" component = {AccountProfileDetails}/>
        <Route path = "/mygames" component = {GameTable}/>
        <Route path = "/chat" component = {ChatComponent}/>
        <Route path = "/u" component = {GameTable}/>
        <Route path = "/chatbot" component={ChatBotComponent}/>

        </Switch>



        

      </div>
    )
  }
}
