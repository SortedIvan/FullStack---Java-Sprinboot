import {React, useState, useEffect} from 'react';
import { CardDeck } from 'reactstrap';
import userService from '../../services/user.service';
import UserTable from './UserTable';
import UserList from './UserList';

function UserPage() {
    const [users, setUsers] = useState(null);



    useEffect(() => {
        userService.getAllUsers().then((response) => {
          console.log(response.data);
          setUsers(response.data);
        });
      }, []);

      function DeleteUser(id){
          const newUsers = [...users];
          const index = newUsers.indexOf(id);
          newUsers.splice(index, 1);
          userService.deleteGame(id);
          setUsers(newUsers);
      }

      if(users === null){
          return null;
      }
    return (
        <section>
            {/* <h1>All Users</h1>
            <CardDeck style={{display: 'flex', flexDirection: 'row'}}><UserList users ={users} onDelete = {DeleteUser}></UserList></CardDeck> */}
            <UserTable users = {users}/>
            
        </section>

    )
}

export default UserPage;