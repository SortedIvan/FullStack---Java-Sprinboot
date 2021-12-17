import { useState, useEffect } from 'react';
import userService from '../../services/user.service';
import AuthService from "../../services/auth.service";
import { useHistory } from 'react-router';
import Container from '@mui/material/Container';
import {
  Box,
  Button,
  Card,
  CardContent,
  CardHeader,
  Divider,
  Grid,
  TextField,
  Avatar,
  CardActions,
  Typography
} from '@mui/material';
import authService from '../../services/auth.service';

  
 export const AccountProfileDetails = (props) => {
  const [profile,setProfile] = useState("");
   
    useEffect(() => {
      
        userService.getUserByUsername(AuthService.getCurrentUser().user).then((response) => {
            setProfile(response.data);
            
        });
    }, [])    

  const handleChange = (event) => {
    setProfile({
      ...profile,
      [event.target.name]: event.target.value
    });
  };

  const history = useHistory();


  const handleSubmitForm = (profile) => {
      userService.editUser(profile);
      
      console.log(profile);

  }

  return (
    <Container sx={{ py: 1 }} maxWidth="md">
    <form
      autoComplete="off"
      noValidate
      {...props}
      onClick = {handleSubmitForm(profile)}
    >
        <Card {...props}>
      <CardContent>
        <Box
          sx={{
            alignItems: 'center',
            display: 'flex',
            flexDirection: 'column'
          }}
        >
          <Avatar
            // src={profile.avatar}
            src = "https://source.unsplash.com/random"
            sx={{
              height: 64,
              mb: 2,
              width: 64
            }}
          />
          <Typography
            color="textPrimary"
            gutterBottom
            variant="h5"
            id = "profileName"
          >
            {profile.name}
          </Typography>
          <Typography
            color="textSecondary"
            variant="body2"
          >
            {/* {`${profile.address}`} */}
            <p>Proud indie developper</p>
          </Typography>
        </Box>
      </CardContent>
      <Divider />
      <CardActions>
        <Button
        id = "uploadPicture"
          color="primary"
          fullWidth
          variant="text"
        >
          Upload picture
        </Button>
      </CardActions>
    </Card>
      <Card>
        <Divider />
        <CardContent>
          <Grid
            container
            spacing={3}
          >
            <Grid
              item
              md={6}
              xs={12}
            >
              <TextField
                InputLabelProps={{
                shrink: true,
                 }}      
                fullWidth
                label="Full name: "
                name="name"
                onChange={handleChange}
                value={profile.name}
                id = "profileNameInput"
          
              />
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
              <TextField
                InputLabelProps={{
                shrink: true,
                }}  
                fullWidth
                label="Username:"
                name="username"
                onChange={handleChange}
                readonly
                value={profile.username}
                id = "profileNameUsername"
              />
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
              <TextField
                InputLabelProps={{
                    shrink: true,
                  }}
                fullWidth
                label="Email: "
                name="email"
                onChange={handleChange}
                value={profile.email}
                id = "profileNameEmail"
              />
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
            </Grid>
          </Grid>
        </CardContent>
        <Divider />
        <Box
          sx={{
            display: 'flex',
            justifyContent: 'flex-end',
            p: 2
          }}
        >
          <Button
            color="primary"
            variant="contained"
            id = "saveAccount"
          >
            Save
          </Button>
        </Box>
      </Card>
    </form>
    </Container>
  );
};