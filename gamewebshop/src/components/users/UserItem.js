import React from 'react';
import {Card, Button, CardGroup, Badge} from 'react-bootstrap';

function UserItem(props){

    return (
        // <Card style={{display: 'flex', justifyContent: 'center', width: '18rem', flex:'4', margin: '3rem'}}>
        //     <Card.Img variant="top" src="./public/unnamed.png"/>
        //          <Card.Body>
        //         <Card.Title>{props.user.gameName}</Card.Title>
        //         <Card.Subtitle>{props.user.gamePlayType}</Card.Subtitle>
        //         <Card.Text>
        //         Some quick example text to build on the card title and make up the bulk of
        //         the card's content.
        //         </Card.Text>
        //     <Button variant="primary">View characteristics{props.user.gamePrice}$</Button>
        //     <Button variant="secondary">Purchase now!{props.user.gamePrice}$</Button>
        //     </Card.Body>
        // </Card>
        <Card style={{ width: '18rem' }}>
             <Card.Body>
                 <Card.Title>{props.user.username} <Badge bg = "secondary">New</Badge></Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">{props.user.email}</Card.Subtitle>
                    <Card.Text>
                        This is a user
                    </Card.Text>
         </Card.Body>
</Card>



    )

}
export default UserItem;
