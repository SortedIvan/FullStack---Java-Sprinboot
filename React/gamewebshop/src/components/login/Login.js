import React, { Component } from "react";
import { useHistory } from "react-router";
import AuthService from "../../services/auth.service";
import Home from "../home/Home";
import '/React and Backend GIT/semester3-individual-assignment/React - Individual Assignment/gamewebshop/src/components/login/Login.module.css';
const SignIn = () => {
        const [msg, setMsg] = React.useState(null);
        const History = useHistory();
        const username = React.useRef();
        const password = React.useRef();
        function onSubmitClick(){
            History.push("/AboutUs");
        }
        function handleLogin(e){
            e.preventDefault();
            console.log(username.current.value);
                    AuthService.login(username.current.value,password.current.value).then((response) => response.json())
                    .then((responseData) => {
                        console.log(JSON.stringify(responseData));
                        localStorage.setItem("user", JSON.stringify(responseData));
                        History.push("/aboutus");
                        window.location.reload();
                    }).catch(err=>{setMsg("Error");})
          }


        return (
            <div style = {{
                display: 'flex',
                marginTop: '50px',
                justifyContent: 'center',
                alignItems: 'top',
                height: '10vh'
                }}>
                <form onSubmit={handleLogin}>
                <h3>Sign In</h3>

                <div className="form-group">
                    <label>Username </label>
                    <input type="text" className="form-control" placeholder="Enter your username" ref={username}/>
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input type="password" className="form-control" placeholder="Enter your password" ref={password}/>
                </div>

                <div className="form-group">
                    <div className="custom-control custom-checkbox">
                        <input type="checkbox" className="custom-control-input" id="customCheck1" />
                        <label className="custom-control-label" htmlFor="customCheck1">Remember me</label>
                    </div>
                </div>
                
                <br></br>
                <button type="submit" className="btn btn-primary btn-block">Submit</button>
                <p className="forgot-password text-right">
                    Forgot <a href="#">password?</a>
                </p>
                <h1>{msg}</h1>
            </form>
            </div>
            

        );
        }
    
export default SignIn;