import React from 'react'
import styled from "styled-components";

const Navbar = () => {
    return (
        <Nav>
        <Logo href = "">
            Play<span>vera</span>
        </Logo>
        <Hamburger>
            <span />
            <span />
            <span />
        </Hamburger>
        <Menu>
        <MenuLink href = "">About us</MenuLink>
        <MenuLink href = "">Browse Games</MenuLink>
        <MenuLink href = "">Forums</MenuLink>
        <MenuLink href = "">Contact us</MenuLink>
        </Menu>
        </Nav>

    )
}

const Nav = styled.div`
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
}


`;
const Hamburger = styled.div``;
const Menu = styled.div`
display: flex;
justify-content: space-between;
align-items: center;
position: relative;


`;
const MenuLink = styled.a`
padding: 1rem 2rem;



`;

export default Navbar;