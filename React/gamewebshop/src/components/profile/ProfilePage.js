import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import { Row, Col, InputGroup } from "react-bootstrap";
import { React,useEffect, useState, Fragment, useRef} from "react";



function ProfilePage(){

    const [user,setUser] = useState(null);
    useEffect(() => {                                               
      const username = JSON.parse(localStorage.getItem("user"));
      
      if(username && username.user){
      setUser(username.user);
      }
    }, []);
    
    const [validated, setValidated] = useState(false);

    const handleSubmit = (event) => {
      const form = event.currentTarget;
      if (form.checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
      }
  
      setValidated(true);
    };


    return(
        <div className = 'top-profile'>
        <Fragment>
        <Form.Label>Welcome back,<span/> {user} </Form.Label>
        </Fragment>
        <br/>
        {/* <Form.Group>
        <Form.Label>Username: </Form.Label>
        <Form.Control type="text" placeholder="Game size: "/>
        </Form.Group>
        <br/>
        <Form.Group>
        <Form.Label>Email: </Form.Label>
        <Form.Control type="text" placeholder="Game size: "/>
        </Form.Group>
        <br/> */}
            <Form noValidate validated={validated} onSubmit={handleSubmit}>
      <Row className="mb-3">
        <Form.Group as={Col} md="4" controlId="validationCustom01">
          <Form.Label>Username</Form.Label>
          <Form.Control
            required
            type="text"
            placeholder="Username: "
            defaultValue={user}
          />
          <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
        </Form.Group>
        <Form.Group as={Col} md="4" controlId="validationCustom02">
          <Form.Label>Email</Form.Label>
          <Form.Control
            required
            type="text"
            placeholder="Email: "
            defaultValue="Otto"
          />
          <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
        </Form.Group>
      </Row>
    </Form>
     



        </div>




    );
}
export default ProfilePage;