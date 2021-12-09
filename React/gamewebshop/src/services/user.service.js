import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/";

const username = localStorage.getItem("username");

// const getUserByUsername =(username)=>{
//     console.log("HEADER: "+ authHeader());
//     console.log("USERNAME: "+username);
//     var axios = require('axios');
//     var qs = require('qs');
//     var data = qs.stringify({
//     });
//     var config = {
//         method: 'get',
//         url: 'http://localhost:8080/api/'+username,
//         headers:{
//             'Authorization': 'Bearer ' + authHeader()
            
//         },
//         data : data
//     };

//     axios(config)
//     .then(function(response){
//         console.log(JSON.stringify(response.data));
//         localStorage.setItem("user ", JSON.stringify(response.data));
//         console.log("hi " + JSON.stringify(response.data));
//         return response.data;
//     })
//     .catch(function(error){
//         console.log(error);
//     });
    
// };

const getPublicContent = () => {
  return axios.get(API_URL + "users");
};

const getAllUsers = () =>{
  return axios.get("http://localhost:8080/api/users", {headers:authHeader()});
}

const getUserBoard = () => {
  return axios.get(API_URL + "user", { headers: authHeader() });
};

const getModeratorBoard = () => {
  return axios.get(API_URL + "mod", { headers: authHeader() });
};

const getAdminBoard = () => {
  return axios.get(API_URL + "admin", { headers: authHeader() });
};

const getUserByUsername = (username) => {
  return axios.get("http://localhost:8080/api/user/username/" + username, {
    headers: authHeader(),
  });
}

const editUser = (profile) => {
  return axios.put("http://localhost:8080/api/user/edit", profile ,{ headers: authHeader() });
};

const deleteUserByID = (id) => {
return axios.delete("http://localhost:8080/api/user/delete/" + id, {headers: authHeader()});
}


export default {
  getPublicContent,
  getUserBoard,
  getModeratorBoard,
  getAdminBoard,
  getUserByUsername,
  getAllUsers,
  editUser,
  deleteUserByID
};
