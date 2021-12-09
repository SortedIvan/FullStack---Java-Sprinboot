import React, { Component } from 'react'
import { withRouter, useHistory} from 'react-router-dom';
import authService from '../../services/auth.service';
import {Button} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import styled from "styled-components";
import {Navbar, Nav, NavDropdown} from 'react-bootstrap';

class Header extends Component {
    handleClickAbout = () =>{
        this.props.history.push("/AboutUs")
    }
    handleClickGame = () =>{
        this.props.history.push("/games")
    }
    handleClickLogin =()=>{
        this.props.history.push("/login")
    }
    handleClickRegister = () =>{
        this.props.history.push("/register")
    }

    logOut = () =>{
        localStorage.clear();
        this.props.history.push("/login");
    }
    
    

    render() {
const CustomButton = styled.button`
background-color: turquoise; 
border: none; 
border-radius: 5px; 
color: #333;
padding: 15px 32px;
`;

const Hamburger = styled.div``;
const Menu = styled.div`
display: flex;
justify-content: space-between;
align-items: center;
position: relative;
`;
        
const Navs = styled.div`
padding: 0 2rem;
display: flex;
justify-content:space-between;
align-items: center;
flex-wrap: wrap;
background: cyan;
`;
const Logo = styled.a`
padding: 1rem 0;
color: #7b7fda;
text-decoration: none;
font-weight: 700;
font-size: 1.7rem;

span{
    font-weight: 300;
    font-size: 1.3rem;
}`;
        return (
            <Navs>
                <Logo href = "">
                Play<span>vera</span>
                </Logo>
                <Hamburger>
                        <span />
                        <span />
                        <span />
                </Hamburger>
                <Menu>
                &nbsp;&nbsp;
                <CustomButton onClick = {this.handleClickAbout}>About us</CustomButton>
                &nbsp;&nbsp;
                <CustomButton onClick = {this.handleClickGame}>All Games</CustomButton>
                &nbsp;&nbsp;
                <CustomButton onClick = {this.handleClickLogin}>Login</CustomButton>
                &nbsp;&nbsp;
                <CustomButton onClick = {this.handleClickRegister}>Register</CustomButton>
                </Menu>
            </Navs>

        )
    }




}
export default withRouter(Header);