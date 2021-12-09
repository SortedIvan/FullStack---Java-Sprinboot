import React, { Component } from 'react'
import { Carousel } from 'react-bootstrap';
import authService from '../../services/auth.service'
import styled from "styled-components";
import {
  Navbar,
  Nav,
  Form,
  FormControl,
  Button,
  Container,
  small
} from "react-bootstrap";

export default class About extends Component {
    render() {
        return (
            
            <div>
                <div class="page-header">
                <h1>Welcome to Playvera <small>Subtext for header</small></h1>
                </div>
            </div>
         
        )
    }
}
