import React from 'react'
import { useEffect, useState } from 'react';
import GameService from '../../services/GameService';

function TestGames(props) {

    const [games,setGames] = useState(null);

    useEffect(() => {
         GameService.getGamesByUserId(props.id).then((response) => {
          setGames(response.data);
          console.log(response.data);
        });
      }, [props.id]);


    return (
        <div>
            Hi
        </div>
    )
}

export default TestGames
