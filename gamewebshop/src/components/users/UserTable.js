import * as React from 'react';
import { DataGrid,GridToolbar } from '@mui/x-data-grid';
import { useEffect, useState, useRef } from "react";
import { IconButton } from '@mui/material';
import Edit from '@material-ui/icons/Edit';
import Delete from '@material-ui/icons/Delete';
import userService from '../../services/user.service';
import { Button } from 'react-bootstrap';
import authService from '../../services/auth.service';

export default function UserTable() {

  
const columns = [
  { field: 'name', headerName: 'Full name', flex:1 },
  { field: 'username', headerName: 'Username', flex:1 },
  { field: 'email', headerName: 'Email', flex:1 },
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

  const handleDelete = (id) => {
    userService.deleteUserByID(id).then((response) => {
      if (response.data !== null) {
       alert("User deleted successfuly.");
       window.location.reload();
      }
    })
    .catch(() => {
      <div className="alert alert-danger" role="alert">
        Houston, we have a problem! Please try again.
      </div>;
    });}
  
  function handleClick(mode, selected){
    switch(mode){
      case 0:
        window.history.pushState({}, '', "/movie/"+selected.row.id);
        break;
      case 1:
        handleDelete(selected.row.id);

        break; 
      default:
        window.history.pushState((selected.row.id));
        break;
    }
  }

    const [users,setUsers] = useState([]);
    const [hidden, setHidden] = useState(false);

    const [isOpen, setIsOpen] = useState(false);

  
    
  
   
 
    const togglePopup = () => {
      setIsOpen(!isOpen);
      setHidden(!hidden);
    }

    useEffect(() => {
        getAllUsers()
    }, [])


    const getAllUsers = () => {
      userService.getAllUsers().then((response) => {
        setUsers(response.data);
        console.log(response.data);
        });
    }   

    users.map((user) => {
      user['id'] = user.id;
    })

    // if(!users) return <NotFound/>;

  return (
    <div style={{ height: 700, width: 'flex' }}>

 
          <DataGrid
          density="comfortable"
          rows={users}
          columns={columns}
          pageSize={5}
          rowsPerPageOptions={[5]}
          disableColumnSelector
          disableMultipleSelection={true}
          disableSelectionOnClick={true} 
          id = "userdata"/>
              
   
    </div>
  );
}