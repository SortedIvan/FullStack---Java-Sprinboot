import {React, useState, useEffect} from 'react';
import { CardDeck } from 'reactstrap';
import authService from '../../services/auth.service';
import GameService from '../../services/GameService';
import userService from '../../services/user.service';
import ProfilePage from '../profile/ProfilePage';
import GameList from './GameList';
import TestGames from './TestGames';

function MyGames(){

    const [profile,setProfile] = useState(null);
   
    useEffect(() => {
        userService.getUserByUsername(authService.getCurrentUser().user).then((response) => {
         setProfile(response.data);
       });
     }, []);

     


    if(profile === null){
        return null;
    }
    return (

        <div>
                HI!
            <TestGames id = {profile.id}/>

        </div>


    );


}
export default MyGames;